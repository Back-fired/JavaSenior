package com.hongmingxu.java.Class3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**自定义泛型类、泛型接口
 * @author hongmingxu
 * @create 2022-03-17 18:23
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定义类泛型类，实例化没有指明类的泛型，则认位此泛型类型为Object类型
        //如果定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        Order<String> order1 = new Order<String>("orderAA",1001,"order:AA");

        order1.setOrderT("AA:hello");
    }
    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，父类指明了泛型类型，实例化子类对象时，不再需要指明泛型
        sub1.setOrderT(1122);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order2...");
    }
    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
//        list1 = list2;

    }
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //方形方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }
}
