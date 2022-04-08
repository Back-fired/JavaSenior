package com.hongmingxu.java.java8;

import com.hongmingxu.java.Reflection.Person;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**方法引用的使用
 * @author hongmingxu
 * @create 2022-03-22 21:38
 */
public class MethodRefTest {
    //情况一：对象::实例方法
    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("***********");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing");

    }
    @Test
    public void test2(){
        Person emp = new Person("Tom",23);
        Supplier<String> sup1= () -> emp.getName();
        System.out.println(sup1.get());
        System.out.println("*************");
        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }
    //情况二：类::静态方法
    @Test
    public void test3(){
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12, 21));
        System.out.println("**************");
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(34, 32));

    }
    @Test
    public void test4(){
        Function<Double,Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));
        System.out.println("***************");
        Function<Double,Long> func2 = Math::round;
        System.out.println(func2.apply(23.1));
    }
    //情况三：类::实例方法
    @Test
    public void test5(){
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abd", "ase"));
        System.out.println("*************");
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("sad", "fsd"));
    }
    @Test
    public void test6(){
        BiPredicate<String,String> pre1 = (s1,s2) -> s1.equals(s2);
        System.out.println(pre1.test("ans", "sdf"));
        System.out.println("************");
        BiPredicate<String,String> pre2 = String::equals;
        System.out.println(pre2.test("sda", "dsf"));
    }
    @Test
    public void test7(){
        Person jerry = new Person("jerry", 12);
        Function<Person,String> fun1 = e -> e.getName();
        System.out.println(fun1.apply(jerry));
        System.out.println("***********");
        Function<Person,String> fun2 = Person::getName;
        System.out.println(fun2.apply(jerry));
    }
}
