/**
 * 
 */
package lecture;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


/**
 * This class implements a solver for the Towers of Hanoi puzzle.
 * 
 * In the towers of Hanoi problem we have three stakes (left, middle, right) and a set of n discs of sizes n, n-1, ...,1. These discs are stacked in decreasing size on the left stake. To solve the towers of Hanoi one has to move the discs to the right stake such that they are ordered by increasing size. A valid move is taking the top disc from one of the stakes and moving it to a different stake such that it is not placed on top of a smaller disc. For instance, here is a solution for 3 discs:

<pre>
Start with all 3 disc on the left stake

 1
 2
 3
 |   |   |

Move disc 1 to the right stake


 2
 3       1
 |   |   |

Move disc 2 to the middle stake



 3   2   1
 |   |   |

Move disc 1 to the middle stake


     1
 3   2   
 |   |   |

Move disc 3 to the right stake


     1
     2   3
 |   |   |

Move disc 1 to the left stake



 1   2   3
 |   |   |

Move disc 2 to the right stake


         2
 1       3
 |   |   |

Move disc 1 to the right stake

         1
         2
         3
 |   |   |

Moving 3 elements is relatively straight-forward. However, for a large number of elements it is not even clear immediatly whether it is even possible to solve the puzzle. Looking at the solution above we can make the following observation:
</pre>
 
 * The process can be broken down into 3 coarser steps:
 
 <ul>
       <li>move every disc except for the largest one to the middle stack, creating a stack of size n-1</li>
       <li>move the largest disc n to the right stack (which is now empty)</li>
       <li>move n-1 discs from the middle stack to the right stack</li>
</ul>

 * Note that this breaks down the problem of moving n discs into a subproblem of moving n-1 discs and one of moving 1 disc. Now, of course we have to move n-1 discs while there still exists a larger disc n on one of the stacks. However, since this disc is on the bottom of some stack and all n-1 discs are smaller this does not prevent us in any movement of the n-1 discs. That is, we are truely creating an independent subproblem of a smaller size. That is, the towers of Hanoi puzzle has a relatively easy recursive solution.
 * 
 * @author lord_pretzel
 *
 */
public class TowersOfHanoi {


	/**
	 * Storing which discs are on which of the three sticks each of which is stored as a Stack.
	 */
	private List<Stack<Integer>> stacks;
	/**
	 * The number of discs in the puzzle.
	 */
	private int numDiscs;
	/**
	 * The number of moves needed to solve the puzzle. This is updated during solving.
	 */
	int moves = 0;
	
	/**
	 * Create a new Towers of Hanoi puzzle.
	 * @param n The number of discs
	 */
	public TowersOfHanoi (int n) {
		this.numDiscs = n;
		stacks = List.of(new Stack<Integer>(), new Stack<Integer>(), new Stack<Integer>());
		Stack<Integer> left = stacks.get(0);
		for(int i = n; i > 0; i--)
			left.push(i);
	}

	/**
	 * The <tt>toString</tt> method returns a visualization of the current state of the puzzle.
	 * 
	 * @return a string encoding the current state of the puzzle.
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		int maxLen = stacks.stream().map(x -> x.size()).max(Integer::compareTo).get();

		for(int i = maxLen - 1; i >= 0; i--) {
			String line = String.format("%s   %s   %s\n", 
					(stacks.get(0).size() > i) ? stacks.get(0).get(i) : " ",
					(stacks.get(1).size() > i) ? stacks.get(1).get(i) : " ",
					(stacks.get(2).size() > i) ? stacks.get(2).get(i) : " "
					);
			result.append(line);
		}
		result.append("|   |   |");
		return result.toString();
	}

	/**
	 * This methods solves the puzzle using the recursive method {@link #move(int, int, int)}
	 */
	public void solve() {
		System.out.println("initial configuration:\n\n" + toString());
		move(0, 2, numDiscs);
	}

	/**
	 * Solves a subtask of the puzzle by moving <tt>n</tt> discs from stake <tt>from</tt> to stake <tt>to</tt>.
	 * 
	 * @param from takes discs from this stake
	 * @param to move discs to this stake
	 * @param n number of discs to move
	 */
	public void move(int from, int to, int n) {
		System.out.printf("solve moving %d discs from %d to %d\n", n, from, to);
		int buf = getBuffer(from,to);
		if (n > 1) {
			move(from, buf, n-1);
		}
		moveSingleDisc(from, to);
		if (n > 1) {
			move(buf, to, n-1);
		}
	}

	/**
	 * Move the top-most disc of stake <tt>from</tt>
	 * @param from
	 * @param to
	 */
	public void moveSingleDisc(int from, int to) {
		moves++;
		int disc = stacks.get(from).pop();
		stacks.get(to).push(disc);        
		System.out.printf("move disc %d from %d to %d:\n\n%s\n", disc, from, to, toString());
	}

	/**
	 * Determines which stake to use as a buffer when moving elements from stake <tt>from</tt> to stake <tt>to</tt> 
	 * @param from we are moving discs from this stake
	 * @param to we are moving discs to this stake
	 * @return the stake to use as buffer
	 */
	private int getBuffer(int from, int to) {
		if (from == 0 && to == 2)
			return 1;
		if (from == 0 && to == 1)
			return 2;
		if (from == 1 && to == 0)
			return 2;
		if (from == 1 && to == 2)
			return 0;
		if (from == 2 && to == 0)
			return 1;
		else // (from == 2 && to == 1)
			return 0;
	}

	/**
	 * Create a tower of hanoi with 5 discs and solve it.
	 * 
	 * @param args ignored
	 */
	public static void main(String[] args) {
		TowersOfHanoi h = new TowersOfHanoi(5);
		h.solve();
		System.out.printf("\n\n----------------------\nNumber of Moves: %d", 
				h.moves);
	}
}
