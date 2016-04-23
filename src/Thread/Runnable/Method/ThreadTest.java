package Thread.Runnable.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * Runnable
 * synchronized 对象锁
 * wait 线程阻塞
 * notify 释放阻塞线程
 */

public class ThreadTest {
    private List<Integer> list = new ArrayList<>();

    /**
     * 1.在调用wait方法前，需要拿到对象的锁才可以，所以会有先synchronized，后wait()的组合形式出现，
     * 2.wait吊起线程的时候会释放synchronized锁
     **/
    public synchronized void addList() throws InterruptedException {
        if (list.size() != 0) {
            System.out.println(Thread.currentThread().getName() + "有炮弹，阻塞线程");
            wait();
        } else {
            list.add(1);
            System.out.println(Thread.currentThread().getName() + ":添加炮弹成功...");
            notify();
        }
    }

    public synchronized void moveList() throws InterruptedException {
        if (list.size() == 0) {
            System.out.println(Thread.currentThread().getName() + "无炮弹，阻塞线程");
            wait();
        } else {
            list.remove(0);
            System.out.println(Thread.currentThread().getName() + ":发射炮弹成功...");
            notify();
        }
    }
}


class AddLList implements Runnable {
    private ThreadTest test;

    public AddLList(ThreadTest test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                test.addList();
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}

class RemoveList implements Runnable {
    private ThreadTest test;

    public RemoveList(ThreadTest test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            for (int o = 0; o < 10; o++) {
                test.moveList();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ActionRunning {
    public static void main(String[] args) throws InterruptedException {
        /**
         一定要明确使用的共享资源是什么，我刚开始学习写成以下方式：
         Thread thread1 = new Thread(new AddLList(new Test()));
         Thread thread2 = new Thread(new RemoveList(new Test()));
         因为直接声明两个Test对象，开启的两个线程没有使用共享List，因为list初始化长度为0，导致两个线程开启就会阻塞。
         **/
        ThreadTest test = new ThreadTest();
        Thread thread1 = new Thread(new AddLList(test));
        Thread thread2 = new Thread(new RemoveList(test));
        thread2.start();
        Thread.sleep(1000);
        thread1.start();
        Thread.sleep(1000);
    }
}