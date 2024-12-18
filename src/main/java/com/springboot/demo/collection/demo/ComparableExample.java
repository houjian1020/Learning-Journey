package com.springboot.demo.collection.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample implements Comparable<ComparableExample> {
    private String name;
    private int age;

    // 构造方法
    public ComparableExample(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(ComparableExample other) {
        // 自定义排序规则，例如按年龄降序排序
        return -Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        List<ComparableExample> people = new ArrayList<>();
        people.add(new ComparableExample("Alice", 30));
        people.add(new ComparableExample("Bob", 25));
        people.add(new ComparableExample("Charlie", 35));
        // 调用自定义排序
        Collections.sort(people);

        for (ComparableExample person : people) {
            System.out.println(person);
        }
    }
}

