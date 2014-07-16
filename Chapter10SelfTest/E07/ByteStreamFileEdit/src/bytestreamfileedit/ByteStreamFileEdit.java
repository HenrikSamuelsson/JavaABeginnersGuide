package bytestreamfileedit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Opens a file, replaces all spaces with hyphens and stores the result in
 * another file.
 *
 * @author Henrik Samuelsson
 */
public class ByteStreamFileEdit {

    /**
     * Entry point to application.
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        // Check that two file names have been provided.
        if (args.length != 2) {
            System.out.println("ERROR: Missing file name arguments.");
            return;
        }

        // Try to open input file.
        try {
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException exc) {
            System.out.println("ERROR: Input file (" + args[0] + ") could not be found.");
        }

        // Try to open output file.
        try {
            fout = new FileOutputStream(args[1]);
        } catch (FileNotFoundException exc) {
            System.out.println("ERROR: Output file (" + args[1] + ") could not be found.");
        }

        // Edit file and store result if both files are open.
        try {
            if (fin != null & fout != null) {
                do {
                    i = fin.read();
                    if ((char) i == ' ') {
                        i = '-';
                    }
                    if (i != -1) {
                        fout.write(i);
                    }
                } while (i != - 1);
            }
        } catch (IOException exc) {
            System.out.println("ERROR: " + exc);
        }

        // Close the input file.
        try {
            if (fin != null) {
                fin.close();
            }
        } catch (IOException exc) {
            System.out.println("Error closing input file.");
        }

        // Close the output file.
        try {
            if (fout != null) {
                fout.close();
            }
        } catch (IOException exc) {
            System.out.println("Error closing output file.");
        }

    }
}
