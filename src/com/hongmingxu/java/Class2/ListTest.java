package com.hongmingxu.java.Class2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author hongmingxu
 * @create 2022-03-15 17:34
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        System.out.println(list);
        //void add(int index,Object obj):在index位置插入元素
        list.add(1,"BB");
        System.out.println(list);
        //boolean addAll(int index,Collection eles):从index位置开始将集合中的所有元素添加
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size());//9
        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);
        //int indexOf(Object obj):返回obj在集合中首次出现的位置,如果不存在，返回-1
        int index = list.indexOf(456);
        System.out.println(index);
        //int lastIndexOf(Object obj):返回obj在集合中末次出现的位置,如果不存在，返回-1
        System.out.println(list.lastIndexOf(456));
        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);
        //Object set(int index,Object obj):设置指定index位置的元素为obj
        list.set(1,"CC");
        System.out.println(list);
        //List subList(int fromIndex,int toIndex):返回从fromindex到toindex位置的子集合
        List subList = list.subList(2, 4);
        System.out.println(subList);
        System.out.println(list);
    }

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        //方式一：Iterator迭代器方式
        Iterator iterable = list.iterator();
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }
        //方式二：增强for循环
        for(Object obj:list){
            System.out.println(obj);
        }
        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
