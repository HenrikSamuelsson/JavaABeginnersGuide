package ticktock;

/**
 * A thread that will run the clock for a given time.
 * 
 * @author Henrik Samuelsson
 */
public class MyThread implements Runnable {
    Thread thrd;
    private TickTock ttOb;
    private static int time;
    
    /**
     * Constructs a MyThread object with given name and TickTock object.
     * @param name name of the thread
     * @param tt TickTock object that will be used when the thread runs
     * @param time number of seconds that the clock shall run
     */
    MyThread(String name, TickTock tt, int time) {
        thrd = new Thread(this, name);
        ttOb = tt;
        this.time = time;
    }
    
    /**
     * Starts the execution of the thread.
     */
    public void StartThread() {
        thrd.start();
    }

    @Override
    public void run() {
        if(thrd.getName().compareTo("Tick") == 0) {
            for(int i = 0; i < time; i++) {
                ttOb.tick(true);
            }
            ttOb.tick(false);
        } else {
            for(int i = 0; i < time; i++) {
                ttOb.tock(true);
            }
            ttOb.tock(false);
        }
    }

}
