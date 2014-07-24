package pkg13.pkg01;

/**
 * An exception for queue-full errors.
 */
public class QueueEmptyException extends Exception {
    
    @Override
    public String toString() {
        return "\nQueue is empty.";
    }

}
