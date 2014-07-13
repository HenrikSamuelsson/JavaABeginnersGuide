package qpack;

/**
 * A queue with fixed size. Can only be filled with elements once.
 *
 * @author Henrik Samuelsson
 */
public class FixedQueue implements ICharQ {

    private char q[]; // This array holds the queue.
    private int putLoc, getLoc; // Put and get indices.

    /**
     * Constructs an empty queue given its size.
     *
     * @param size number of elements that can be put in the queue
     */
    public FixedQueue(int size) {
        q = new char[size]; // Allocate memory for the queue.
        putLoc = getLoc = 0; // No elements in a new queue.
    }

    /**
     * Put a character into the queue.
     *
     * @param ch character to be put in the queue
     */
    @Override
    public void put(char ch) {
        if (q.length == putLoc) {
            System.out.println(" - Queue is full.");
            return;
        }
        q[putLoc++] = ch;
    }

    /**
     * Get a character from the front of the queu.
     *
     * @return character from the queu
     */
    @Override
    public char get() {
        if (getLoc == putLoc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        return q[getLoc++];
    }

}
