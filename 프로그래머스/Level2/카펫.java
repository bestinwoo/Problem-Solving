import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int brown, int yellow) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        int sum = brown + yellow;
        map.put(12, 1);
        for(int i = 1; i < sum; i++) {
            if(sum % i == 0) {
                if(i >= sum / i && i > 2) {
                    map.put(i, sum / i);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int yellowCnt = (entry.getKey() - 2) * (entry.getValue() - 2);
            if(yellowCnt == yellow) {
                answer[0] = entry.getKey();
                answer[1] = entry.getValue();
            }
        }

        return answer;
    }
}