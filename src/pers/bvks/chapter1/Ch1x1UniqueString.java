package pers.bvks.chapter1;

import java.util.Arrays;

public class Ch1x1UniqueString {

	public static void main(String[] args) {
		System.out.println(isUniqueCheckUsingArrays("aabcde"));
		System.out.println(isUniqueCheckUsingArrays("abcde"));

		System.out.println(isUniqueCheckWithoutDS("aabcde"));
		System.out.println(isUniqueCheckWithoutDS("abcde"));
		
		System.out.println(isUniqueCheckUsingSort("aabcde"));
		System.out.println(isUniqueCheckUsingSort("abcde"));

	}

	// Approach 1
	public static boolean isUniqueCheckUsingArrays(String input) {
		boolean[] booleanArray = new boolean[128];

		for (char ch : input.toCharArray()) {
			if (!booleanArray[ch]) {
				booleanArray[ch] = true;
			} else {
				return false;
			}
		}
		return true;
	}

	// Approach 1 - Enhanced
	// Get it clarified with the interviewer about the Character set Type ASCII,
	// Unicode etc
	// Add the Edge Cases
	// Add the NPE
	// Try to make the number of blocks to be minimal
	// Give meaningful names
	// Make the length of method to be < 25 lines - vertical formatting
	// Make sure to give the horizontal spacing, indentation as well

	public static boolean isUniqueCheckUsingArraysEnhanced(String input) {
		if (input != null && input.length() > 128)
			return false;

		boolean[] char_set = new boolean[128];
		for (char ch : input.toCharArray()) {
			if (char_set[ch])
				return false;

			char_set[ch] = true;
		}
		return true;
	}

	// Approach 2
	// Brute Force Approach
	public static boolean isUniqueCheckWithoutDS(String input) {
		if (input != null && input.length() > 128)
			return false;

		char[] inputCharArray = input.toCharArray();
		int arrLength = input.length();

		for (int i = 0; i < arrLength - 1; i++) {
			for (int j = i + 1; j < arrLength; j++) {
				if (inputCharArray[i] == inputCharArray[j])
					return false;
			}
		}
		return true;
	}

	// Approach 3
	public static boolean isUniqueCheckUsingSort(String input) {
		if (input != null && input.length() > 128)
			return false;

		char[] inputCharArray = input.toCharArray();
		int arrLength = input.length();

		Arrays.sort(inputCharArray);
		for (int i = 0; i < arrLength - 1; i++) {
			if (inputCharArray[i] == inputCharArray[i + 1])
				return false;
		}
		return true;
	}

}
