package com.hongmingxu.java.IO;

import org.junit.Test;

import java.io.*;

/**其他流的使用
 * 1.标准输入、输出
 * 2.打印流
 * 3.数据流
 * @author hongmingxu
 * @create 2022-03-19 17:32
 */
public class OtherStreamTest {
    /*
    1.标准输入、输出(字节流)
    System.in:标准的输入流，默认从键盘输入
    System.out:标准的输出流，默认从控制台输出
    System类的setIn()/setOut()方式重新指定输入和输出的流
     */
    public static void main(String[] args) {
            //从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
            //直到当输入“e"或则”exit“退出程序
            //方式一：使用Scanner实现
            //方式二：使用System.in实现。System.in-->BufferedReader的readLine()
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String data = br.readLine();
                    if(data.equalsIgnoreCase("e")||data.equalsIgnoreCase("exit")){
                        break;
                    }
                    String s = data.toUpperCase();
                    System.out.println(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
    //数据流：用于读取或写出基本数据类型的变量或字符串
    @Test
    public void test() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("dir\\test.txt"));
        dos.writeUTF("洪明旭");
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }
    //将文件中存储的基本数据类型和字符串读取到内存中，保存在变量中
    //注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
    @Test
    public void test4() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("dir\\test.txt"));
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        System.out.println("name=" + name);
        System.out.println("age=" + age);
        System.out.println("isMale" + isMale);

        dis.close();
    }
}
