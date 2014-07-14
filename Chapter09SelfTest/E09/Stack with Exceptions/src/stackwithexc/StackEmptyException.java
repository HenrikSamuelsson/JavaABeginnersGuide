package stackwithexc;

/**
 * An exception for when trying to pop from a empty stack.
 * 
 * @author Henrik Samuelsson
 */
public class StackEmptyException extends Exception {
   
    @Override
    public String toString() {
        return "Stack is empty.";
    }
    
}
