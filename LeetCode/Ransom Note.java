import java.util.HashMap;
import java.util.Map;

//LeetCode Ransom Note
class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		if(ransomNote.length() > magazine.length()) return false;
		Map<Character, Integer> letters = new HashMap<>();
		for (char c : magazine.toCharArray()) {
			letters.put(c, letters.getOrDefault(c, 0) + 1);
		}

		for (char c : ransomNote.toCharArray()) {
			Integer val = letters.getOrDefault(c, 0);
			if(val < 1) {
				return false;
			}
			letters.put(c, val - 1);
		}
		return true;
	}
}
