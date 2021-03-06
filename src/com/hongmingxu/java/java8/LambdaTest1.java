package com.hongmingxu.java.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**Lambda表达式的使用
 * @author hongmingxu
 * @create 2022-03-22 20:10
 */
public class LambdaTest1 {
    //语法格式一：无参、无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        System.out.println("************");
        Runnable r2 = () -> {
            System.out.println("我爱北京故宫");
        };
        r2.run();
    }
    //语法格式二：Lambda需要一个参数，但是没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");
        System.out.println("***********");
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真，一个是说的人当真了");
    }
    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为”类型推断“
    @Test
    public void test3(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真，一个是说的人当真了");
        System.out.println("*************");
        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("一个是听的人当真，一个是说的人当真了");
    }
    //语法格式四：Lambda只需要一个参数，参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真，一个是说的人当真了");
        System.out.println("*******************");
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("一个是听的人当真，一个是说的人当真了");
    }
    //语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可能有返回值
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(112, 23));
        System.out.println("****************");
        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(32,12));
    }
    //语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以忽略
    @Test
    public void test6(){
        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(32,12));
        System.out.println("***************");
        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(45,12));
    }
    @Test
    public void test7(){
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真，一个是说的人当真了");
        System.out.println("************");
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("一个是听的人当真，一个是说的人当真了");
    }
}
