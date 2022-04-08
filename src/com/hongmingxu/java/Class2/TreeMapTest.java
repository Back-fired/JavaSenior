package com.hongmingxu.java.Class2;

import org.junit.Test;

import java.util.*;

/**
 * @author hongmingxu
 * @create 2022-03-16 19:40
 */
public class TreeMapTest {
    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        Person p1 = new Person("Tom",23);
        Person p2 = new Person("Jerry",32);
        Person p3 = new Person("Jack",20);
        Person p4 = new Person("Rose",18);
        map.put(p1,98);
        map.put(p2,78);
        map.put(p3,65);
        map.put(p4,23);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });
        Person p1 = new Person("Tom",23);
        Person p2 = new Person("Jerry",32);
        Person p3 = new Person("Jack",20);
        Person p4 = new Person("Rose",18);
        map.put(p1,98);
        map.put(p2,78);
        map.put(p3,65);
        map.put(p4,23);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
}
