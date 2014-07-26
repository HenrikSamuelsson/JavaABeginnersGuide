package generic.stack;

/**
 * A simple stack.
 * 
 * @author Henrik Samuelsson
 * @param <T> elements stored in the stack
 */
public class GenericStack<T> implements IGenStack<T> {

    private T stack[]; // Array that the stack is based on.
    private int stackCount; // Keeps track of amount of data in the stack.
    
    /**
     * Constructs a Stack object given its size.
     * 
     * @param size how many elements that the stack shall be able to hold
     */
    GenericStack(T[] stackArray) {
        stack = stackArray;
    }
    
    /**
     * Pushes new data on top of the stack.
     * 
     * @param obj element to be pused on the stack
     * @throws stackwithexc.StackFullException
     */
    @Override
    public void push(T obj) throws StackFullException {
        if(stackCount + 1 > stack.length) {
            throw new StackFullException(stack.length);
        } else {
            stack[stackCount++] = obj; 
        }      
    }
    
    /**
     * Gets data from the top of the stack.
     * 
     * @return The current char a the top of the stack.
     * @throws stackwithexc.StackEmptyException
     */
    @Override
    public T pop() throws StackEmptyException {
       if(stackCount == 0){
           throw new StackEmptyException();
       }
       
       stackCount--;
       return stack[stackCount];
    }
}
