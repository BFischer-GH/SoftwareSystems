package ss.week6.account;

public class MyThread implements Runnable {

    private final double theAmount;
    private final int theFrequency;
    private final Account theAccount;


    // indicate how many times a given amount should be added to the account.
    // The amount may be negative, in which it is subtracted from the account.
    // MyThread should then be executed on a new thread to execute the transactions times times in a loop.
    public MyThread(double amount, int frequency, Account account) {
        this.theAmount = amount;
        this.theFrequency = frequency;
        this.theAccount = account;
    }

    @Override
    public synchronized void run() {
        for(int i = 0; i < theFrequency; i++) {
            this.theAccount.transaction(this.theAmount);
        }
    }


}