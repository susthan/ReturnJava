package com.practice.algorithm.unionfind;

public class UF_QuickUnion {

	int[] nodes = null;

	public UF_QuickUnion(int size) {
		nodes = new int[size];
		for(int i = 0; i < size; i++)
			nodes[i] = i;
	}
	
	// Time complexity: Linear ? O(N)
	public void union(int node1, int node2) {
		int node1Parent = rootNodeOf(node1);
		int node2Parent = rootNodeOf(node2);
		nodes[node1Parent] = nodes[node2Parent];
		printNodes();
	}

	// Time complexity: O(N)
	public boolean isConnected(int node1, int node2)
	{
		return rootNodeOf(node1) == rootNodeOf(node2);
	}

	private int rootNodeOf(int node) {
		while(node != nodes[node])
			node = nodes[node];
		return node;
	}
	
	private void printNodes() {
		for (int i = 0; i < nodes.length; i++) {
			System.out.print("|"+nodes[i] + "|");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		UF_QuickUnion quickUnion = new UF_QuickUnion(10);
		
		quickUnion.union(4, 5);
		quickUnion.union(3, 5);
		quickUnion.union(2, 5);
		quickUnion.union(6, 7);
		quickUnion.union(9, 7);
		System.out.println("is connected: " +quickUnion.isConnected(9, 4));
		quickUnion.union(3, 6);
		
		System.out.println("is connected: " +quickUnion.isConnected(9, 4));
	}
}
