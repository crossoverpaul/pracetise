package com.guozz.elasticsearch.test1.dennisit.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import com.guozz.elasticsearch.test1.dennisit.data.Medicine;


public class JsonUtil {

	/**
     * 实现将实体对象转换成json对象
     * @param medicine    Medicine对象
     * @return
     */
    public static String obj2JsonData(Medicine medicine){
        String jsonData = null;
        try {
            //使用XContentBuilder创建json数据
            XContentBuilder jsonBuild = XContentFactory.jsonBuilder();
            jsonBuild.startObject()
            .field("id",medicine.getId())
            .field("name", medicine.getName())
            .field("funciton",medicine.getFunction())
            .endObject();
            jsonData = jsonBuild.string();
            //System.out.println(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }
    /**
     * 将任意对象转换成json
     * @param object
     * @return
     */
    public static String object2Json(Object object){
    	ObjectMapper mapper = new ObjectMapper();  
		 String json="";
		try {
			json = mapper.writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return json;
    }
}
