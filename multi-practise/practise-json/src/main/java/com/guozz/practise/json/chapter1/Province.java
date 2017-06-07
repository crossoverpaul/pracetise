package com.guozz.practise.json.chapter1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-6
 * Time: 下午6:51
 * To change this template use File | Settings | File Templates.
 */
public class Province implements java.io.Serializable{

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /** 名称 */
    public String name;
    /** 人口 */
    public int population;
    /** 城市 */
    public String[] city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String[] getCity() {
        return city;
    }

    public void setCity(String[] city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", city=" + Arrays.toString(city) +
                '}';
    }
}
