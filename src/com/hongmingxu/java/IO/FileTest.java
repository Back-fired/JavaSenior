package com.hongmingxu.java.IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**File类的使用
 * @author hongmingxu
 * @create 2022-03-17 22:16
 */
public class FileTest {
    //如何创建File类的实例
    @Test
    public void test1(){
        //构造器1
        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\hongmingxu\\IdeaProjects\\JavaSenior\\src\\com\\hongmingxu\\java\\IO\\hello.txt");

        System.out.println(file1);
        System.out.println(file2);
        //构造器2
        File file3 = new File("C:\\Users\\hongmingxu\\IdeaProjects\\JavaSenior\\src\\com\\hongmingxu\\java","IO");
        System.out.println(file3);
        //构造器3
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("C:\\IO\\hi.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
        System.out.println();
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));

    }
    @Test
    public void test3(){
        File file = new File("C:\\Users\\hongmingxu\\IdeaProjects\\JavaSenior");
        String[] list = file.list();
        for(String s:list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for(File f:files){
            System.out.println(f);
        }
    }
    @Test
    public void test4(){
        File file1 = new File("hello.txt");//必须存在
        File file2 = new File("C:\\io\\h1.txt");//不能存在

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);

    }
    @Test
    public void test5(){
        File file1 = new File("hello.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        File file2 = new File("C:\\Users\\hongmingxu\\IdeaProjects\\JavaSenior");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }
    @Test
    public void test6() throws IOException {
        File file1 = new File("h1.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }

    }
    @Test
    public void test7(){
        File file1 = new File("C:\\io\\io1");

        boolean mkdir = file1.mkdir();
        if (mkdir) {
            System.out.println("创建成功");
        }

        File file2 = new File("C:\\io\\io1");

        boolean mkdir1 = file2.mkdirs();
        if (mkdir1) {
            System.out.println("创建成功");
        }
    }

}
