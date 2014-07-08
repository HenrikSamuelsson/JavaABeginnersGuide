package sumit;

/**
 * Experiments with varargs.
 * 
 * @author Henrik Samuelsson
 */
public class SumIt {
    
    /**
     * Sums integers.
     * 
     * @param n Variable number of integers that will be summed up.
     * @return The sum of the integers provided as parameters.
     */
    static int sum(int ... n) {
        int totalSum = 0;
        
        for(int i = 0; i < n.length; i++) {
            totalSum += n[i];
        }
        return totalSum;
    }

    /**
     * Entry point to application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3));
        System.out.println(sum(1, 2, 3, 4, 5));
    }
    
}
