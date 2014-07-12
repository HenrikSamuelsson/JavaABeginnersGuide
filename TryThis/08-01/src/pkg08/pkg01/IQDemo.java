package pkg08.pkg01;

/**
 * Illustrates how to implement an interface in Java.
 * An interface for a queue is implemented in three different ways and tested.
 * 
 * @author Henrik Samuelsson
 */
public class IQDemo {

    /**
     * A queue with fixed size. Can only be filled with elements once.
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

    /**
     * A circular queue.          The circular queue works by reusing space in
     * the array that is freed when elements are retrieved.
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

    /**
     * A dynamic queue.          The dynamic will allocate more memory if the
     * original array gets full.
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

    /**
     * Entry point to application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IQDemo q = new IQDemo();
        IQDemo.FixedQueue q1 = q.new FixedQueue(10);
        IQDemo.DynQueue q2 = q.new DynQueue(5);
        IQDemo.CircularQueue q3 = q.new CircularQueue(10);

        ICharQ iQ;

        char ch;
        int i;

        iQ = q1;
        // Put some characters into fixed queue.    
        for (i = 0; i < 10; i++) {
            iQ.put((char) ('A' + i));
        }

        // Show the queue. 
        System.out.print("Contents of fixed queue: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }
        System.out.println();

        iQ = q2;
        // Put some characters into dynamic queue.    
        for (i = 0; i < 10; i++) {
            iQ.put((char) ('Z' - i));
        }

        // Show the queue. 
        System.out.print("Contents of dynamic queue: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }

        System.out.println();

        iQ = q3;
        // Put some characters into circular queue.    
        for (i = 0; i < 10; i++) {
            iQ.put((char) ('A' + i));
        }

        // Show the queue. 
        System.out.print("Contents of circular queue: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }

        System.out.println();

        // Put more characters into circular queue.    
        for (i = 10; i < 20; i++) {
            iQ.put((char) ('A' + i));
        }

        // Show the queue. 
        System.out.print("Contents of circular queue: ");
        for (i = 0; i < 10; i++) {
            ch = iQ.get();
            System.out.print(ch);
        }

        System.out.println("\nStore and consume from"
                + " circular queue.");

        // Use and consume from circular queue. 
        for (i = 0; i < 20; i++) {
            iQ.put((char) ('A' + i));
            ch = iQ.get();
            System.out.print(ch);
        }
        
        System.out.println();

    }
}

