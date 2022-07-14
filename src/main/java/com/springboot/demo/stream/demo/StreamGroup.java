package com.springboot.demo.stream.demo;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *  stream案例
 *  1.filter: 过滤（常用）
 *  2.Collectors: 控制返回结果（常用）
 *  3.count 、 distinct
 *  4.map: 映射集合元素，遍历并处理（常用）
 *  5.summaryStatistics：统计
 *  6.foreach: 迭代数据
 */
public class StreamGroup {

    private static List<String> strings = Arrays.asList("1","","22"," ","333","","4444","","55555","1","22","333","555","111");

    private static List<Integer> numbers = Arrays.asList(1,9,3, 2, 2, 3, 7, 3, 5,6,3,7);

    private static List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

    public static void main(String[] args) {
        // 过滤出空字符串数量
        long count1 = getEmptyCount();
        System.out.println("空字符串数量："+ count1);

        // 过滤出长度为3的字符串数量
        long count2 = getLen3Count();
        System.out.println("字符串长度为3数量："+ count2);

        // 过滤后的List
        List<String> filterList = getFilterList();
        System.out.println("过滤后的List:" + filterList);

        // 过滤后的List，合并为字符串
        String AppendStr = getAppendString();
        System.out.println("合并字符串:" + AppendStr);

        // 遍历集合，并去重
        List<String> distinctList = getDistinctList();
        System.out.println("去重和拼接字符串:" + distinctList);

        // 统计
        getStatistics();

        // 遍历
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    private static void getStatistics() {
        IntSummaryStatistics statistics = integers.stream().mapToInt((i) -> i).summaryStatistics();
        System.out.println("最大值:" + statistics.getMax());
        System.out.println("最小值:" + statistics.getMin());
        System.out.println("平均值:" + statistics.getAverage());
        System.out.println("求和值:" + statistics.getSum());

    }

    private static List<String> getDistinctList() {
        List<String> collect = strings.stream().map(i -> i + "abc").distinct().collect(Collectors.toList());
        return collect;
    }

    private static String getAppendString() {
        String collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        return collect;
    }

    private static List<String> getFilterList() {
        List<String> collect = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        return collect;
    }

    private static long getLen3Count() {
        long count = strings.stream().filter(string -> string.length() == 3).count();
        return count;
    }

    private static long getEmptyCount() {
        long count = strings.stream().filter(str -> str.isEmpty()).count();
        return strings.stream().filter(str->str.isEmpty()).count();
    }

}
