package com.hongmingxu.java.Class2;

import org.junit.Test;

import java.util.*;

/**Collection接口中声明的方法的测试
 * @author hongmingxu
 * @create 2022-03-14 21:53
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add():将元素添加到集合coll种
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());
        //size()：获取元素的个数
        System.out.println(coll.size());//4
        //addAll():将coll1集合中的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);
        //clear():清空集合元素
        coll.clear();
        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry",30);
        coll.add(p);

        //contains(Object obj):判断当前集合中是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(p));

        //containsAll(Collection coll):判断形参的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(456,123);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("hong",20));
        //remove():从当前集合中移除元素
        coll.remove(123);
        System.out.println(coll);
        coll.remove(new Person("hong",20));
        System.out.println(coll);
        //removeAll(Collection coll1):从当前集合中移除coll1中所有元素
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("hong",20));
        //retainAll(Collection coll1):获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);
        //equals(Object obj):判断当前集合和形参的元素是否相等
        Collection coll2 = new ArrayList();
        coll2.add(456);
        coll2.add(123);
        coll2.add(new String("Tom"));
        coll2.add(false);
        coll2.add(new Person("hong",20));
        System.out.println(coll.equals(coll2));
    }

    @Test
    public void test5(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("hong",20));
        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());
        //集合——》数组:toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //数组——》集合：调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1
        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2

        //iterator():返回Iterator接口的实例，用于遍历集合元素。
    }

}
