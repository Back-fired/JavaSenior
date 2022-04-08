package com.hongmingxu.java.Thread;

/**线程通信的例子：使用两个线程打印1-100.线程1，线程2交替打印
 * 涉及到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个
 * norifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 * 说明：
 * 1.wait()、notify()、notifyAll()三个方法必须使用在同步代码块或同步方法中
 * 2.wait()、notify()、notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 * 否则，会出现IllegalMonitorStateException异常
 * 3.wait()、notify()、notifyAll()三个方法是定义在java.lang.Object类中
 * @author hongmingxu
 * @create 2022-03-11 21:28
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                notify();

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
