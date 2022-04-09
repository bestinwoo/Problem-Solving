import java.util.*;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            if(!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        for (String s : completion) {
            if(map.get(s) - 1 == 0) {
                map.remove(s);
            } else {
                map.put(s, map.get(s) - 1);
            }
        }
        System.out.println("map = " + map);
        answer = (String) map.keySet().toArray()[0];
        return answer;
    }
}