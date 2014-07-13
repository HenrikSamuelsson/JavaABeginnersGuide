package qpack;

/**
 * A charcater queue interface.
 */
public interface ICharQ {
    /**
     * Put a character at the end of the queue.
     * 
     * @param ch character that will go into the queue
     */
    void put(char ch);
    
    /**
     * Get a character from the front of the queue.
     * 
     * @return one character from the queue
     */
    char get();
    
}
