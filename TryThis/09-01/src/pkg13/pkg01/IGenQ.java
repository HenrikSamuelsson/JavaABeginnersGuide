package pkg13.pkg01;

/**
 * A generic queue interface.
 * 
 * @param <T> generic element for the queue
 */
public interface IGenQ<T> {
    
    /**
     * Puts an element into the queue.
     * 
     * @param e element to be put in the queue
     * @throws pkg13.pkg01.QueueFullException
     */
    void put(T e) throws QueueFullException;
    
    /**
     * Gets an element from the queue.
     * 
     * @return element from the queue
     * @throws pkg13.pkg01.QueueEmptyException
     */
    T get() throws QueueEmptyException;
}
