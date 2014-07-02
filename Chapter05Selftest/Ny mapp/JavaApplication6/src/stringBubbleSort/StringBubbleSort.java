package stringBubbleSort;

/**
 * Sorts strings with a bubble sort alghoritmn.
 *
 * @author Henrik Samuelsson
 */
public class StringBubbleSort {

    /**
     * Entry point to application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str[] = {"Always", "code", "as", "if", "the", "guy", "who", "ends",
            "up", "maintaining", "your", "code", "will", "be", "a", "violent",
            "psychopath", "who", "knows", "where", "you", "live"};

        String temp;
        int size;

        size = str.length;

        // Display array before sorting.
        for (int i = 0; i < size; i++) {
            System.out.print(str[i]);
            System.out.print(" ");
        }
        System.out.println();

        // Sort the strings in the array alphabetically.
        for (int first = 1; first < size; first++) {
            for (int last = size - 1; last >= first; last--) {
                if (str[last - 1].compareTo(str[last]) > 0) {
                    temp = str[last - 1];
                    str[last - 1] = str[last];
                    str[last] = temp;
                }
            }

        }

        // Display array after sorting.
        for (int i = 0; i < size; i++) {
            System.out.print(str[i]);
            System.out.print(" ");
        }
        System.out.println();

    }
}
