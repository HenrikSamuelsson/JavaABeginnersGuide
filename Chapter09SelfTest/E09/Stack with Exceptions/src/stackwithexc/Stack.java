package stackwithexc;

/**
 * A simple stack.
 * 
 * @author Henrik Samuelsson
 */
public class Stack {

    private char stack[]; // Array that the stack is based on.
    private int stackCount; // Keeps track of amount of data in the stack.
    
    /**
     * Constructs a Stack object.
     * 
     * @param size how many elements that the stack shall be able to hold
     */
    Stack(int size) {
        stack = new char[size];
    }
    
    /**
     * Puts new data on top of the stack.
     * 
     * @param c Character to be placed on the stack.
     * @throws stackwithexc.StackFullException
     */
    public void push(char c) throws StackFullException {
        if(stackCount + 1 > stack.length) {
            throw new StackFullException(stack.length);
        } else {
            stack[stackCount++] = c; 
        }      
    }
    
    /**
     * Gets data from the top of the stack.
     * 
     * @return The current char a the top of the stack.
     * @throws stackwithexc.StackEmptyException
     */
    public char pop() throws StackEmptyException {
       if(stackCount == 0){
           throw new StackEmptyException();
       }
       
       stackCount--;
       return stack[stackCount];
    }
}
