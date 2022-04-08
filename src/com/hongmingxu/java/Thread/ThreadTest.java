package com.hongmingxu.java.Thread;

/**多线程的创建
 * @author hongmingxu
 * @create 2022-03-10 18:55
 */
//例子：遍历100以内的所有偶数
public class ThreadTest {
    public static void main(String[] args) {
        // 3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();
        //如下操作仍然是在main线程中执行
        for(int i = 0;i < 100; i++){
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread类的run()
    @Override
    public void run() {
        for(int i = 0;i < 100; i++){
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

