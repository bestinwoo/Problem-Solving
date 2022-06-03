import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        final int[][] ans = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        ArrayList<Integer> answer = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0, k = 0; j < answers.length; j++, k++) {
                if(ans[i].length <= k) {
                    k = 0;
                }

                if(answers[j] == ans[i][k]) {
                    cnt++;
                }
            }
            if(max < cnt) {
                max = cnt;
                answer.clear();
                answer.add(i+1);
            } else if(max == cnt) {
                answer.add(i+1);
            }
        }
        if(answer.isEmpty()) {
            answer.add(1);
            answer.add(2);
            answer.add(3);
        }
        return answer;
    }
}