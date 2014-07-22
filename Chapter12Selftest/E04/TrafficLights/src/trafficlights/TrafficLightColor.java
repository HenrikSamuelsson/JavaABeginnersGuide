package trafficlights;

/**
 * An enumeration of the colors of a traffic light.
 *
 * @author Henrik Samuelsson
 */
public enum TrafficLightColor {

    RED(2000), GREEN(2000), YELLOW_FROM_RED(500), YELLOW_FROM_GREEN(500);
    
    /** 
     * How long (in ms) that this traffic light color shall be on before moving
     * on.
     */
    private int duration;

     /**
     * Constructs a TrafficLightColor with given duration.
     * 
     * @param duration on-time for the particular color
     */
    TrafficLightColor(int duration) {
        this.duration = duration;
    }
    
    /**
     * Getter for the duration.
     * @return on-time in ms
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Setter for the duration.
     * @param duration on-time in ms
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
}
