package com.guozz.practise.json.chapter3.subTypes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-7
 * Time: 上午10:11
 * To change this template use File | Settings | File Templates.
 */
public class SerializeExmaple {

    public static void main(String[] args) throws Exception {
        Zoo zoo = new Zoo("SH Wild Park", "ShangHai");
        Lion lion = new Lion("Samba");
        Elephant elephant = new Elephant("Manny");
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(lion);
        animals.add(elephant);
        zoo.setAnimals(animals);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        //mapper.writeValue(new File("zoo.json"), zoo);
        mapper.writerFor(new TypeReference<List<Animal>>() {
        }).writeValue(new File("animal.json"), animals);
    }
}
