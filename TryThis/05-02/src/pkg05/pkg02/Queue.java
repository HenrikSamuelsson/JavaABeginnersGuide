package pkg05.pkg02;

/**
 * Try This 5-2
 * <p>
 * A queue class for characters.
 */
public class Queue {
    /**
     * Array that holds the queue.
     */
    char q[];
    
    /**
     * Location for the next element to be put in the queue.
     */
    int putloc;
    
    /**
     * Location for the next element to be taken out of the queue.
     */
    int getloc;
    
    /**
     * Constructs a new queue of given size.
     * 
     * @param size max number of elements that can be put in the queue
     */
    Queue(int size) {
        q = new char[size]; // Allocate memory for the queue.
        putloc = getloc = 0;
    }
    
    /**
     * Puts a character in the queue.
     * 
     * @param ch goes into the queue
     */
    void put(char ch) {
        if(putloc==q.length) {
            System.out.println(" - Queue is full.");
            return;
        }
        q[putloc++] = ch;
    }
    
    /**
     * Gets a character from the queue.
     * @return character from the queue
     */
    char get() {
        if(getloc == putloc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        
        return q[getloc++];
    }
}
