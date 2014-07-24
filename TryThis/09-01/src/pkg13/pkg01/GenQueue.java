package pkg13.pkg01;

/**
 * A generic, fixed-size queue class.
 * @param <T> generic element stored in the queue
 */
public class GenQueue<T> implements IGenQ<T> {
    /** Array that holds the queue. */
    private T q[];
    /** Put index. */
    private int putloc;
    /** Get index. */
    private int getloc;
    
    /** 
     * Construct an empty queue with the given array.
     */
    public GenQueue(T[] aRef) {
        q = aRef;
        putloc = getloc = 0;
    }

    @Override
    public void put(T e) throws QueueFullException {
        if (putloc == q.length) {
            throw new QueueFullException(q.length);
        }
        
        q[putloc++] = e;
    }

    @Override
    public T get() throws QueueEmptyException {
        
        if(getloc == putloc) {
            throw new QueueEmptyException();
        }
        
        return q[getloc++];
    }
    
}
