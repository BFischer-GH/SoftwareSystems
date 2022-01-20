package ss.week6.threads;

/**
 * Correct communication between IntProducer en IntConsumer.
 */
public class SynchronizedIntCell implements IntCell {

    private int value = 0;
    boolean hasValue = false;

    @Override
    public synchronized void setValue(int valueArg) {
        while (hasValue) {
            try {
                wait();
                System.out.println("setValue started again");
            } catch (InterruptedException e) {
                System.out.println("error: thread is interrupted (in setValue)");
            }
        }
        this.hasValue = true;
        notifyAll();

        this.value = valueArg;
    }


    @Override
    public synchronized int getValue() {
        while (!hasValue) {
            try {
                wait();
                System.out.println("getValue started again");
            } catch (InterruptedException e) {
                System.out.println("error: thread is interrupted (in getValue)");
            }
        }
        this.hasValue = false;
        notifyAll();

        return value;
    }
}

