package ss.week6.threads;

public class TestConsole implements Runnable{

    public static void main(String[] args) {
        new Thread(new TestConsole(), "Thread A").start();
        System.out.println();
        new Thread(new TestConsole(), "Thread B").start();
    }

    @Override
    public void run() {
    sum();
    }

    private void sum() {
    int a = Console.readInt(Thread.currentThread().getName()+": get number 1?");
    int b = Console.readInt(Thread.currentThread().getName()+": get number 2?");

    int combi = a+b;

    Console.println(Thread.currentThread().getName() +  ": " + a + " + " + b + " = " + combi);

    }
}
