package com.hongmingxu.java.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author hongmingxu
 * @create 2022-03-22 21:14
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了一瓶矿泉水，价格为：" + aDouble);
            }
        });
        System.out.println("*************");
        happyTime(400,money -> System.out.println("学习太累了，去天上人间买了一瓶矿泉水，价格为：" + money));
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> f = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(f);
        List<String> f1 = filterString(list,s->s.contains("京"));
        System.out.println(f1);
    }
    //根据给定的规则，过滤集合中的字符串。此规则有Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s:list){
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
