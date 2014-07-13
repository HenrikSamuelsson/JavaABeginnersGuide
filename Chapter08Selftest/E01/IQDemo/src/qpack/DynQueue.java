package qpack;

/**
 * A dynamic queue. This queue version will allocate more memory should the
 * queue become full.
 */
public class DynQueue implements ICharQ {

    private char q[]; // This array holds the queue.
    private int putLoc, getLoc; // Put and get indices.

    /**
     * Constructs an empty queue given its size.
     *
     * @param size starting size of the queue
     */
    public DynQueue(int size) {
        q = new char[size]; // Allocate memory for the queue.
        putLoc = getLoc = 0; // No elements in a new queue.
    }

    /**
     * Put a character into the queue. Will allocate more memory if needed.
     *
     * @param ch character to be put in the queue
     */
    @Override
    public void put(char ch) {

        if (putLoc == q.length) {
            // Queue is full so shall make it larger.
            char temp[] = new char[q.length * 2];

            // Copy elements into new queue.
            for (int i = 0; i < q.length; i++) {
                temp[i] = q[i];
            }

            q = temp;
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
