import java.util.*;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            System.out.println("answer = " + clothes[i][1]);
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }

        for (String s : map.keySet()) {
            answer *= map.get(s);
            System.out.println("answer = " + map.get(s));
        }


        answer = answer - 1;

        return answer;
    }
}