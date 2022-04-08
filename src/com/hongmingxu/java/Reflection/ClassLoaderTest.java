package com.hongmingxu.java.Reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**了解类的加载器
 * @author hongmingxu
 * @create 2022-03-20 15:24
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载的getParent():获取拓展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用拓展类加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载Java的核心类库，无法在家自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //读取配置文件的方式一
        FileInputStream fis = new FileInputStream("JDBC.properties");
        pros.load(fis);
        //方式二
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("..\\JDBC.properties");
//        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user=" + user + ",password=" + password);

    }
}
