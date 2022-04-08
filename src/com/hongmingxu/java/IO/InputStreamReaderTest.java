package com.hongmingxu.java.IO;

import org.junit.Test;

import java.io.*;

/**转换流：属于字符流
 * inputstreamreader:将一个字节的输入流转换为字符的输入流
 * outputstreamwriter：将一个字符的输出流转换为字节的输出流
 * 作用：提供字节流于字符流之间的转换
 * @author hongmingxu
 * @create 2022-03-19 16:53
 */
public class InputStreamReaderTest {
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("dir\\hello.txt");
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            String s = new String(cbuf, 0, len);
            System.out.println(s);
        }
        isr.close();
    }
    //综合使用inputstreamreader和outputstreamwriter
    @Test
    public void test2() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("dir\\hello.txt"),"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("dir\\hello4.txt"),"gbk");

        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf,0,len);
        }
        isr.close();
        osw.close();
    }
}
