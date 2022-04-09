import java.util.*;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : phone_book) {
            map.put(s, 0);
        }

        for (String s : phone_book) {
            for(int i =  0; i < s.length(); i++) {
                if(map.containsKey(s.substring(0, i))) {
                    return false;
                }
            }
        }
        return answer;
    }
}