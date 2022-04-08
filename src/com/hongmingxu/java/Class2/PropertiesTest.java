package com.hongmingxu.java.Class2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**Properties：常用来处理配置文件，key和value都是String类型
 * @author hongmingxu
 * @create 2022-03-16 19:54
 */
public class PropertiesTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("JDBC.properties");
            pros.load(fis);

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name=" + name + ",password=" + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
