package com.hongmingxu.java.Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**调用运行时类中指定的结构：属性、方法、构造器
 * @author hongmingxu
 * @create 2022-03-20 21:02
 */
public class ReflectionTests1 {
    @Test
    public void testField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //获取指定的属性:要求运行时类中属性声明为public
        //通常不用此方法
        Field id = clazz.getField("id");
        //设置当前属性的值
        //set():参数1：指明设置哪个对象的属性 参数2：将此属性设置为多少
        id.set(p,1001);
        //获取当前属性值
        //get():参数1：获取哪个对象的当前属性值
        int i = (int) id.get(p);
        System.out.println(i);
    }
    //如何操作运行时类中指定的属性（推荐）
    @Test
    public void test2() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Person p = (Person)clazz.newInstance();
        //获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //保证当前属性是可访问的
        name.setAccessible(true);
        //获取、设置指定对象的属性值
        name.set(p,"Tom");
        System.out.println(name.get(p));
    }
    //如何操作运行时类中指定的方法（推荐）
    @Test
    public void test3() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        //获取指定的方法
        //getDeclaredMethod():参数1 指明获取的方法的名称 参数2：指明获取的方法的形参列表
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //invoke():参数1：方法的调用者 参数2：给方法形参复制的实参
        //invoke（）的返回值对应类中调用的方法的返回值
        Object returnValue = showNation.invoke(p, "CHN");
        System.out.println(returnValue);
        //调用静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类的方法没有返回值，则此invoke()返回null
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);//null
    }
    //如何调用运行时类的构造器
    @Test
    public void test4() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //getConstructor():参数：指明构造器的参数列表
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);
    }
}
