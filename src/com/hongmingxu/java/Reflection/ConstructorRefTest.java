package com.hongmingxu.java.Reflection;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**构造器引用
 * @author hongmingxu
 * @create 2022-03-22 22:13
 */
public class ConstructorRefTest {
    @Test
    public void test1(){
        Supplier<Person> sup = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        System.out.println(sup.get());
        System.out.println("***********");
        Supplier<Person> sup1 = () -> new Person();
        System.out.println(sup1.get());
        System.out.println("*********");
        Supplier<Person> sup2 = Person::new;
        System.out.println(sup2.get());
    }
    @Test
    public void test2(){
        Function<Integer,Person> fun1 = id -> new Person(id);
        System.out.println(fun1.apply(1001));
        System.out.println("*********");
        Function<Integer,Person> fun2 = Person::new;
        System.out.println(fun2.apply(1002));
        System.out.println("*******");

    }
    @Test
    public void test3(){
        BiFunction<String,Integer,Person> func1 = (name,age) -> new Person(name,age);
        System.out.println(func1.apply("tom", 12));
        System.out.println("*******");
        BiFunction<String,Integer,Person> fun2 = Person::new;
        System.out.println(fun2.apply("jerry", 12));
    }
    //数组引用
    @Test
    public void test4(){
        Function<Integer,String[]> func1 = length -> new String[length];
        System.out.println(Arrays.toString(func1.apply(5)));
        System.out.println("**********");
        Function<Integer,String[]> func2 = String[]::new;
        System.out.println(Arrays.toString(func2.apply(6)));
    }
}
