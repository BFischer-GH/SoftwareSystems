package ss.week6.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class  TestSyncConsole implements Runnable{
    Lock lock = new ReentrantLock();

    public static synchronized void main(String[] args) {
        new Thread(new TestSyncConsole(), "Thread A").start();
        System.out.println();
        new Thread(new TestSyncConsole(), "Thread B").start();
    }

    public synchronized void run() {
    this.lock.lock();
        try {
            sum();
        } finally {
            this.lock.unlock();
        }
    }

    private synchronized void sum() {
    int a = Console.readInt(Thread.currentThread().getName()+": get number 1?");
    int b = Console.readInt(Thread.currentThread().getName()+": get number 2?");

    int combi = a+b;

    Console.println(Thread.currentThread().getName() +  ": " + a + " + " + b + " = " + combi);

    }
}
// 6.14.1: A Reentrant lock is owned by the last thread that was succesfully locked. It also can be lock after it has been used. only by the thread that owns it.
//         If you own a
// 6.14.2: Reentrant has more features (for example: ability to interrupt)
// 6.14.3: ReentrantLock provides convenient tryLock() method, which acquires lock only if its available or not held by any other thread. This reduce blocking of thread waiting for lock in Java application.
//         ReentrantLock fair by specifying fairness property, while creating instance of ReentrantLock. Fairness property provides lock to longest waiting thread, in case of contention.
//         One more worth noting difference between ReentrantLock and synchronized keyword in Java is, ability to interrupt Thread while waiting for Lock.
//         Most important: allows to change a lot about where you lock (more than synchronized)
// 6.14.3: It needs to be wrapped. That makes the code unreadable. More easily forget to unlock or not in the finally class.