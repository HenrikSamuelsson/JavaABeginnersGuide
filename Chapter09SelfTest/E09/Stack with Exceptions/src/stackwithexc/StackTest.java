package stackwithexc;

/**
 * Application used to test the Stack class.
 *
 * @author Henrik Samuelsson
 */
public class StackTest {

    public static void main(String args[]) {
        Stack s = new Stack(5); // Construct a stack.
        char c = '1';

        // Try to overfill the stack to cause an exception.
        for (int i = 0; i < 6; i++) {
            try {
                s.push(c);
                System.out.println("Pushed " + c);
                c++;
            } catch (StackFullException exc) {
                System.out.println(exc);
            }
        }

        // Try getting more elements than there are in the stack.
        for (int i = 0; i < 6; i++) {
            try {
                c = s.pop();
                System.out.println("Popped " + c);
            } catch (StackEmptyException exc) {
                System.out.println(exc);
            }
        }
    }
}
