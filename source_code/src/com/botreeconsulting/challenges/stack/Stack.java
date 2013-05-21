package com.botreeconsulting.challenges.stack;

import java.util.Arrays;
import java.util.Iterator;

import com.botreeconsulting.challenges.util.Util;
import com.botreeconsulting.challenges.util.UtilConstants;

// A Stack implemented using Linked List data structure
public class Stack<Item> implements Iterable<Item> {
	
	private Node first; // top of stack (most recently added node)
	private int N; // number of items
	
	// Nested class to define nodes
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null; // or: N == 0
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		// Add item to the top of stack
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop() {
		// Remove item from top of stack
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
//		int stackSize = this.size();
//		Item[] stackContents = (Item[]) new Object[stackSize];
//		
//		Iterator<Item> stackIterator = this.iterator();
//		while(stackIterator.hasNext()) {
//			stackContents[--stackSize] = stackIterator.next();
//		}
		
		int arrIndex = 0;
		Item[] stackContents = (Item[]) new Object[this.size()];
		
		Iterator<Item> stackIterator = this.iterator();
		while(stackIterator.hasNext()) {
			stackContents[arrIndex++] = stackIterator.next();
		}
		
		StringBuilder sb = new StringBuilder();
		for (Item item : stackContents) {
			sb.append(item);
			sb.append(UtilConstants.SPACE);
		}
		
		return sb.toString();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[] args) {
		// Create a stack and push/pop strings as directed on StdIn
		Stack<String> s = new Stack<String>();
		
		String[] input = { 
				"it", "was", "-", "the", "best", "-", "of", "times", 
				"-", "-", "-",
				"it", "was",
				"-",
				"the",
				"-", "-" 
		};
		
		System.out.println("Output for:\n " + Arrays.toString(input) + " :");
		
		for (String item : input) {
			if (!UtilConstants.HYPHEN.equals(item)) {
				s.push(item);
			} else if (!s.isEmpty()) {
				System.out.print(s.pop() + UtilConstants.SPACE);
			}
		}
		
		Util.printStackSize(s.size());
	}
}
