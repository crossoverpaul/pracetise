package com.guozz.practise.java8inaction.chap3;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * 排序
 */
public class Sorting {

    public static void main(String[] args) {

        //1.
        List<Apple> inventory=Lists.newArrayList(new Apple(80,"green"),
                                           new Apple(155,"green"),
                                            new Apple(120,"red"));
        //[Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        //reshuffing things a little
        inventory.set(1,new Apple(30,"green"));

        //2.
        //[Apple{color='green', weight=30}, Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(inventory);


        //reshuffing things a little
        inventory.set(1,new Apple(20,"red"));


        //3.
        //// [Apple{color='red', weight=20}, Apple{color='green', weight=30}, Apple{color='green', weight=155}]
        inventory.sort((a1,a2)->a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);

        //reshuffing things a little
        inventory.set(1,new Apple(1,"red"));

        //4.
        //// [Apple{color='red', weight=10}, Apple{color='red', weight=20}, Apple{color='green', weight=155}]
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);




    }


    public static class Apple{

        private Integer weight;

        private String color;

        public Apple(Integer weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }
}
