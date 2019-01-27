public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;
    private IntNode last;


    public SLList() {
        sentinel = new IntNode(64, null);
        size = 0;

    }
    public SLList(int x){
        sentinel = new IntNode(63,null);
        sentinel.next = new IntNode( x, null) ;
        size = 1;

    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Retrieves the front item from the list. */
   public int getFirst() {
        return sentinel.next.item;
    }

    /** Returns the number of items in the list. */
    /*public int size() {
        return size;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
       last.next = new IntNode(x,null);
       last = last.next;
       size +=1;
    /*    size += 1;

        IntNode p = sentinel;

       Advance p to the end of the list.
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
   */
    }

    /** Crashes when you call addLast on an empty SLList. Fix it. */
    public static void main(String[] args) {
        SLList L = new SLList();
        L.addLast(5);
    }
}
