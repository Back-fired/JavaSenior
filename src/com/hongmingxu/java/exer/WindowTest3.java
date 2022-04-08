package com.hongmingxu.java.exer;

/**
 * @author hongmingxu
 * @create 2022-03-11 19:59
 */
public class WindowTest3 {
    public static void main(String[] args) {
        window3 t1 = new window3();
        window3 t2 = new window3();
        window3 t3 = new window3();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class window3 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true) {

            show();
        }
    }

    private static synchronized void show(){//同步监视器：Window3.class
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
            ticket--;
        }
    }
}