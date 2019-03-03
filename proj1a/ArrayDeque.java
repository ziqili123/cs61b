public class ArrayDeque<T> {
    private int size;
    private int first;
    private int last;
    private int step;
    private T[] newList;
    public ArrayDeque() {

        newList = (T[]) new Object[8];
        size = 0;
        first = 7;
        last = 0;
        step = 0;

    }
   /* public int nextLast(int x ){


    }*/
    private int first(int lastA) {
        if (lastA > 1) {
            first = lastA - 2;
        } else if (lastA == 1) {
            first = size;
        } else if (lastA == 0) {
            first = size - 1;
        }
        return first;
    }
    private void resize(int sizeA) {
        T[] firstlist;
        T[] b;
        firstlist = (T[]) new Object[sizeA + 1];
        b = (T[]) new Object[sizeA - last];
        System.arraycopy(newList, last, b, 0, sizeA - last);
        System.arraycopy(newList, 0, firstlist, 0, last);
        System.arraycopy(b, 0, firstlist, first + 2, sizeA - last);
        newList = firstlist;

    }
    public void addLast(T x) {
        if (step > 7) {
            resize(size);
            newList[last] = x;
            last += 1;
        } else {
            newList[last] = x;
            last += 1;

        }
        size += 1;
        step += 1;
        first = first(last);
    }
    public void addFirst(T x) {
        if (step > 7) {
            resize(size);
            newList[last] = x;

        } else {

            newList[first] = x;

        }
        size += 1;
        step += 1;
    }
    public T removeLast() {
        if (size == 0) {
            return newList[0];
        } else {

            T c;
            c = newList[last];
            newList[last] = null;

            last -= 1;
            size -= 1;
            step -= 1;
            return c;
        }
    }
    public T removeFirst() {
        /*Item b [];
        b = (Item[]) new Object[8];
        System.arraycopy(newList,0,b,0,size-1);
         newList = b;*/
        if (size == 0) {
            return newList[0];
        } else {

            T c;
            c = newList[first + 1];
            newList[first + 1] = null;
            first += 1;
            size -= 1;
            step -= 1;
            return c;
        }
    }
    public T get(int x) {
        T c;
        c = newList[x - 1];
        return c;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(newList[i]);
        }
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;

        }

        return false;

    }

    public static void main(String[] args) {
        ArrayDeque<Integer> newList = new ArrayDeque<Integer>();
       /* newList.addLast(2);
        newList.addFirst(1);
        newList.addLast(2);
        newList.addLast(2);
        newList.addFirst(1);
        newList.removeFirst();
        newList.addFirst(1);
        newList.addFirst(1);
        newList.addFirst(1);
        newList.addLast(3);
        newList.addFirst(4);
        System.out.println(newList.size);
        System.out.println(newList.get(8));*/
        newList.addFirst(1);
        newList.addFirst(1);
        newList.addFirst(1);
        newList.addFirst(1);
        newList.addFirst(1);
        newList.addFirst(1);
        newList.addFirst(1);
        newList.addFirst(1);

        newList.removeLast();


    }

}
