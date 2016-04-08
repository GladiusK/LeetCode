package com.yx.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *  Longest Substring Without Repeating Characters
 *  Given a string, find the length of the longest substring without repeating characters.
 *  For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 *  For "bbbbb" the longest substring is "b", with the length of 1.
 **/
public class Solution3 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring2("abcababcd"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public static int lengthOfLongestSubstring2(String s) {
		int i = 0, j = 0, max = 0;
		Set set = new HashSet();
		while (i < s.toCharArray().length) {
			if (!set.contains(s.charAt(i))) {
				set.add(s.charAt(i++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(j++));
			}
		}
		return max;
	}

	public static int lengthOfLongestSubstringDP(String s) {
		// THE BEST
		int max = 0;
		int[] lastIndexMap = new int[128];
		int[] cache = new int[s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int repeatedLen = i - lastIndexMap[c];
			int prevLen = cache[i];
			int len = (repeatedLen > prevLen ? prevLen : repeatedLen) + 1;
			if (len > max)
				max = len;
			cache[i + 1] = len;
			lastIndexMap[c] = i + 1;
		}
		return max;
	}
}
