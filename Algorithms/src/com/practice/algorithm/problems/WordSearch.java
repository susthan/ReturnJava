package com.practice.algorithm.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Tries: Contacts
 * 
 * @status all TC passed
 * @optimal-solution
 * 
 */
public class WordSearch {

	static class Trie {
		Map<Character, Trie> database = new HashMap<Character, Trie>();
		
		private int count = 0;
		
		public int countInstance(String pattern) {
			return countInstance(pattern, this);
		}
		
		private int countInstance(String pattern, Trie trie) {
			if(pattern.length() == 0)
				return trie.count;
			Character key = pattern.charAt(0);
			if(trie.database.get(key) == null)
				return 0;
			//System.out.println("Node: "+key +" count" +trie.database.get(key).count);
			
			return countInstance(pattern.substring(1), trie.database.get(key));
		}
		

		public void addName(String name) {
			addName(name, this);
		}
		
		private void addName(String name, Trie trie) {
			Character key = name.charAt(0);
			
			if(trie.database.get(key) == null)
				trie.database.put(key, new Trie());
			
			trie.database.get(key).count++;
			
			//System.out.println("Node: "+key +" count" +trie.database.get(key).count);
			if(name.length() == 1)
				return;
			
			addName(name.substring(1), trie.database.get(key));
		}
		
	}

	
	public static void main(String[] args) {
		System.out.println("Enter the number of operations to be performed:");
		int n = new Scanner(System.in).nextInt();
		String op = null;
		String contact = null;
		Trie trie = new Trie();
		System.out.println("Enter operation value");
		for(int a0 = 0; a0 < n; a0++){
			op = new Scanner(System.in).next();
			contact = new Scanner(System.in).next();
			if(op.equals("add")) {
				trie.addName(contact);
			} else if(op.equals("find")) {
				System.out.println(trie.countInstance(contact));
			}
		}
	}
}
