package c11e12;

/**
 * Test class for the SynchronizedQueue class.
 *
 * @author Henrik Samuelsson
 */
public class SynchQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedQueue sq;
        Producer p1, p2;
        Consumer c;
        Thread t1, t2, t3;

        sq = new SynchronizedQueue(100);
        c = new Consumer(sq);
        p1 = new Producer(sq);
        p2 = new Producer(sq);

        t1 = new Thread(c);
        t2 = new Thread(p1);
        t3 = new Thread(p2);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
