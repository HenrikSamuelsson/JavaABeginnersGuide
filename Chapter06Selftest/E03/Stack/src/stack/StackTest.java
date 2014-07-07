package stack;

/**
 * Application used to test the Stack class.
 * 
 * @author Henrik Samuelsson
 */
public class StackTest {
    public static void main(String args[]) {
        Stack s = new Stack(5); // Construct a stack.
        
        // Fill the stack completly.
        char c = '1';
        while(s.push(c)) {
            System.out.println("Pushed " + c);
            c++;
        }
        System.out.println("Stack is full now.");
        
        // Get all the data in the stack.
        c = s.pop();
        while(c != '0') {
            System.out.println("Popped " + c);
            c = s.pop();
        }
        System.out.println("Stack is empty now.");
    }
}
