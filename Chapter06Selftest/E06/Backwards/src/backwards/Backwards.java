package backwards;

/**
 * Test of class that can print strings backwards.
 * 
 * @author Henrik Samuelsson
 */
public class Backwards {
 
    /**
     * Print a string backwards by the use of recursion.
     * 
     * @param s The string that shall be printed backwards.
     */
    void printBackwards(String s) {
        if(s.length() != 1) {
            // Remove the first character in the string and calls printBacwards
            // again.
            printBackwards(s.substring(1));
        }
        
        // Print the first character in the string s.
        System.out.print(s.substring(0, 1));
    }
    
    /**
     * Entry point to application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Backwards b = new Backwards();
        b.printBackwards("Test string.");
        System.out.println();  
    }
    
}
