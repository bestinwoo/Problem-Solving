import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int person : people) {
            list.add(person);
        }
        Collections.sort(list);

        if(list.size() > 1 && list.get(0) + list.get(1) > limit) {
            return list.size();
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>(50001);
        deque.addAll(list);

        while (!deque.isEmpty()) {
            int person = deque.pollLast();
            if(!deque.isEmpty() && person + deque.peekFirst() <= limit) {
                deque.pollFirst();
            }
            answer++;
        }

        return answer;
    }


}