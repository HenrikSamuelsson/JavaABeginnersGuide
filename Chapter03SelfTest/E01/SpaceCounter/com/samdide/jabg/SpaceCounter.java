package com.samdide.jabg;

import java.io.IOException;

/**
 * Counts number of space characters a user enters.
 * @author Henrik Samuelsson
 */
public class SpaceCounter {

    /**
     * Entry point to application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        char ch;
        int spaces = 0;
        do {
            ch = (char) System.in.read();
            if(ch == ' ') {
               spaces++;
            }
        } while(ch != '.' );
        System.out.println("Found " + spaces + " spaces.");
    }
}
