package com.hongmingxu.java.exer;

/**例子：创建三个窗口卖票，总票数为100张
 * 存在线程安全为题，待解决
 * 继承Thread的方式
 * @author hongmingxu
 * @create 2022-03-10 20:40
 */
public class windowTest {
    public static void main(String[] args) {
        window t1 = new window();
        window t2 = new window();
        window t3 = new window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class window extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true) {

            if (ticket > 0){
                System.out.println(getName()+":卖票，票号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}