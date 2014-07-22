package trafficlights;

/**
 * A computerized traffic light.
 *
 * @author Henrik Samuelsson
 */
public class TrafficLightSimulator implements Runnable {

    /**
     * The thread that runs the simulation.
     */
    private Thread thrd;
    /**
     * Holds the current traffic light color.
     */
    private TrafficLightColor tlc;
    /**
     * Set to true to stop the simulation.
     */
    boolean stop = false;
    /**
     * True when the light has changed.
     */
    boolean changed = false;

    /**
     * Constructs a TrafficLightSimulator with a given color.
     *
     * @param color initial color of the light
     */
    TrafficLightSimulator(TrafficLightColor color) {
        tlc = color;
        thrd = new Thread(this);
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;
        thrd = new Thread(this);
    }

    /**
     * Runs the light.
     */
    @Override
    public void run() {
        while (!stop) {
            try {
                Thread.sleep(tlc.getDuration());
            }catch (InterruptedException exc) {
                System.out.println(exc);
            }
        changeColor();
    }
}

/**
 * Change color depending on the current color.
 */
synchronized void changeColor() {
        switch (tlc) {
            case RED:
                tlc = TrafficLightColor.YELLOW_FROM_RED;
                break;
            case YELLOW_FROM_RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW_FROM_GREEN;
                break;
            case YELLOW_FROM_GREEN:
                tlc = TrafficLightColor.RED;
        }

        changed = true;
        notify(); // signal that the light has changed 
    }

    /**
     * Wait until a light change occurs.
     */ 
    synchronized void waitForChange() {
        try {
            while (!changed) {
                wait(); // wait for light to change 
            }
            changed = false;
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    /**
     * Return the current color.
     * @return color of the traffic light
     */
    synchronized TrafficLightColor getColor() {
        return tlc;
    }

    /**
     * Stops the traffic light.
     */
    synchronized void cancel() {
        stop = true;
    }
    
    /**
     * Starts the traffic light.
     */
    synchronized void start() {
        stop = false;
        thrd.start();
    }
}
