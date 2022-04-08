package com.hongmingxu.java.Reflection;

/**
 * @author hongmingxu
 * @create 2022-03-20 13:45
 */
@MyAnnotation(value="hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    public int id;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(int id){
        this.id = id;
    }
    @MyAnnotation(value="abc")
    private Person(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public String display(String interests){
        return interests;
    }


    public void show(){
        System.out.println("你好，我是一个人");
    }
    @MyAnnotation
    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}
