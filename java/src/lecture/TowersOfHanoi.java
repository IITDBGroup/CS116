/**
 * 
 */
package lecture;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


/**
 * @author lord_pretzel
 *
 */
public class TowersOfHanoi {


	private List<Stack<Integer>> stacks;
	private int numDiscs;
	int moves = 0;
	
	public TowersOfHanoi (int n) {
		this.numDiscs = n;
		stacks = List.of(new Stack<Integer>(), new Stack<Integer>(), new Stack<Integer>());
		Stack<Integer> left = stacks.get(0);
		for(int i = n; i > 0; i--)
			left.push(i);
	}

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

	public void solve() {
		System.out.println("initial configuration:\n\n" + toString());
		move(0, 2, numDiscs);
	}

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

	public void moveSingleDisc(int from, int to) {
		moves++;
		int disc = stacks.get(from).pop();
		stacks.get(to).push(disc);        
		System.out.printf("move disc %d from %d to %d:\n\n%s\n", disc, from, to, toString());
	}

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

	public static void main(String[] args) {
		TowersOfHanoi h = new TowersOfHanoi(5);
		h.solve();
		System.out.printf("\n\n----------------------\nNumber of Moves: %d", 
				h.moves);
	}
}
