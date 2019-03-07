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
    public int minusOne(int index) {
        return Math.floorMod(index-1, items.length);
    }
    public int plusOne(int index, int length) {
        return Math.pow(index + 1, length);
    }











}
