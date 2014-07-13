package qpack;

/**
 * A circular queue. The circular queue works by reusing space in the array that
 * is freed when elements are retrieved.
 */
public class CircularQueue implements ICharQ {

    private char q[]; // This array holds the queue.
    private int putLoc, getLoc; // Put and get indices.

    /**
     * Constructs an empty queue given its size.
     *
     * @param size number of elements that can be put in the queue
     */
    public CircularQueue(int size) {
        q = new char[size + 1]; // Allocate memory for the queue.
        putLoc = getLoc = 0; // No elements in a new queue.
    }

    /**
     * Put a character into the queue.
     *
     * @param ch character to be put in the queue
     */
    @Override
    public void put(char ch) {

        if (putLoc + 1 == getLoc
                | ((putLoc == q.length - 1) & (getLoc == 0))) {
            System.out.println(" - Queue is full.");
            return;
        }
        q[putLoc++] = ch;
        if (putLoc == q.length) {
            putLoc = 0;
        }
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
        char c = q[getLoc++];
        if (getLoc == q.length) {
            getLoc = 0; // loop back
        }
        return c;
    }

}
