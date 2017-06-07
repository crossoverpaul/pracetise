package com.guozz.practise.json.chapter3.subTypes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-7
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */
public class DeserializeExmaple {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Zoo zoo = mapper.readValue(new File("zoo.json"), Zoo.class);
        System.out.println(zoo);
    }
}
