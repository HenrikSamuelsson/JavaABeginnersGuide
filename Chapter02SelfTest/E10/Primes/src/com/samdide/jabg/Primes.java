package com.samdide.jabg;

/**
 * Finds all the prime numbers smaller than 100.
 * @author Henrik Samuelsson
 */
public class Primes {
    static final int MAX = 100;
    static final int MIN = 2;
    
    /**
     * Entry point to application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int m, n;
        boolean isPrime;
        for(m = MIN; m <= MAX; m++) {    
            isPrime = true; // Assume that current m is prime.
            for(n = MIN; n < m; n++ ) {
                if(m%n == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                System.out.println(m +" is prime");
            }
        }         
    }
}
