package com.practice.algorithm.problems;

import java.util.Scanner;

public class ArrayRotation {
	
	    public static int[] arrayLeftRotation(int[] a, int n, int k) {
	      int[] temp = new int[n];
	      for(int i=0; i<n; i++) {
	    	  System.out.println(i+" "+(n-k+i)%n);
	          temp[(n-k+i)%n] = a[i];
	      }
	        return temp;
	    }
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int a[] = new int[n];
	        
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	      
	        int[] output = new int[n];
	        output = arrayLeftRotation(a, n, k);
	        for(int i = 0; i < n; i++)
	            System.out.print(output[i] + " ");
	      
	        System.out.println();
	      
	    }
	}