package randomBS;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Bag;

public class Friends {
	private int V;
	private int E;
	private ArrayList<Bag<Integer>> adj;
	private ArrayList<Integer> codes;

	public Friends() {
		this.V = 0;
		this.E = 0;
		this.adj = new ArrayList<Bag<Integer>>();
		this.codes = new ArrayList<Integer>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public int indexOfCode(int c) {
		return(codes.indexOf(c));	
	}
	
	public int codeAtIndex(int i) {
		return(codes.get(i));
	}
	
	public void addNode(int c) {
		Bag<Integer> temp = new Bag<Integer>();
		adj.add(temp);
		codes.add(c);
		V++;
	}

	public void addEdge(int v, int w) {
		adj.get(codes.indexOf(v)).add(codes.indexOf(w));
		E++;
	}

	public Iterable<Integer> friendsOf(int v) {
		return adj.get(v);
	}

	public static void main(String[] args) {
		// Dakota test area

		// Andrew test area

		// Erfan test area

		// Daniel test area
	}
}
