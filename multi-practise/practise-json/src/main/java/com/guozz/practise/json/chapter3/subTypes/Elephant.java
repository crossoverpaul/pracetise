package com.guozz.practise.json.chapter3.subTypes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-7
 * Time: 上午10:08
 * To change this template use File | Settings | File Templates.
 */
public class Elephant extends Animal{

    private String name;

    @JsonCreator
    public Elephant(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return "herbivorous";
    }

    @Override
    public String toString() {
        return "Elephant [getName()=" + getName() + ", getType()=" + getType()
                + "]";
    }
}
