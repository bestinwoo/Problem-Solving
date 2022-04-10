import java.util.*;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int result = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if(result + d[i] <= budget) {
                result += d[i];
                answer++;
            } else {
                return answer;
            }
        }
        return answer;
    }
}