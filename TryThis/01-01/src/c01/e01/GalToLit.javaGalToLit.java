package c01.e01;

/**
 * Converts a fixed amount of gallons to liters.
 */
public class GalToLit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double gallons; // holds the number of gallons
        double liters; // holds the number of liters
        
        gallons = 10; // start with 10 gallons
        liters = gallons * 3.7854; // calculate number of liters
        
        System.out.println(gallons + " gallons is " + liters + " liters.");
    }
    
}
