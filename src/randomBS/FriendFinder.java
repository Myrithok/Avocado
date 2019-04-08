package randomBS;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Queue;

public class FriendFinder {
	private boolean[] marked;
	private int[] edgeTo;
	private ArrayList<Integer> suggestions;
	private ArrayList<Integer> friends;

	public FriendFinder(Friends G, int s, int x) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s, x);
	}

	private void bfs(Friends G, int c, int x) {
		int s = G.indexOfCode(c);
		Queue<Integer> queue = new Queue<Integer>();
		Iterable<Integer> friendsI = G.friendsOf(s);
		ArrayList<Integer> friends = new ArrayList<Integer>();
		ArrayList<Integer> friendsC = new ArrayList<Integer>();
		ArrayList<Integer> recommended = new ArrayList<Integer>();
		friends.add(s);
		for (int f : friendsI) {
			friends.add(f);
			friendsC.add(G.codeAtIndex(f));
		}
		this.friends = friendsC;
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
						recommended.add(G.codeAtIndex(w));
						if (recommended.size() >= x) {
							this.suggestions = recommended;
							return;
						}
					}
				}
			}
		}
		this.suggestions = recommended;
	}

	public ArrayList<Integer> suggestions() {
		return suggestions;
	}
	
	public ArrayList<Integer> friends() {
		return friends;
	}

	public static void main(String[] args) {
		//Dakota test area
		
		//Andrew test area
		Friends test = new Friends();
		test.addNode(5);
		test.addNode(60);
		test.addNode(42);
		test.addNode(10);
		test.addNode(832);
		test.addEdge(5, 60);
		test.addEdge(5, 42);
		test.addEdge(60, 10);
		test.addEdge(60, 832);
		System.out.println(test.V());
		FriendFinder test2 = new FriendFinder(test, 5, 2);
		System.out.println(test2.friends().toString());
		System.out.println(test2.suggestions().toString());
		//Erfan test area
		
		//Daniel test area
	}
}
