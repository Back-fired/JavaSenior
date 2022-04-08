package com.hongmingxu.java.exer;

/**例子：创建三个窗口卖票，总票数为100张
 * 实现Runnable接口的方式
 * 存在线程安全，待解决
 * @author hongmingxu
 * @create 2022-03-10 21:06
 */
public class WindowTest1 {
    public static void main(String[] args) {
        window1 w = new window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class window1 implements Runnable{
    private int ticket = 100;
//    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized(this/*obj*/) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "：卖票票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}