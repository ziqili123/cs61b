public class ArrayDeque<Item> {
    private int size ;
    private int first;
    private int last;
    private int step;
    private Item newList[];
    public ArrayDeque(){

        newList = (Item[]) new Object[8];
        size =0;
        first = 7;
        last = 0;
        step = 0;

    }
   /* public int nextLast(int x ){


    }*/
   public void resize(int size){
       Item firstlist[];
       Item b[];
       firstlist = (Item[]) new Object[size+1];
       b = (Item[]) new Object[size-last];
       System.arraycopy(newList,last,b,0,size-last);
       System.arraycopy(newList,0,firstlist,0,last);
       System.arraycopy(b,0,firstlist,first+2, size - last);
       newList = firstlist;

   }
    public void addLast(Item x){
       if(step>7 ){
           resize(size);
           newList[last] = x;
           last +=1;
           first +=1;
       }
       else {
           newList[last] = x;
           last +=1;

        }
       size +=1;
       step +=1;
    }
    public void addFirst(Item x){
        if(step >7){
           resize(size);
           newList[last] = x;

        }
        else{
            newList[first]=x;
            first -=1;
        }
        size+=1;
        step+=1;
    }
    public void removeLast(){
        newList[last-1] =null;
        last -=1 ;
        size -= 1;
        step -=1;

    }
    public void removeFirst(){
        /*Item b [];
        b = (Item[]) new Object[8];
        System.arraycopy(newList,0,b,0,size-1);
         newList = b;*/
        newList[first+1]=null;
        first+=1;
        size-=1;
        step -=1;

    }
    public Item get(int x ){
        Item c;
        c = newList[x-1];
        return c;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args){
        ArrayDeque<Integer> newList = new ArrayDeque<Integer>();
        newList.addLast(2);
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
      /*  System.out.println(newList.size);
        System.out.println(newList.get(1));*/

        newList.removeLast();


    }

}
