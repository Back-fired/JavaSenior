package com.hongmingxu.java.Class;

import org.junit.Test;

/**
 * @author hongmingxu
 * @create 2022-03-12 14:33
 */
public class StringMethodTest {
    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));

        System.out.println(s1.isEmpty());
        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1不可变，仍未原来的字符串
        System.out.println(s2);//改成小写的字符串

        String s3 = "    he  llo  world    ";
        String s4 = s3.trim();
        System.out.println("----" + s3 + "------");
        System.out.println("----" + s4 + "------");

    }

    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abd");
        System.out.println(s5.compareTo(s6));

        String s7 = "洪明旭学java";
        String s8 = s7.substring(2);
        System.out.println(s7);
        System.out.println(s8);

        String s9 = s7.substring(2, 5);
        System.out.println(s9);
    }

    @Test
    public void test3(){
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);

        boolean b2 = str1.startsWith("He");
        System.out.println(b2);
        boolean b3 = str1.startsWith("ll",2);
        System.out.println(b3);

        String str2 = "wo";
        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf("lol"));

        System.out.println(str1.indexOf("lo", 5));

        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.lastIndexOf("or",6));

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str,情况二：不存在
    }

    @Test
    public void test4(){
        String str1 = "洪明旭学Java";
        String str2 = str1.replace('明','红');
        System.out.println(str1);
        System.out.println(str2);

        String str3 = str1.replace("洪明","上海");
        System.out.println(str3);

        String str4 = "hellow|world|java";
        String[] strs = str4.split("|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str5 = "hello,world,java";
        String[] strs2 = str5.split(",");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }
}
