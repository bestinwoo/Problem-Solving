import java.util.Locale;

//LeetCode Valid Palindrome
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]*", "");
        if(s.isEmpty()) {
            return true;
        }

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
