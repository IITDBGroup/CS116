/**
 * 
 */
package midterm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lord_pretzel
 *
 */
public class ListStuff {

	private static final List<Integer> l1 = new ArrayList<Integer>();
	private static final List<Integer> l2 = new ArrayList<Integer>();

	static {
		int[] l1a = {1,2,3,4,4,4,5,6,7};
		int[] l2a = {1,4,-1,1,3,4};

		for(int i = 0; i < l1a.length; i++)
			l1.add(l1a[i]);

		for(int i = 0; i < l2a.length; i++)
			l2.add(l2a[i]);
	}

	
	/**
	 * Count the number of occurrences of {@code searchEl} in list {@code l}.
	 * 
	 * @param l input list
	 * @param searchEl the element to search for
	 * @return the number of occurrences of {@code searchEl}
	 */
	public static int countOccurances(List<Integer> l, int searchEl) {
		int count = 0;
		
		for(Integer i: l) {
			if(i == searchEl)
				count++;
		}
		
		return count;
	}
	
	/**
	 * Given a list {@code l} return true if this list is in order. A list is in order if the elements of the list are sorted in increasing order. 
	 * For example, (1,2,5,10,14) is sorted increasingly, but (1,4, 6, 2, 9) is not since 2 should appear before 4.  
	 *  
	 * @param l
	 * @return true if the list is sorted in increasing order
	 */
	public static boolean isInOrder(List<Integer> l) {
		for(int i = 0; i < l.size() - 1; i++) {
			if(l.get(i) > l.get(i+1)) // found element that is out of order
				return false; 
		}
		return true;
	}
	
	/**
	 * Return the greatest element from list {@code l}.
	 * 
	 * @param l the input list
	 * @return the greatest element.
	 */
	public static int max(List<Integer> l) {
		int max = l.get(0);
		
		for(Integer i: l) 
			if (i > max)
				max = i;
		return max;
	}
	
	public static void main (String[] args) {
		System.out.println("l1 contains this many occurances of 4: " + countOccurances(l1, 4));
		System.out.println("l2 contains this many occurances of 1: " + countOccurances(l2, 1));
		System.out.println("l1 is sorted: " + isInOrder(l1));
		System.out.println("l2 is sorted: " + isInOrder(l2));
		System.out.println("l1 max is:" + max(l1));
		System.out.println("l2 max is:" + max(l2));
	}
	
	
}
