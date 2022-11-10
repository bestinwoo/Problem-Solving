import java.util.HashMap;
import java.util.Map;

//LeetCode Longest Palindrome
class Solution {
	public int longestPalindrome(String s) {
		int[] count = new int[128];
		int answer = 0;
		for (char c : s.toCharArray()) {
			count[c]++;
		}

		for (int i : count) {
			answer += (i / 2) * 2;
		}

		return answer < s.length() ? answer + 1: answer;
	}
}
