package com.hongmingxu.java.IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author hongmingxu
 * @create 2022-03-19 13:55
 */
public class FileReaderWriterTest {
    //将hello.txt文件内容读入程序中，并输出到控制台
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            //实例化File类的对象，指明要操作的文件
            File file = new File("dir\\hello.txt");
            System.out.println(file.getAbsolutePath());
            //提供具体的流
            fr = new FileReader(file);
            //数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一
//        int data = fr.read();
//        while (data != -1) {
//            System.out.print((char)data);
//            data = fr.read();
//        }
            //方式二:语法上的修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //对read()操作升级，使用read的重载方法
    @Test
    public void test2(){
        FileReader fr = null;
        try {
            //File类的实例化
            File file = new File("dir\\hello.txt");
            //FileRead流的实例化
            fr = new FileReader(file);
            //读入的操作
            //read(char[] cbub):返回每次读入cbug数组中的字符的个数，如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                //方式一
                //错误的写法
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.println(cbuf[i]);
//                }
                //正确的写法
                for (int i = 0; i < len; i++) {
                    System.out.println(cbuf[i]);
                }
                //方式二：
                //错误的写法
//                String str = new String(cbuf);
//                System.out.println(str);
                //正确的写法
                String str = new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                //资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //从内存中写出数据到硬盘的文件里
    @Test
    public void test3() throws IOException {
        //提供File类的对象，指明写出的文件
        File file = new File("dir\\hello1.txt");
        //提供FileWriter流的对象，用于数据的写出
        FileWriter fw = new FileWriter(file);
        //写出的操作
        fw.write("I hava a dream!\n");
        fw.write("you need to have a dream!");

        //流的关闭
        fw.close();
    }

    @Test
    public void test4(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //创建File类的对象,指明读入和写出的对象
            File srcFile = new File("dir\\hello.txt");
            File destFile = new File("hello2.txt");
            //创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到数组中的字符的个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
