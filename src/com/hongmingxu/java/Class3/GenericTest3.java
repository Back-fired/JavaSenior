package com.hongmingxu.java.Class3;

import org.junit.Test;

import java.util.*;

/**泛型再继承方面的体现
 * @author hongmingxu
 * @create 2022-03-17 20:43
 */
public class GenericTest3 {
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2不具备子父类关系
//        list1 = list2;

        Date date = new Date();
//        str = date;

    }
    @Test
    public void test2(){
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list3;
        list2 = list3;
    }
    //通配符的使用：？
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        //编译通过
//        print(list1);
//        print(list1);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //对于List<?>就不能向内部添加数据,除了添加null之外
//        list.add("DD");
        list.add(null);

        //获取：允许读取数据，读取的数据类型是Object
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list){
        Iterator<?> iterable = list.iterator();
        while (iterable.hasNext()) {
            Object obj = iterable.next();
            System.out.println(obj);
        }
    }

    //有限制条件的通配符的使用：
    @Test
    public void test4(){
        List<? extends SubOrder> list1 = null;
        List<? super SubOrder> list2 = null;

        List<SubOrder> list3 = null;
        List<Order> list4 = null;

        list1 = list3;
//        list1 = list4;
        list2 = list3;
        list2 = list4;

        //读取数据

    }

}
