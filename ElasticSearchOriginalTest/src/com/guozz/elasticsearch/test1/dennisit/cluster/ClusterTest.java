package com.guozz.elasticsearch.test1.dennisit.cluster;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

/**在运行该测试实例时,已经在本地建立了对应的索引库datum*/
public class ClusterTest {

	public static void main(String[] args) {
		//当你启动一个节点,它会自动加入同网段的es集群,一个前提就是es的集群名(cluster.name)这个参数要设置一致。
        String clusterName = "elasticsearch_pudp"; //集群结点名称
        
        /**
         * 默认的话启动一个节点,es集群会自动给它分配一些索引的分片,如果你想这个节点仅仅作为一个客户端而不去保存数据,
         * 你就可以设置把node.data设置成false或 node.client设置成true。
         */
        Node node = NodeBuilder.nodeBuilder().clusterName(clusterName).client(true).node(); 
        
        //启动结点,加入到指定集群
        node.start();
        
        //获取节点搜索端,使用prepareGet搜索datum索引库中 索引类型为datum,的索引记录唯一id值为150得记录
        GetResponse response = node.client().prepareGet("datum", "datum", ""+150).execute().actionGet();
        
        //对象映射模型
        ObjectMapper mapper = new ObjectMapper();
        //将搜索结果response中的值转换成指定的对象模型,Datum是自己建立的一个咨询Model对象
        Datum datum= mapper.convertValue(response.getSource(), Datum.class);
        
        //打印检索结果中获取的对象相应的属性
        System.out.println("资讯标题:"+datum.getTitle() );
        
        //关闭结点
        node.close();
	}
}
