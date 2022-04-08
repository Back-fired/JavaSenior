package com.hongmingxu.java.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**解决线程安全问题的方式三：Lock锁
 * @author hongmingxu
 * @create 2022-03-11 20:57
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable{
    private int ticket = 100;
    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
          try {
              //调用锁定方法：lock()
              lock.lock();
              if (ticket > 0) {
                  System.out.println(Thread.currentThread().getName()+":售票，票号为："+ticket);
                  ticket--;
              }else{
                  break;
              }
          }finally {
              //调用解锁方法：unlock()
              lock.unlock();
          }
        }
    }
}