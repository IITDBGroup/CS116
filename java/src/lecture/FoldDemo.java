/**
 * 
 */
package lecture;

import java.util.List;
import java.util.ArrayList;

/**
 * A class that demos lambdas and higher-order functions and lambdas by mean of the example of the fold operation. 
 * 
 * @author lord_pretzel
 *
 */
public class FoldDemo {
	
	/**
	 * A functional interface for a binary operator with inputs and result of type <T>.
	 * 
	 * @author lord_pretzel
	 *
	 * @param <T>
	 */
    interface BinaryOp<T> {
    	
    	/**
    	 * The compute function implements the binary operator.
    	 * 
    	 * @param lop the left input
    	 * @param rop the right input
    	 * @return the operator result
    	 */
        public T compute(T lop, T rop);
    }

    /**
     * Fold takes a list of type T, a binary operator f of type (T,T) -> T and init value of type T.
     * For a list [e1, e2, ..., en], fold computes:
     * f(f(f(init, e1), e2), ..., en) 
     * 
     * @param l the input list
     * @param f the binary operator
     * @param init the initial value
     * @return final result of the fold
     */
    public static <T> T fold (List<T> l, BinaryOp<T> f, T init) {
        T res = init;
        for(T el: l)
            res = f.compute(res, el);
        return res;
    }
    
    /**
     * Showcase fold by computing the sum (addition) of a list of integers.
     * 
     * @param args ignored
     */
    public static void main(String [] args) {
        List<Integer> l = new ArrayList<Integer> ();
        l.add(1);
        l.add(3);
        l.add(15);

        Integer res = fold(l, (x, y) -> x+y, 0);
        System.out.println(res);
    }
}
