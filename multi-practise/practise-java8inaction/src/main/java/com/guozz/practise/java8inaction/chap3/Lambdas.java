package com.guozz.practise.java8inaction.chap3;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambdas {

    public static void main(String[] args) {
        //Simple example
        Runnable r =()-> System.out.println("Hello");
        r.run();

        //Filterint with lambdas;
        List<Apple> inventory = Lists.newArrayList(new Apple(80,"green"),
                new Apple(155,"green"),new Apple(120,"red"));

        //[Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples= inventory.stream().filter((Apple a)->"green".equals(a.getColor())).collect(Collectors.toList());
        System.out.println(greenApples);

        List<Apple> greepApplesPredicate = filter(inventory,(Apple a)->"green".equals(a.getColor()));
        System.out.println(greepApplesPredicate);

        //Comparator
        Comparator<Apple> c=(Apple a1,Apple a2)->a1.getWeight().compareTo(a2.getWeight());
        inventory.sort(c);
        System.out.println(inventory);











    }

    private static List<Apple> filter(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = Lists.newArrayList();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
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

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    interface ApplePredicate{
        public boolean test(Apple a);
    }
}
