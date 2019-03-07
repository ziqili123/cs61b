
public class LinkedListDeque<T> {
    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;
        private IntNode(IntNode t, T i, IntNode n) {
            prev = t;
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);

        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(T x) {
        sentinel = new IntNode(null, null, null);

        sentinel.next = new IntNode(sentinel, x, sentinel);
        sentinel.prev = sentinel;
        size = 1;

    }


    public void addFirst(T x) {

        sentinel.next = new IntNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T x) {
        sentinel.prev = new IntNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }




    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return res;
    }



    public boolean isEmpty() {
        if (size == 0) {
            return true;

        }

        return false;

    }
    public void printDeque() {
        IntNode p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            System.out.print(p.item);
            System.out.print(" ");
        }
        System.out.println();
    }

    public T get(int index) {
        int count = 0;
        IntNode p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            if (count == index) {
                return p.item;
            }
            count++;
        }
        return null;
    }
    public T getRecursive(int seq) {
        if (seq > size) {
            return null;
        }

        return getRecur(seq, sentinel.next);

    }
    public T getRecur(int num, IntNode curr) {
        if (num == 0) {
            return curr.item;
        }
        return getRecur(num - 1, curr.next);
    }



    public int size() {
        return size;
    }


    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T res = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return res;

    }
 /*   public static void main(String[] args){
        LinkedListDeque y= new LinkedListDeque();

        y.addFirst("tt");
        y.addFirst("ts");
        y.addFirst("st");
        y.addLast("sq");
        y.removeFirst();
        y.removeLast();



    }*/
}
