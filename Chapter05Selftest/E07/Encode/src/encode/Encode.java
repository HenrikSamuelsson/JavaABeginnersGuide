package encode;

/**
 * Codes and decodes a message using a XOR-chiper.
 * 
 * @author Henrik Samuelsson
 */
public class Encode {

    /**
     * Entry point to application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String msg = "Test message.";
        String encmsg = "";
        String decmsg = "";
        String key = "Henrik S";
        
        // Print the coded message.
        System.out.print("Original message: ");
        System.out.println(msg);
        
        // Encode the message.
        for(int i = 0, j = 0; i < msg.length(); i++, j = i%key.length()) {
            encmsg = encmsg + (char) (msg.charAt(i) ^ key.charAt(j));
        }
        
        // Print the encoded message.
        System.out.print("Encoded message: ");
        System.out.println(encmsg);
        
        // Decode the message.
        // Encode the message.
        for(int i = 0, j = 0; i < msg.length(); i++, j = i%key.length()) {
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ key.charAt(j));
        }
        
        // Print the decoded message.
        System.out.print("Decoded message: ");
        System.out.println(decmsg);
    }
    
}
