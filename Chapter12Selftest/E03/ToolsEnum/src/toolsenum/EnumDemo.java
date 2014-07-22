package toolsenum;

/**
 * Exercise that explores enumerations.
 * @author Henrik Samuelsson
 */
public class EnumDemo {

    /**
     * Entry point to application
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        System.out.println("Tools contains the following:");
        for(Tools t : Tools.values()) {
            String toolname = t.toString();
            int ordinal = t.ordinal();
            System.out.println(toolname + " with ordinal rank " + ordinal);        
        }
    }
    
}
