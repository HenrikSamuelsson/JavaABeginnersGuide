package average;

/**
 * Calculates the average of ten numbers stored in an array.
 * 
 * @author Henrik Samuelsson
 */
public class Average {

    static double[] val = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.1 };
    /**
     * Entry point of application code.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double sum = 0;
        double average;
        for(int i = 0; i < val.length; i++) {
            sum += val[i];
        }
        average = sum/val.length;
        System.out.println("Average = " + average);
    }
    
}
