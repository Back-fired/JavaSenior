package com.hongmingxu.java.java8;

import com.hongmingxu.java.Reflection.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**测试Stream的中间操作
 * @author hongmingxu
 * @create 2022-03-23 21:24
 */
public class StreamAPITest1 {
    //1.筛选与切片
    @Test
    public void test1(){
        List<Person> list = PersonData.getPerson();
        Stream<Person> stream = list.stream();
        //查询年龄大于30的人
        stream.filter(e -> e.getAge()>30).forEach(System.out::println);
        System.out.println();
        //前3个
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
        //跳过3个
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();
        //去除重复元素
        list.add(new Person("asd",20));
        list.add(new Person("asd",20));
        list.add(new Person("asd",20));
        list.add(new Person("asd",20));
        list.stream().distinct().forEach(System.out::println);
    }
    //映射
    @Test
    public void test2(){
        //map(function f)接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        //获取人姓名长度大于3的人的姓名
        List<Person> person = PersonData.getPerson();
        Stream<String> stringStream = person.stream().map(Person::getName);
        stringStream.filter(name -> name.length()>3).forEach(System.out::println);
        //
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringtoStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();
        //flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringtoStream);
        characterStream.forEach(System.out::println);

    }
    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringtoStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    //排序
    @Test
    public void test3(){
        //自然排序
        List<Integer> list = Arrays.asList(12, 232, 43, 54, 65, 76, 87, 2);
        list.stream().sorted().forEach(System.out::println);
        //报异常
//        List<Person> person = PersonData.getPerson();
//        person.stream().sorted().forEach(System.out::println);
        //定制排序
        List<Person> person = PersonData.getPerson();
        person.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(),p2.getAge())).forEach(System.out::println);
    }

}
