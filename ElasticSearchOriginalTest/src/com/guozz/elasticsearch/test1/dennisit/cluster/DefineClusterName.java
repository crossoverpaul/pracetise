package com.guozz.elasticsearch.test1.dennisit.cluster;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class DefineClusterName {

	/**在运行该测试实例时,已经在本地建立了对应的索引库datum*/
    public static void main(String[] args) {
        
        //自定义集群结点名称
        String clusterName = "elasticsearch_pudongping"; 
        
        //程序中更改集群结点名称
        Settings settings = ImmutableSettings.settingsBuilder()
        .put("cluster.name", clusterName).build();
        
        //创建集群,绑定集群内的机器
        TransportClient client = new TransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress("192.168.0.149", 9300));
        client.addTransportAddress(new InetSocketTransportAddress("192.168.0.162", 9300));
        
        //搜索
        GetResponse response = client.prepareGet("datum", "datum", ""+130)
          .execute()
          .actionGet();
        
        ObjectMapper mapper = new ObjectMapper();
        Datum datum= mapper.convertValue(response.getSource(), Datum.class);
        
        System.out.println("资讯标题:"+datum.getTitle() );
        
        //关闭结点
        client.close();    
    }
}
