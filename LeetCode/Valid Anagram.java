//LeetCode Invert Binary Tree
// Definition for a binary tree node.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//LeetCode Valid Anagram
class Solution {
	public boolean isAnagram(String s, String t) {
		return sortString(s).equals(sortString(t));
	}

	public String sortString(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}

