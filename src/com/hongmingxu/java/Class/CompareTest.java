package com.hongmingxu.java.Class;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**说明：Java中的对象，正常情况下，只能进行比较：==或！=。
 * 但是在开发的场景中，需要对多个对象进行排序，就需要比较对象的大小
 * 如何实现？使用comparable或comparator
 * @author hongmingxu
 * @create 2022-03-13 17:16
 */
public class CompareTest {
    //comparable的使用举例
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","BB","DD","UU","QQ","OO"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("sdfad",34);
        arr[1] = new Goods("sdfdf",23);
        arr[2] = new Goods("sdsdf",43);
        arr[3] = new Goods("sdfer",65);
        arr[4] = new Goods("adfer",65);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
    //Comparator接口的使用：定制排序
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","CC","KK","BB","DD","UU","QQ","OO"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照字符串从大到小排序
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("sdfad",34);
        arr[1] = new Goods("sdfdf",23);
        arr[2] = new Goods("sdsdf",43);
        arr[3] = new Goods("sdfer",65);
        arr[4] = new Goods("adfer",65);

        Arrays.sort(arr,new Comparator(){
            //按照产品名称从低到高，在按照价格从高到低
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

}
