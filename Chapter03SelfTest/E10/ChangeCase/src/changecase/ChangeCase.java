package changecase;

/**
 * Changes lower case characters to upper and vice versa.
 * Supports the Swedish letters å, ä and ö in addition to the letters in the
 * English alphabet.
 * 
 * @author Henrik Samuelsson
 */
public class ChangeCase {

    /**
     * Entry point to application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.io.IOException {
        char c;
        int changeCount = 0;
       
        System.out.println("Enter period to stop.");
        
        do {
            c = (char) System.in.read();
            if((c >= 'a' & c <= 'z' ) || (c == 'å') || (c == 'ä') || (c == 'ö')) {
                c -= 32;
                changeCount++;
                System.out.print(c);
            }
            else if((c >= 'A' & c <= 'Z' )  || (c == 'Å') || (c == 'Ä') || (c == 'Ö')) {
                c += 32;
                changeCount++;
                System.out.print(c);
            }
        } while(c != '.');
        System.out.println("\nChangend " + changeCount + " letters.");
    }
}
