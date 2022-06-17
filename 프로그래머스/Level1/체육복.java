import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> rent = new HashSet<Integer>();
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i : lost) {
            for (int i1 : reserve) {
                if(!rent.contains(i) && i == i1) {
                    rent.add(i);
                    answer++;
                }
            }
        }
        for(int i =0; i < lost.length; i++) {
            if(rent.contains(lost[i])) continue;
            for(int j = 0; j < reserve.length; j++) {
                if(!rent.contains(reserve[j]) && (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1)) {
                    rent.add(reserve[j]);
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}