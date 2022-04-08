package com.hongmingxu.java.IO;

import java.io.Serializable;

/**Person需要满足如下的要求方可序列化
 * 1.需要实现接口：serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * @author hongmingxu
 * @create 2022-03-19 19:55
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 456445341353L;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
