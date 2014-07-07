package stack;

/**
 * A simple stack.
 * Note that it is not possible to push a zero char ('0') since this is used to
 * indicate an empty when popping the stack.
 * 
 * @author Henrik Samuelsson
 */
public class Stack {

    private char stack[]; // Array thet the stack is based on.
    private int stackCount; // Keeps track amount of date in the stack.
    
    /**
     * Constructs a Stack object.
     * 
     * @param size How many elements that the stack shall hold.
     */
    Stack(int size) {
        stack = new char[size];
    }
    
    /**
     * Puts new data on top of the stack.
     * 
     * @param c Character that will be placed on the stack.
     * @return True if the data could be placed on the stack, false otherwise.
     */
    public boolean push(char c) {
        if(stackCount + 1 > stack.length | c == '0') {
            return false;
        } else {
            stack[stackCount++] = c; 
            return true;
        }      
    }
    
    /**
     * Gets data from the top of the stack.
     * 
     * @return The current char a the top of the stack, 0 if the stack is empty.
     */
    public char pop() {
       if(stackCount == 0){
           return '0';
       } else {
           stackCount--;
           return stack[stackCount];
       }
    }
}
