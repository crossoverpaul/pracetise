package com.guozz.practise.json.chapter3.subTypes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-7
 * Time: 上午10:05
 * To change this template use File | Settings | File Templates.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,include = JsonTypeInfo.As.PROPERTY,property = "@class")
//@JsonSubTypes({@JsonSubTypes.Type(value=Lion.class,name="lion"),@JsonSubTypes.Type(value=Elephant.class,name="elephant")})
public abstract class Animal {

    /** 名称 */
    String name;
    /** 类型 */
    String type;

}
