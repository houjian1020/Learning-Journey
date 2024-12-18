package com.springboot.demo.collection.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample implements Comparator<ComparatorExample> {

    private String name;
    private int age;

    // 构造方法
    public ComparatorExample() {}

    public ComparatorExample(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    @Override
    public int compare(ComparatorExample o1, ComparatorExample o2) {
        // 自定义排序规则，例如按年龄升序排序
        return Integer.compare(o1.getAge(), o2.getAge());
    }


    public static void main(String[] args) {
        List<ComparatorExample> people = new ArrayList<>();
        people.add(new ComparatorExample("Alice", 30));
        people.add(new ComparatorExample("Bob", 25));
        people.add(new ComparatorExample("Charlie", 35));

        Collections.sort(people, new ComparatorExample());

        for (ComparatorExample person : people) {
            System.out.println(person);
        }
    }
}
