package com.hongmingxu.java.IO;

import org.junit.Test;

import java.io.*;

/**对象流的使用
 * @author hongmingxu
 * @create 2022-03-19 19:45
 */
public class ObjectInputOutputStreamTest {
    //序列化的过程，将内存种的Java对象保存在磁盘中或通过网络传输出去
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("dir\\object.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();//刷新操作
            oos.writeObject(new Person("洪明旭",23));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //反序列化：将磁盘文件中的对象还原为内存中的Java对象
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("dir\\object.dat"));
            Object o = ois.readObject();
            String s = (String) o;
            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
