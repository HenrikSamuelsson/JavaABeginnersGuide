package ticktock;

/**
 * Exercise with threads that communicate by the use of wait() and notify().
 * <p>
 * There are two threads, one will output "Tick" messages and the other output
 * "Tock". The threads communicate so that the messages are printed in the 
 * correct order.
 * 
 * @author Henrik Samuelsson
 */
public class ThreadCom {
    static final int SECONDS_TO_RUN = 5;
    public static void main(String args[]) {
        TickTock tt = new TickTock();
        MyThread mt1 = new MyThread("Tick", tt, SECONDS_TO_RUN);
        MyThread mt2 = new MyThread("Tock", tt, SECONDS_TO_RUN);
        mt1.StartThread();
        mt2.StartThread();
        try{
            mt1.thrd.join();
            mt2.thrd.join();
        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}
