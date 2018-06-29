package com.org.springboot.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * Created by paopaobing on 2017/10/30.
 */
@Slf4j
public class MyStack<T> {

    //队列信息
    private LinkedList<T> list = new LinkedList<T>();

    //队列添加
    public synchronized void push(T t) {
        log.info("消息添加：{}", t);
        list.add(t);
        log.info("消息添加结束,消息队列信息：{}", toString());
    }

    //获取任务对象
    public T peek() {
        T t = list.getFirst();
        log.info("获取消息：{},消息队列：{}", t,toString());
        return t;
    }

    //移除对象
    public void pop() {
        T  t =  list.removeFirst();
        log.info("删除消息：{},消息队列：",t,toString());
    }

    //判断队列是否空
    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<String>();
        for (String bt : "lei_chen@xinyan.com".split("@")) {
            stack.push(bt);
        }

        while (!stack.empty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }

    }

}
