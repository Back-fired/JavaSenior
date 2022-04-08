package com.hongmingxu.java.IO;

import org.junit.Test;

import java.io.*;

/**缓存流的作用：提高流的读取、写入的速度
 * 处理流：就是套接再已有的流的基础上
 * @author hongmingxu
 * @create 2022-03-19 15:43
 */
public class BufferedTest {
    //实现非文本文件的复制
    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造文件
            File srcFile = new File("dir\\zelda.jpg");
            File destFile = new File("dir\\zelda2.jpg");
            //造流
            //造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //读取和写入的过程
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //资源关闭
        //要求：先关闭外层的流，再关闭内层的流
        //说明：关闭外层流的同时，内层流也会自动的进行关闭。所以内层流的关闭可以省略
//        fos.close();
//        fis.close();
    }
    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //造流
            //造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //读取和写入的过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();
        String srcPath = "dir\\majiko.mp4";
        String endPath = "dir\\majiko1.mp4";
        copyFileWithBuffered(srcPath,endPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end - start));
    }
    //文本文件的复制
    @Test
    public void testBufferdReadWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("dir\\hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dir\\hello3.txt")));
            //方式一
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1) {
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }
            //方式二
            String data;
            while ((data = br.readLine()) != null) {
                //方式一：
                bw.write(data+"\n");//data中不包含换行符
                //方式二
                bw.write(data);
                bw.newLine();//提供换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
