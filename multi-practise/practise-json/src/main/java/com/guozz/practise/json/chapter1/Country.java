package com.guozz.practise.json.chapter1;

import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-6
 * Time: 下午6:53
 * To change this template use File | Settings | File Templates.
 */
public class Country implements Serializable{

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /** 城市id */
    private String country_id;
    /** 出生日期 */
    private Date birthDate;
    /** 国家 */
    private List<String> nation = new ArrayList<String>();
    /** 湖 */
    private String[] lakes;
    /** 省 */
    private List<Province> provinces = new ArrayList<Province>();
    /** 交通 */
    private Map<String, Integer> traffic = new HashMap<String, Integer>();


    public Country(){

    }

    public Country(String country_id){
        this.country_id=country_id;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getNation() {
        return nation;
    }

    public void setNation(List<String> nation) {
        this.nation = nation;
    }

    public String[] getLakes() {
        return lakes;
    }

    public void setLakes(String[] lakes) {
        this.lakes = lakes;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public Map<String, Integer> getTraffic() {
        return traffic;
    }

    public void setTraffic(Map<String, Integer> traffic) {
        this.traffic = traffic;
    }

    public void addTraffic(String key, Integer value) {
        traffic.put(key, value);
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_id='" + country_id + '\'' +
                ", birthDate=" + birthDate +
                ", nation=" + nation +
                ", lakes=" + Arrays.toString(lakes) +
                ", provinces=" + provinces +
                ", traffic=" + traffic +
                '}';
    }
}
