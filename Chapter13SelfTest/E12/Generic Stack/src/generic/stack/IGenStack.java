package generic.stack;

/**
 * Interface for manipulating content of a stack.
 * 
 * @author Henrik Samuelsson
 */
public interface IGenStack<T> {
    void push(T obj) throws StackFullException;
    T pop() throws StackEmptyException;
}
