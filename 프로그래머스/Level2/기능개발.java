import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList();
        int day = 1;

        for(int i = 0; i < progresses.length; i++) {
            int term = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.add(term);
        }

        while(!queue.isEmpty()) {
            int cnt = 0;
            while(!queue.isEmpty() && queue.element() <= day) {
                queue.poll();
                cnt++;
            }
            day++;
            if(cnt > 0) {
                answer.add(cnt);
            }
        }
        return answer;
    }
}