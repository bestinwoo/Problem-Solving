import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for (int priority : priorities) {
            priorityQueue.add(priority);
        }
        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorityQueue.peek() == priorities[i]) {
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                    priorityQueue.poll();
                }
            }
        }
        return answer;
    }
}