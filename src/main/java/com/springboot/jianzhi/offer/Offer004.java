package com.springboot.jianzhi.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 标题：从尾到头打印链表
 *
 * 考点：掌握栈和链表
 *
 * 思路：栈的特点是后进先出
 */
public class Offer004 {
    /**
     * 描述：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 如输入{1,2,3}的链表， 返回一个数组为[3,2,1]
     *
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);  // 创建头节点
        ListNode node2 = new ListNode(2);  // 创建第二个节点
        ListNode node3 = new ListNode(3);  // 创建第三个节点
        head.next = node2;  // 连接头节点和第二个节点
        node2.next = node3;  // 连接第二个节点和第三个节点

//        1 非递归实现先进后出
        ArrayList<Integer> list1 = method1(head);
        System.out.println("=======method1======"+list1);

//        ArrayList<Integer> list2 = new ArrayList<>();
//        method2(list2, head);
//        System.out.println("=======method2======"+list2);

//        3 使用栈的工具类Stack
        ArrayList<Integer> list3 = method3(head);
        System.out.println("=======method3======"+list3);

//        4 使用集合工具类Collections
        ArrayList<Integer> list4 = method4(head);
        System.out.println("=======method4======"+list4);


    }

    /**
     *  非递归实现先进后出： ArrayList 的 add(0,val)方法，可以将新增的元素插入到第一位，其他的往后移动
     */
    static ArrayList<Integer> method1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null){
            // 每次新增都插入到头部
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }


    /**
     *  递归实现先进后出： 递归方法从最后一次开始往前执行，ArrayList 的 add(val)方法插入顺序就是从前往后依次插入到ArrayList中
     */
    static ArrayList<Integer> method2(ArrayList<Integer> list2, ListNode listNode) {
        while (listNode != null){
            method2(list2, listNode.next);
            list2.add(listNode.val);
        }
        return list2;
    }


    /**
     * 使用栈的工具类Stack：先存入到栈中，然后在从栈中取出来存入数组
     * @param listNode
     */
    static ArrayList<Integer> method3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            // 进栈
            stack.push(listNode.val);
            listNode = listNode.next;
        }


        int size = stack.size();  // 直接将stack.size()作为循环条件存在如下问题： 调用stack.pop()后，stack.size()会减小
        for(int i = 0; i < size; i++){
            // 出栈
            list.add(stack.pop().intValue());
        }
        return list;

    }

    /**
     * 使用集合工具类Collections
     */
    static ArrayList<Integer> method4(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null){
            // 每次新增都插入都尾部
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 自定义连表数据结构
     */
    public static class ListNode {
        int val;          // 代表值
        ListNode next;    // 代表下一个节点对象

        // 构造函数
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        // getter和setter方法
        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


}
