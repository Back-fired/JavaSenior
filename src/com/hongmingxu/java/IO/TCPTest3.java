package com.hongmingxu.java.IO;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hongmingxu
 * @create 2022-03-19 22:40
 */
public class TCPTest3 {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("dir\\zelda.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer,0,len);
        }
        //关闭的数据的输出
        socket.shutdownOutput();
        //接受服务器的数据
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[1024];
        int lens;
        while ((lens = is.read(bufferr)) != -1) {
            baos.write(bufferr,0,lens);
        }
        System.out.println(baos.toString());
        baos.close();
        fis.close();
        os.close();
        socket.close();
    }
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("dir\\zelda6.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer,0,len);
        }
        //给客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，照片我已收到".getBytes());
        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
