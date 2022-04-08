package com.hongmingxu.java.java8;

import com.hongmingxu.java.Reflection.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hongmingxu
 * @create 2022-03-23 20:52
 */
public class StreamAPITest {

    //创建Stream方式一：通过集合
    @Test
    public void test1(){
        List<Person> employees = PersonData.getPerson();
        //default Stream<E> stream();返回一个顺序流
        Stream<Person> stream  = employees.stream();
        //default Stream<E> parallelStream();返回一个并行流
        Stream<Person> personStream = employees.parallelStream();

    }
    //创建Stream方式二：通过数组
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays类的static<T> Stream<T> stream(T[] array);返回一个流
        IntStream stream = Arrays.stream(arr);
        Person p1 = new Person("sdf", 32);
        Person p2 = new Person("fd", 54);
        Person[] arr1 = new Person[]{p1,p2};
        Stream<Person> stream1 = Arrays.stream(arr1);
    }
    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

    }
    //创建Stream方式四：创建无限流
    @Test
    public void test4(){
        //遍历前10个偶数
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
