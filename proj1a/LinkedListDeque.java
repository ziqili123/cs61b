import java.util.LinkedList;

public class LinkedListDeque<Generic> {
    public class IntNode{
            public Generic item;
            public IntNode next;
            public IntNode prev;
            public IntNode(IntNode t, Generic i, IntNode n){
                prev = t;
                item = i;
                next = n;
            }
}
    private IntNode sentinel;
    private int size;
    private IntNode lastEle;
    public LinkedListDeque(){
        sentinel = new IntNode(null, null, null);
        lastEle = sentinel;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(Generic x){
        sentinel = new IntNode(null, x ,null);
        lastEle = sentinel;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }

   /* public LinkedListDeque(int x){
       sentinel = new IntNode(63, null);
       sentinel.next.next.next = sentinel;
       size =1 ;
       sentinel.next = new IntNode(x, sentinel.next);
    }
*/
    public void addFirst(Generic x ){
        sentinel.next = new IntNode(sentinel.next.prev, x, sentinel.next);
        size +=1;
    }
    public void removeFirst(){

        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size-=1;

    }
    public boolean isEmpty(){
        if( size == 0){
            return true;

        }
        else{
            return false;
        }
    }
    public void printDeque(){
        IntNode p =sentinel.next;
        for( int i = 0; i< this.size(); i++){
            System.out.println(p.item+" ");
            p = p.next;
        }
    }

    public Generic get(int seq) {
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
    public Generic getRecursive(int seq){

         IntNode p = sentinel.next;

        if(seq ==0){
            return p.next.item;
        }
        else{
            IntNode t = p.next;
            seq -=1;
            t.getRecursive(seq);
    }

    }

    public int size(){
        return size;
    }
    public void addLast(Generic x){
  /*   IntNode p = sentinel;
     while(p.next != sentinel){
         p = p.next;
     }
     p.next = new IntNode(x,p.next);*/
     size +=1;
     lastEle.next = new IntNode(lastEle, x, lastEle.next);

     lastEle = lastEle.next;

}
    public Generic getLast(){

        return lastEle.item;
    }
    public void removeLast(){

    lastEle.prev.next = sentinel;
    lastEle = lastEle.prev;
    size -=1;

    }
    public static void main(String[] args){
        LinkedListDeque y= new LinkedListDeque();
        y.addFirst("tst");
        y.addFirst("tt");
        y.addFirst("ts");
        y.addFirst("st");
        y.printDeque();
        System.out.println(y.getRecursive(2));


    }
}
