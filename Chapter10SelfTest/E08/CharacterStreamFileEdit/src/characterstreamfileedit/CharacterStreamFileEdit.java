package characterstreamfileedit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Takes a text file, replaces all spaces with hyphens and stores the result in
 * another file.
 *
 * The name of the files shall be specified as command line arguments.
 *
 * @author Henrik Samuelsson
 */
public class CharacterStreamFileEdit {

    /**
     * Entry point of application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int i;

        // Check so that two command line arguments have been provided.
        if (args.length != 2) {
            System.out.println("ERROR: Two file names must be provided.");
            return;
        }

        // Editing and copying of files. 
        // Note the use of the try-with-resources statement.
        try (FileReader fin = new FileReader(args[0]);
                FileWriter fout = new FileWriter(args[1])) {
            while(true) {
                
                // Read a character from original file.
                i = fin.read();
                
                // Check for end of file.
                if( i == -1) {
                    break;
                }
                
                // Change eventual spaces to hyphens.
                if ((char) i == ' ') {
                    i = '-';
                }
                
                // Write a character to the resulting file.
                fout.write(i); 
                
            }
        } catch (IOException exc) {
            System.out.println("I/O ERROR: " + exc);
        }
    }
}
