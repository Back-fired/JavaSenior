package com.hongmingxu.java.Reflection;

import org.junit.Test;

import java.util.Random;

/**通过反射创建对应的运行时类的对象
 * @author hongmingxu
 * @create 2022-03-20 15:46
 */
public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //newInstance():调用此方法，创建对应的运行时类的对象.内部调用了运行时类的空参构造器
        //要想此方法正常的创建运行时类的对象，要求：
        //1.运行时类必须提供空参的构造器
        //2.空参的构造器的访问权限得够。通常设置为public
        //在javabean中要求提供一个public的空参构造器。原因
        //1.便于通过反射，创建运行时类的对象
        //2.便于子类继承此运行时时，默认调用super（）时，保证父类由此构造器
        Person p = clazz.newInstance();
        System.out.println(p);

    }

    @Test
    public void test2(){
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.hongmingxu.java.Reflection.Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //创建一个指定类的对象。classPath:指定类的全类名
    public Object getInstance(String classPath) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
