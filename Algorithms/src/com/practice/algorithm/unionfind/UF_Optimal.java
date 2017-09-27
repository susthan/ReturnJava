package com.practice.algorithm.unionfind;

import java.util.Arrays;

public class UF_Optimal {

	int[] nodes = null;
	int[] sz = null;
	
	public UF_Optimal(int size) {
		nodes = new int[size];
		sz = new int[size];
		Arrays.fill(sz, 1);
		for(int i = 0; i < size; i++)
			nodes[i] = i;
	}
	
	// Time complexity: Linear ? O(log N)
	public void union(int node1, int node2) {
		int node1Parent = rootNodeOf(node1);
		int node2Parent = rootNodeOf(node2);
		if(sz[node1Parent] < sz[node2Parent]) {
			nodes[node1Parent] = nodes[node2Parent];
			sz[node2Parent] += sz[node1Parent];
			sz[node1Parent] = 0;
		}
		else {
			nodes[node2Parent] = nodes[node1Parent];
			sz[node1Parent] += sz[node2Parent];
			sz[node2Parent] = 0;
		}
		
		printNodes();
	}

	// Time complexity: O(log N)
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
		UF_Optimal quickUnion = new UF_Optimal(10);
		
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
