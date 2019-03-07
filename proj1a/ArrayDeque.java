public class ArrayDeque<T> {
    private int size;
    private float usage;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    public ArrayDeque() {

        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;

    }
    public int size() {
    return size;
    }
    public boolean isEmpty() {
        return (size == 0 ? true: false);
    }
    // use the mod method to get the next number
    // e.g. 0 - 1 % 8 = 7
    // then we know that the previous element should be put
    // at the end of the list
    public int minusOne(int index) {
        return Math.floorMod(index-1, items.length);
    }
    public int plusOne(int index, int length) {
        return Math.floorMod(index + 1, length);
    }
    public int plusOne(int index) {
        return Math.floorMod(index +1, items.length);
    }
    /** resize
     *  if the memory is full, expand()
     *  if the memory is too small, reduce()
     *
     *
     */
    private void resize() {
        if(size == items.length) {
            expand();
        }

        if(size < items.length / 4 && items.length > 8) {
            reduce();
        }

    }
    private void expand() {
        resizeHelper(items.length * 2);
    }
    private void reduce() {
        resizeHelper(items.length / 2);
    }
    // use resizeHelper method to copy array!
    private void resizeHelper(int capacity) {
        T[] temp = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for (int i = begin; i != end; i = plusOne(i, temp.length)) {
            items[nextLast] = temp[i];
            nextLast = plusOne(nextLast);
        }
        items[nextLast] = temp[end];
        nextLast = plusOne(nextLast);

    }
    public void addFirst(T item) {
        resize();
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }
    public T getFirst() {
        return items[plusOne(nextFirst)];
    }
    public T removeFirst() {
        resize();
        T res = getFirst();
        nextFirst = plusOne(nextFirst);
        items[nextFirst] = null;
        size--;
        return res;
    }
    public void addLast(T item) {
        resize();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;

    }
    public T getLast() {
        return items[minusOne(nextLast)];

    }
    public T removeLast() {
        resize();
        T res = get(minusOne(nextLast));
        nextLast = minusOne(nextLast);
        items[nextLast] = null;
        size--;
        return res;


    }
    public void printDeque() {
        for (int index = plusOne(nextFirst); index != nextLast; index = plusOne(index)) {
            nextFirst = plusOne(nextFirst);
            System.out.println(items[index]);
            System.out.println(" ");
        }
        System.out.println();
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        index = Math.floorMod(nextFirst + index, items.length);
        return items[index];
    }













}
