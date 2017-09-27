package com.practice.algorithm.problems;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * Find the Running Median
 * 
 * @status OK
 * 
 */
public class FindMedian {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (x, y) -> y-x );
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	
	public double median() {
		if(maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		return maxHeap.peek();
	}
	
	public void add(int a) {
		if (minHeap.size() < maxHeap.size())
			minHeap.add(a);
		else	
			maxHeap.add(a);
		
		balance();
		//System.out.println("minHeap " + minHeap);
		//System.out.println("maxHepa " + maxHeap);
	}
	
    private void balance() {
		while( !minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
			int minHead = minHeap.poll();
			int maxHead = maxHeap.poll();
			minHeap.add(maxHead);
			maxHeap.add(minHead);
		}
		
	}

	public static void main(String[] args) {
    	
    	FindMedian heap = new FindMedian();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a_i=0; a_i < n; a_i++){
            int a = in.nextInt();
            heap.add(a);
            System.out.println(heap.median());
        }
    }
}
