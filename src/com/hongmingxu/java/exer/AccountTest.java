package com.hongmingxu.java.exer;

/**银行有一个账户，连个储户分别向同一个账户存3000元，
 * 每次存1000，存3次。每次存完打印账户余额
 * 分析：
 * 1.是否是多线程问题？ 是
 * 2.是否有共享数据? 是，账户
 * 3.是否有线程安全问题？ 有
 * 4.考虑如何解决线程安全问题？ 同步机制：有三种方式
 * @author hongmingxu
 * @create 2022-03-11 21:12
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }
}

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void deposit(double amt){
        if (amt > 0) {
            balance += amt;
            System.out.println("存钱成功，余额为："+balance);
        }
    }
}

class Customer implements Runnable{
    private Account acct;
    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}
