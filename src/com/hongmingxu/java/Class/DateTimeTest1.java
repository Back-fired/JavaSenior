package com.hongmingxu.java.Class;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**jdk8之前的日期时间测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 * @author hongmingxu
 * @create 2022-03-13 14:28
 */
public class DateTimeTest1 {
    //SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    //两个操作：格式化：日期——》字符串  解析：格式化的逆过程：字符串——》日期
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //SimpleDateFormat的实例化
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);
        //解析
//        String str = "22/3/13 14:46 PM";
//        Date date1 = sdf.parse(str);
//        System.out.println(date1);

//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //要求字符串必须符合SimpleDateFormat识别的格式（通过构造器参数体现）否则抛异常
        Date date2 = sdf1.parse("2022-03-13 14:45:46");
        System.out.println(date2);
    }

    //练习一：字符串“2022-08-09”转换为java.sql.Date
    @Test
    public void testExer() throws ParseException {
        String birth = "2022-08-09";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
//        System.out.println(date)
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    //Calendar日历类(抽象类）的使用(可变的)
    @Test
    public void testCalendar(){
        //实例化
        //方式一：创建其子类（GregorianCalendar)的对象
        //方式二：调用其静态方法getInstanceJ()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());
        //常用方法
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //日历类——》Date类
        Date date = calendar.getTime();
        System.out.println(date);
        //Date类——》日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
