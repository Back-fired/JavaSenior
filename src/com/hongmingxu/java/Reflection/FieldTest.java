package com.hongmingxu.java.Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**获取当前运行时类的属性结构
 * @author hongmingxu
 * @create 2022-03-20 19:47
 */
public class FieldTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //getField():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        //getDeclaredFields():获取当前运行时类中声明的所有属性（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f:declaredFields){
            System.out.println(f);
        }
    }
    //权限修饰符 数据类型 变量名 =
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f:declaredFields){
            //权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers)+"\t");
            System.out.println();
            //数据类型
            Class type = f.getType();
            System.out.println(type+"\t");
            //变量名
            String name = f.getName();
            System.out.println(name + "\t");
            System.out.println();
        }
    }
}
