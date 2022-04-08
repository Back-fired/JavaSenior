package com.hongmingxu.java.Class3;

import org.junit.Test;

import java.util.*;

/**泛型的使用
 * @author hongmingxu
 * @create 2022-03-17 16:44
 */
public class GenericTest {
    //集合中使用泛型之前
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一:类型不安全
        list.add("Tom");

        for (Object score:list){
            //问题二：强转时可能出现类型转换异常
//            int stuScore = (Integer) score;
//            System.out.println(stuScore);
        }
    }
    //集合中使用泛型
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(87);
        list.add(99);
        list.add(56);
        //编译时会进行类型检查，保证数据的安全
        //方式一
//        list.add("Tom");
//        for (Integer score:list){
//            int stuScore = score;
//            System.out.println(stuScore);
//        }
        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<>();
        map.put("Tom",87);
        map.put("Jerry",34);
        map.put("Jack",54);
        
//        map.put(123,"sdf");
        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "-----" + value);
        }
    }
}
