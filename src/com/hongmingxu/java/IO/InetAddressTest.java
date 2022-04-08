package com.hongmingxu.java.IO;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author hongmingxu
 * @create 2022-03-19 21:29
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("190.168.10.14");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
            //获取本地ip
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);

            System.out.println(inet2.getHostName());
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
