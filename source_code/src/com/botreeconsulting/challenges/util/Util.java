package com.botreeconsulting.challenges.util;

public class Util {

	/**
	 * 
	 * @param size the current size of stack
	 */
	public static final void printStackSize(int size) {
		System.out.println(
				UtilConstants.LEFT_PARENTHESES + 
				size + 
				" left on stack" + UtilConstants.RIGHT_PARENTHESES);
	}
	
}
