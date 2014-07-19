package pkg11.pkg02;

/**
 * Try This 11-2 Controlling the main thread. Slightly modified from the version
 * in the book.
 *
 * @author Henrik Samuelsson
 */
public class UseMain {

    /**
     * Entry point of application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread thrd;
        int priority;

        // Get the main thread.
        thrd = Thread.currentThread();

        // Display main thread's name.
        System.out.println("Main thread is called: " + thrd.getName());

        // Display main thread's priority.
        priority = thrd.getPriority();
        System.out.println("Main thread priority: " + priority);

         // Change the name and the priority a couple of times.
        for (int i = 0; i < Thread.MAX_PRIORITY; i++) {
            System.out.println();
           
            System.out.println("Changing name and priority.");
            thrd.setName("Thread #" + i);
            priority = priority % Thread.MAX_PRIORITY + 1;
            thrd.setPriority(priority);

            System.out.println("Main thred is now called: " + thrd.getName());
            System.out.println("Main thread priority is now:" + thrd.getPriority());
        }
      
    }

}
