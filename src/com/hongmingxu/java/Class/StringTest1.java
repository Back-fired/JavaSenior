package com.hongmingxu.java.Class;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**涉及到String类与其他结构之间的转换
 * @author hongmingxu
 * @create 2022-03-12 16:19
 */
public class StringTest1 {

    @Test
    public void test1(){
        //String 与基本数据类型、包装类之间的转换
        String str1 = "123";
        int num = Integer.parseInt(str1);
        //基本数据类型、包装类转换为String
        String str2 = String.valueOf(num);
        String str3 = num + "";
    }
    //String 与char[]之间的转换
    @Test
    public void test2(){
        //String——》char[]:调用String类的toCharArray()
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]+ " ");
        }
        System.out.println();
        //char[]——》String:
        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }
    //String 与byte[]之间的转换
    @Test
    public void test3() throws UnsupportedEncodingException {
        //String——》byte[]：调用String的getBytes()
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集编码
        System.out.println(Arrays.toString(gbks));

        //byte[]——》String
        String str2 = new String(bytes);//使用默认的字符集，进行解码
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码，编码集和解码集不一致
        String str4 = new String(gbks, "gbk");
        System.out.println(str4);
    }

}
