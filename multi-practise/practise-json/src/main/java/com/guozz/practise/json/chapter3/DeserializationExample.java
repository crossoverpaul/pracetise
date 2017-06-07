package com.guozz.practise.json.chapter3;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-7
 * Time: 上午9:40
 * To change this template use File | Settings | File Templates.
 */
public class DeserializationExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); //禁止未知属性打断反序列化

        Company company = mapper.readValue(new File("company.json"), Company.class);
        System.out.print("company_name:"+company.getName()+"\t");
        System.out.print("headquarters:"+company.getHeadQuarters()+"\t");
        System.out.println("birthDate:"+company.getBirthDate()); //birthDate被标记为@JsonIgnore，所以此处得到的值应该为null

        Department[] departments = company.getDepartments();

        for (Department department : departments) {
            System.out.print("department_name:" + department.getName()+"\t");
            System.out.print("employee_number:" + department.getPm()+"\t");
            //Department中未定义的字段product,employee_number
            System.out.print("product:"+department.get("product")+"\t");
            System.out.println("projectManager:"+department.get("employee_number"));
        }
    }
}
