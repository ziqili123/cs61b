package synthesizer;
import java.util.Iterator;
public interface BoundedQueue <T> extends Iterable<T> {
    int capacity();     // return size of the buffer
    int fillCount();    // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();

    @Override
    Iterator<T> iterator();

    default boolean isEmpty() {
        if (fillCount() == 0) {
            return true;
        }
        return false;
    }


    default boolean isFull() {
        if (fillCount() == capacity()) {
            return true;
        }
        return false;
    }

}