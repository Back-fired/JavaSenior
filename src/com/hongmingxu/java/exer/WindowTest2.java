package com.hongmingxu.java.exer;

/**使用同步方法解决实现Runnable接口的线程安全问题
 * @author hongmingxu
 * @create 2022-03-11 19:47
 */
public class WindowTest2 {
    public static void main(String[] args) {
        window2 w = new window2();

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

class window2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "：卖票票号为：" + ticket);
            ticket--;
        }
    }
}