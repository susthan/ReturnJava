package com.practice.algorithm.unionfind;

public class UF_QuickFind {
	
	int[] nodes = null;
	
	public UF_QuickFind(int sizeOfNodes) {
		nodes = new int[sizeOfNodes];
		for(int i = 0; i < sizeOfNodes; i++)
			nodes[i] = i;
	}
	
	// Time complexity: Quadratic ? O(n^2)
	public void union(int node1, int node2) {
		//-------------------  Validation
		if(node1 == node2)
			return;
		if(node1 >= nodes.length || node2 >= nodes.length) {
			System.out.println("Error - Out of Bound");
			return;
		}
		//-------------------  Core	
		int prev = nodes[node1];
		for (int i = 0; i < nodes.length; i++) {
			if(nodes[i] == prev)
				nodes[i] = nodes[node2];
		}
		//-------------------  Debug
		printNodes();
	}
	
	// Time complexity: O(1)
	public boolean isConnected(int node1, int node2)
	{
		return nodes[node1] == nodes[node2];
	}
	
	private void printNodes() {
		for (int i = 0; i < nodes.length; i++) {
			System.out.print("|"+nodes[i] + "|");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		UF_QuickFind uf = new UF_QuickFind(10);
		uf.union(2, 6);
		uf.union(1, 5);
		uf.union(3, 7);
		System.out.println("is connected: "+ uf.isConnected(2, 5));
		uf.union(3, 5);
		uf.union(7, 2);
	}
}
