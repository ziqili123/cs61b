
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
    private IntNode lastEle;
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        lastEle = sentinel;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
  /*  public LinkedListDeque(T x){
        sentinel = new IntNode(null, x ,null);
        lastEle = sentinel;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }*/

    public void addFirst(T x) {

        sentinel.next = new IntNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        if (size == 0) {
            lastEle = lastEle.next;
        }
        size += 1;
    }
    public T removeFirst() {
        if (size == 0) {
            return sentinel.item;
        } else {
            T c;
            c = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return c;
        }

    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;

        }

        return false;

    }
    public void printDeque() {
        IntNode p = sentinel.next;
        for (int i = 0; i < this.size(); i++) {
            System.out.println(p.item + " ");
            p = p.next;
        }
    }

    public T get(int seq) {
        int num = seq;
        IntNode p = sentinel.next;
        if (num == 0) {
            return p.item;
        } else {
            for (int i = 0; i < num; i++) {
                p = p.next;

            }
            return p.item;

        }
    }
    public T getRecursive(int seq) {
        if(seq > size) {
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
    public void addLast(T x) {
  /*   IntNode p = sentinel;
     while(p.next != sentinel){
         p = p.next;
     }
     p.next = new IntNode(x,p.next);*/
        size += 1;
        lastEle.next = new IntNode(lastEle, x, lastEle.next);
        lastEle = lastEle.next;

    }
    private T getLast() {

        return lastEle.item;
    }
    public T removeLast() {
        if (size == 0) {
            return sentinel.item;
        } else {
            T c;
            c = lastEle.item;
            lastEle.prev.next = sentinel;
            lastEle = lastEle.prev;
            size -= 1;
            return c;
        }

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
