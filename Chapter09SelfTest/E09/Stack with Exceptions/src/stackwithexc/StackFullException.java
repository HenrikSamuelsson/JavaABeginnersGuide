package stackwithexc;

/**
 * An exception for when trying to push to a full stack.
 * 
 * @author Henrik Samuelsson
 */
public class StackFullException extends Exception {
    int size;
    
    StackFullException(int size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return "Stack is full. Maximum size is " + size;
    }
    
}
