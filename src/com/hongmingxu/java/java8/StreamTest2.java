package com.hongmingxu.java.java8;

import com.hongmingxu.java.Reflection.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**Stream的终止操作
 * @author hongmingxu
 * @create 2022-03-23 22:17
 */
public class StreamTest2 {
    //1.匹配与查找
    @Test
    public void test1(){
        List<Person> person = PersonData.getPerson();

        boolean allMatch = person.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        boolean anyMatch = person.stream().anyMatch(e -> e.getAge() > 40);
        System.out.println(anyMatch);

        boolean noneMatch = person.stream().noneMatch(e -> e.getName().startsWith("b"));
        System.out.println(noneMatch);

        Optional<Person> first = person.stream().findFirst();
        System.out.println(first);

        Optional<Person> any = person.stream().findAny();
        System.out.println(any);

    }
    @Test
    public void test2(){
        List<Person> person = PersonData.getPerson();
        long count = person.stream().filter(e -> e.getAge() > 40).count();
        System.out.println(count);

        Stream<Integer> integerStream = person.stream().map(e -> e.getAge());
        Optional<Integer> max = integerStream.max(Double::compare);
        System.out.println(max);

        Optional<Person> min = person.stream().min((p1, p2) -> Double.compare(p1.getAge(), p2.getAge()));
        System.out.println(min);

        person.stream().forEach(System.out::println);
        //使用集合中的遍历操作
        person.forEach(System.out::println);
    }
    //归约
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1,2,3,4,45,5,6,7,8);
        Integer sum = list.stream().reduce(10, Integer::sum);
        System.out.println(sum);

        List<Person> person = PersonData.getPerson();
        Optional<Integer> sumAge = person.stream().map(Person::getAge).reduce(Integer::sum);
        System.out.println(sumAge);
    }
    //收集
    @Test
    public void test4(){
        List<Person> person = PersonData.getPerson();
        List<Person> collect = person.stream().filter(e -> e.getAge() > 50).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
