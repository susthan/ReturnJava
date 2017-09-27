package com.practice.algorithm.problems;

import java.util.Scanner;

public class CoinChange {

	private static long coinChange(int n, int[] coins) {
		long[] results = new long[n+1];
		results[0] = (long)1;
		for(int coin : coins) {
			for(int i=coin; i < results.length; i++) {
				results[i] += results[i-coin];
			}
			
		}
		return results[n];
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] coins = new int[m];
		for(int i=0; i<m; i++){
			coins[i] = in.nextInt();
		}
		System.out.println(coinChange(n, coins));
	}
}
