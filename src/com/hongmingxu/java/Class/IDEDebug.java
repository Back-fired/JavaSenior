package com.hongmingxu.java.Class;

import org.junit.Test;

/**
 * @author hongmingxu
 * @create 2022-03-13 14:10
 */
public class IDEDebug {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuilder sb1 = new StringBuilder(str);//抛异常
        System.out.println(sb1);
    }
}
