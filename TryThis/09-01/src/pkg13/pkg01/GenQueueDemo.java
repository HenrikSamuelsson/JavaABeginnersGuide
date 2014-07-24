package pkg13.pkg01;

/**
 * Try This 13-1
 * 
 * Demonstrates a generic queue class.
 */
public class GenQueueDemo {
    public static void main(String args[]) {
        
        // Create an Integer queue.
        Integer iStore[] = new Integer[10];
        GenQueue<Integer> q1 = new GenQueue<>(iStore);
        
        Integer iVal;
        
        System.out.println("Demonstrate a queue called q1 of Integers.");
        System.out.println();
        try {
            for(int i=0; i < 5; i++) {
                System.out.println("Adding " + i + " to q1.");
                q1.put(i); // Add integer value to q1.
            }
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();
         try {
            for(int i=0; i < 5; i++) {
                System.out.print("Getting next Integer from q1: ");
                iVal = q1.get(); // Add integer value to q1.
                System.out.println(iVal);
            }
        } catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();
        
        // Create an Double queue.
        Double dStore[] = new Double[10];
        GenQueue<Double> q2 = new GenQueue<>(dStore);
        
        Double dVal;
        
        System.out.println("Demonstrate a queue called q2 of Doubles.");
        System.out.println();
        try {
            for(int i=0; i < 5; i++) {
                System.out.println("Adding " + (double)i/2 + " to q2.");
                q2.put((double)i/2);
            }
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();
         try {
            for(int i=0; i < 5; i++) {
                System.out.print("Getting next Double from q2: ");
                dVal = q2.get();
                System.out.println(dVal);
            }
        } catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();
    }
}
