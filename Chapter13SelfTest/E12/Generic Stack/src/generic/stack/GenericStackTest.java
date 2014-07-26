package generic.stack;

/**
 * Application used to test the GenericStack class.
 *
 * @author Henrik Samuelsson
 */
public class GenericStackTest {

    public static void main(String args[]) {
        // Setup an array that thet stack will be based on.
        Integer[] iStore = new Integer[5];
        GenericStack<Integer> s = new GenericStack<>(iStore); 
        int i = 1;

        // Try to overfill the stack to cause an exception.
        for (int c = 0; c < 6; c++) {
            try {
                s.push(i);
                System.out.println("Pushed " + i);
                i++;
            } catch (StackFullException exc) {
                System.out.println(exc);
            }
        }

        // Try getting more elements than there are in the stack.
        for (int c = 0; c < 6; c++) {
            try {
                i = s.pop();
                System.out.println("Popped " + i);
            } catch (StackEmptyException exc) {
                System.out.println(exc);
            }
        }
    }
}
