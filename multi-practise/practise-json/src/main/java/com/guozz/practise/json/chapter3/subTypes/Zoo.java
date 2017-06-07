package com.guozz.practise.json.chapter3.subTypes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-7
 * Time: 上午10:05
 * To change this template use File | Settings | File Templates.
 */
public class Zoo {

    /** 名称 */
    public String name;
    /** 城市 */
    public String city;
    /** 动物 */
    public List<Animal> animals;

    @JsonCreator
    public Zoo(@JsonProperty("name") String name, @JsonProperty("city") String city) {
        this.name = name;
        this.city = city;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo [name=" + name + ", city=" + city + ", animals=" + animals
                + "]";
    }
}
