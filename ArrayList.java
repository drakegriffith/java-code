import java.util.NoSuchElementException;

/**
 * An implementation of the ArrayList class.
 *
 * @author Christopher Drake Griffith
 * @version 1.2
 *
 */
public class ArrayList<T> {

    /**
     * The initial capacity of the ArrayList.
     */
    public static final int INITIAL_CAPACITY = 9;
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayList.
     */
    public ArrayList() {
        this.size = 0;
        this.backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the element to the specified index.
     *
     * amortized O(1) for index size and O(n) for all other cases.
     *
     * @param index the index at which to add the new element
     * @param data  the data to add at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index > size
     * @throws java.lang.IllegalArgumentException  if data is null
     */
    public void addAtIndex(int index, T data) {
        // exception handling
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Provided index incorrectly inputted. Please pass valid integer.");
        } else if (data == null) {
            throw new IllegalArgumentException("Provided parameter 'data' cannot be null. Please pass a valid argument.");
        }
        // resize array if required
        if (size == INITIAL_CAPACITY) {
            T[] newArray = (T[]) new Object[INITIAL_CAPACITY * 2];
            for (int i = 0; i < INITIAL_CAPACITY; i++) {
                backingArray[i] = newArray[i];
            }
            backingArray = newArray;
        }
        if (index != size) {
            for (int i = size - 1; i >= index; i--) {
                backingArray[i + 1] = backingArray[i];
            }
        }
        backingArray[index] = data;
        size++;
    }

    /**
     * Adds the element to the front of the list.
     *
     * O(n).
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data)  {
        // exception handling
        if (data == null) {
            throw new IllegalArgumentException("Provided parameters cannot be null.");
        }
        // resize array is required
        if (size == INITIAL_CAPACITY) {
            T[] newArray = (T[]) new Object[INITIAL_CAPACITY * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }
        for (int i = size - 1; i >= 0; i--) {
            backingArray[i+1] = backingArray[i];
        }
        backingArray[0] = data;
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * amortized O(1).
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // exception handling
        if (data == null) {
            throw new IllegalArgumentException("Provided params cannot be null.");
        }
        // resize array if required
        if (size == INITIAL_CAPACITY) {
            T[] newArray = (T[]) new Object[INITIAL_CAPACITY * 2];
            for (int i = 0; i < size - 1; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }
        backingArray[size] = data;
        size++;
    }

    /**
     * Removes and returns the element at the specified index.
     *
     * O(1) for index size - 1 and O(n) for all other cases.
     *
     * @param index the index of the element to remove
     * @return the data formerly located at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T removeAtIndex(int index) {
        // error handling
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException("Index must be inside size input.");
        }
        T elemValue = backingArray[index];
        if (index == size - 1) {
            removeFromBack();
        } else {
            for (int i = index; i < size - 1; i++) {
                backingArray[i] = backingArray[i + 1];
            }
            backingArray[size - 1] = null;
        }
        size--;
        return elemValue;
    }


    /**
     * Removes and returns the first element of the list.
     *
     * O(n).
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // error handling
        if (size == 0) {
            throw new NoSuchElementException("This ArrayList is empty.");
        }
        T elemValue = backingArray[0];
        for (int i = 0; i < size - 1; i++) {
            backingArray[i] = backingArray[i+1];
        }
        backingArray[size - 1] = null;
        size--;
        return elemValue;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * O(1).
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // error handling
        if (size == 0) {
            throw new NoSuchElementException("This ArrayList is empty.");
        }
        T elemValue = backingArray[size - 1];
        backingArray[size - 1] = null;
        size--;
        return elemValue;
    }

    /**
     * Returns the element at the specified index.
     *
     * O(1).
     *
     * @param index the index of the element to get
     * @return the data stored at the index in the list
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T get(int index) {
        // error handling
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is outside scope of size.");
        }
        return backingArray[index];
    }

    /**
     * Returns whether or not the list is empty.
     *
     * O(1).
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Clears the list.
     *
     * Resets the backing array to a new array of the initial capacity and
     * resets the size.
     *
     * O(1).
     */
    public void clear() {
        T[] newArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
        backingArray = newArray;
    }

    /**
     * Returns the backing array of the list.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }
}
