package ticktock;

/**
 * Uses wait() and notify() to create a ticking clock.
 *
 * @author Henrik Samuelsson
 */
public class TickTock {

    /**
     * Contains the state of the clock.
     * <p>
     * Valid states are ticked or tocked.
     */
    String state;

    /**
     * Changes the state of the clock to ticked.
     *
     * @param running flag that is used to stop the clock
     */
    synchronized void tick(boolean running) {
        state = "ticked"; // Set the current state to ticked.
        if (!running) { // Shall stop the clock.
            notify(); // Notify any waiting threads.
            return;
        }
        System.out.print("Tick ");
        try {
            Thread.sleep(500); // 2 x 500ms = 1s for one complete Tick Tock.
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
        notify(); // Notify any waiting threads i.e. the tock() thread.
        try {
            while (state.equals("ticked")) {
                wait(); // Wait for tock() to complete.
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }

    /**
     * Changes the state of the clock to tocked.
     *
     * @param running flag that is used to stop the clock
     */
    synchronized void tock(boolean running) {
        state = "tocked"; // Set the current state to tocked. 
        if (!running) { // Shall stop the clock.
            notify(); // Notify any waiting threads.
            return;
        }
        System.out.println("Tock");
        try {
            Thread.sleep(500); // 2 x 500ms = 1s for one complete Tick Tock.
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
        notify(); // Notify any waiting threads i.e. the tock() thread.
        try {
            while (state.equals("tocked")) {
                wait(); // Wait for tick() to complete.
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }

}
