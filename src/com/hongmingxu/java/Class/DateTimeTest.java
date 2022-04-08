package com.hongmingxu.java.Class;

import org.junit.Test;

import java.util.Date;

/**JDK8之前日期和时间的API测试
 * @author hongmingxu
 * @create 2022-03-12 19:32
 */
public class DateTimeTest {
    //1.System类中的currentTimeMillis();
    @Test
    public void test1(){
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
    //java.util.Date类
    //java.sql.Date：对应着数据库中的日期类型的变量
    @Test
    public void test2(){
        //构造器一：Date()
        Date date1 = new Date();
        System.out.println(date1.toString());//Sat Mar 12 19:43:02 CST 2022

        System.out.println(date1.getTime());//获取毫秒数

        //构造器二：
        Date date2 = new Date(15441641351484134L);
        System.out.println(date2);

        java.sql.Date date3 = new java.sql.Date(468465448489486864L);
        System.out.println(date3);
        //util.Date——>sql.Date
        //情况一
        Date date4 = new java.sql.Date(87443544135L);
        java.sql.Date date5 = (java.sql.Date)date4;
        //情况二
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        System.out.println(date7);
    }
}
