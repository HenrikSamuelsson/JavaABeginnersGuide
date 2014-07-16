package pkg10.pkg10;

import java.io.*;

/**
 * Compares the content of two files to check if it is the same or not.
 *
 * To use this program, specify the names of the files to be compared as command
 * line arguments.
 */
public class CompFiles {

    /**
     * Entry point to application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0, j = 0;

        // Check so that two command line arguments have been provided.
        if (args.length != 2) {
            System.out.println("Usage: CompFiles f1 f2");
            return;
        }

        // Start of code section that will compare the files.
        try (FileInputStream f1 = new FileInputStream(args[0]);
                FileInputStream f2 = new FileInputStream(args[1])) {
            // Check the contents of each file.
            do {
                i = f1.read();
                j = f2.read();
                if( i != j) break;
            } while(i != -1 && j != -1);
            
            // Present the result of the check to the user.
            if(i != j) {
                System.out.println("Files differ");
            } else {
                System.out.println("Files are the same.");
            }
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}
