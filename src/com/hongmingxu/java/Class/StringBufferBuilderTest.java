package com.hongmingxu.java.Class;

import org.junit.Test;

/**关于StringBuffer和StringBuilder的使用
 * @author hongmingxu
 * @create 2022-03-12 17:22
 */
public class StringBufferBuilderTest {
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0

    }

    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);//增
        s1.append('1');
        System.out.println(s1);
//        s1.delete(2,4);//删
//        s1.replace(2,4,"hello");//改
//        s1.insert(2,false);//查
//        s1.reverse();
        String s2 = s1.substring(1, 3);
        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(s2);
    }
}
