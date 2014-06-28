package doubleup;

/**
 * Calculates a series of numbers where each number is twice as big as the
 * previous.
 * 
 * @author Henrik Samuelsson
 */
public class DoubleUp {
    
    /**
     * Entry point to application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Will run the foor loop until i wraps around and becomes negative.
        for(int i = 1; i > 0; i=2*i) {
            System.out.println(i);
        }
    }
}
