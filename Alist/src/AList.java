/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item> {
    private int size;
    private Item[] newList;
    /** Creates an empty list. */
    public AList() {
        newList = (Item[]) new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    private void resize(int capacity){

        Item [] a;
        a = (Item[]) new Object [capacity];
        System.arraycopy(newList,0,a,0,size);

        newList = a;
    }
    public void addLast(Item x) {
        if(newList.length ==size ){
           resize(size+1);
        }
            newList[size] = x;
            size +=1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return newList[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return newList[i-1];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Item removeLast() {
       Item x = getLast();
       newList[size-1] = null;
        size-=1;
        return x;
    }
    public static void main(String[] args){
        AList newList = new AList();

        for(int i = 0; i<100000;i++){
            newList.addLast(2);
        }
        newList.addLast(1);

        Object x = newList.get(100);
        System.out.println(x);
        System.out.println(newList.size());

    }
} 