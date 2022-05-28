import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int answer = 0;
        for (int i : scoville) {
            priorityQueue.add(i);
        }
        
        while(priorityQueue.size() > 1 && priorityQueue.peek() < K) {
            Integer poll = priorityQueue.poll();
            Integer poll1 = priorityQueue.poll();

            priorityQueue.add(poll + (poll1 * 2));

            answer++;
        }

        if(priorityQueue.size() < 2 && priorityQueue.peek() < K) {
            return -1;
        }

        return answer;
    }
}