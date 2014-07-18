package pkg11.pkg01;

/**
 * Try This 11-1
 * 
 * Creates a thread by extending Thread.
 *
 */
public class MyThread extends Thread {

    /**
     * Constructs a new named MyThread object.
     * @param name name of the thread
     */
    MyThread(String name) {
        super(name); // Name of the thread.
        
        // Note that the thread is not started in the constructor like in the 
        // code in the book. This is because doing it this way means giving out
        // a reference to your object before it is fully constructed. The thread
        // will start before your constructor finishes. This can result in all 
        // kinds of weird behaviors.
    }
    
    /**
     * Work executed by new thread.
     */
    @Override
    public void run() {
        System.out.println(getName() + " starting.");
        try {
            for(int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + getName() + ", count is " + count);
            }
        } catch(InterruptedException exc) {
            System.out.println(getName() + " interrupted.");
        }
        
        System.out.println(getName() + " terminating.");
    }
    
    /**
     * Entry point to application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main thread starting.");
        
        MyThread mt = new MyThread("Child #1");
        mt.start(); // Starts the running of the thread.
        
        for(int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        
        System.out.println("Main thread ending.");
    }
}
