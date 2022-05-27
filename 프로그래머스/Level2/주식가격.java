import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int price : prices) {
            queue.add(price);
        }
        int index = 0;
        while(!queue.isEmpty()) {
            int sec = -1;
            for(int i = index; i < prices.length; i++) {
                sec++;
                if(prices[i] < queue.peek()) {
                    answer.add(sec);
                    break;
                }
                if(i == prices.length - 1) {
                    answer.add(sec);
                }
            }
            queue.poll();
            index++;
        }

        return answer;
    }
}