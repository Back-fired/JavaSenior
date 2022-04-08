package com.hongmingxu.java.Class;

import java.util.ArrayList;
import java.util.Date;

/**注解的使用
 * @author hongmingxu
 * @create 2022-03-14 20:18
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person p = new Student();
        p.walk();

        Date date = new Date(2022,3,14);
        System.out.println(date);
        @SuppressWarnings("unused")
        int num = 10;
//        System.out.println(num);
        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list = new ArrayList();
    }
}
@MyAnnotation(value = "hi")
class Person{
    private String name;
    private int age;
    @MyAnnotation
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }

}

interface Info1{
    void show();
}

class Student extends Person implements Info1{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}

class Generic<@MyAnnotation T>{
    public void show() throws @MyAnnotation  RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation  int) 10L;
    }

}


