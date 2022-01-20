package ss.week6.account;

public class AccountSync {


    public static void main(String[] args) {

        Account account1 = new Account();
        int iterations = 50000;

        Thread alphaThread = new Thread(new MyThread(100, iterations, account1));
        Thread betaThread = new Thread(new MyThread(-100, iterations, account1));

        try {
            alphaThread.join();
            betaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The balance is $ "+(account1.getBalance()));
    }

}