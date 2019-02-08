/**
 * 
 */
package lecture;

/**
 * A generic list datastructure.
 * 
 * @author lord_pretzel
 *
 */
public class MyList<E> {
    
    private ListCell head;
    private ListCell tail;
    
    private class ListCell {
        E value;
        ListCell next;
        
        public ListCell(E value) {
            this.value = value;
        }
    }
    
    public MyList () {
        head = null;
        tail = null;
    }
    
    public void append(E el) {
        ListCell n = new ListCell(el);
        if (head == null) {
            head = n;
            tail = n;
        }
        else {
            tail.next = n;
        }
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        ListCell cur = head;
        while(cur != null) {
            result.append(cur.value.toString());
            if(cur.next != null)
                result.append(", ");
            cur = cur.next;
        }
        result.append("]");
        return result.toString();
    }
    
    public static void main (String[] args) {
    	MyList<Integer> ints = new MyList<Integer> ();
    	ints.append(1);
    	ints.append(2);
    	System.out.println(ints);
    }
}
