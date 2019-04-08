package randomBS;

import edu.princeton.cs.algs4.Bag;

//This uses a bag implementation. It would be easy to implement myself, but we could also use the princeton bag library if we're importing that library anyway.
public class Friends {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	public Friends(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	public Iterable<Integer> friendsOf(int v) {
		return adj[v];
	}

	public static void main(String[] args) {
		// Dakota test area

		// Andrew test area

		// Erfan test area

		// Daniel test area
	}
}
