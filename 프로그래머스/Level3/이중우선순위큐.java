import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            String trim = operation.replaceAll(" ", "");
            char oper = trim.charAt(0);
            if(oper == 'I') {
                int num = Integer.parseInt(trim.substring(1));
                minQ.add(num);
                maxQ.add(num);
            } else if(oper == 'D') {
                if(minQ.isEmpty()) {
                    continue;
                }
                if(trim.equals("D1")) {
                    Integer poll = maxQ.poll();
                    minQ.remove(poll);
                } else if(trim.equals("D-1")) {
                    Integer poll = minQ.poll();
                    maxQ.remove(poll);
                }
            }
        }
        int[] answer = {0,0};
        if(!minQ.isEmpty() && !maxQ.isEmpty()) {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }
        return answer;
    }
}