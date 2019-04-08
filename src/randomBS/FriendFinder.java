package randomBS;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Queue;

public class FriendFinder {
	private boolean[] marked;
	private int[] edgeTo;
	private ArrayList<Integer> suggestions;

	public FriendFinder(Friends G, int s, int x) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s, x);
	}

	private void bfs(Friends G, int s, int x) {
		Queue<Integer> queue = new Queue<Integer>();
		Iterable<Integer> friendsI = G.friendsOf(s);
		ArrayList<Integer> friends = new ArrayList<Integer>();
		ArrayList<Integer> recommended = new ArrayList<Integer>();
		friends.add(s);
		for (int f : friendsI) {
			friends.add(f);
		}
		marked[s] = true;
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			for (int w : G.friendsOf(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
					if (!friends.contains(w)) {
						recommended.add(w);
						if (recommended.size() >= x) {
							this.suggestions = recommended;
							return;
						}
					}
				}
			}
		}
	}

	public ArrayList<Integer> suggestions() {
		return suggestions;
	}

	public static void main(String[] args) {
		//Dakota test area
		
		//Andrew test area

		//Erfan test area
		
		//Daniel test area
	}
}
