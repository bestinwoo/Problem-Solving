import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> rail = new LinkedList<>();
        int currentWeight = 0;
        int answer = 0;
        for (int truck_weight : truck_weights) {
            queue.add(truck_weight);
        }

        while(true) {
            answer++;
            //다리가 꽉 찼으면 가장 앞의 원소를 빼줌
            if(!rail.isEmpty() && rail.size() == bridge_length) {
                Integer poll = rail.poll();
                currentWeight -= poll;
            }
            //대기중인 트럭과 도로에 있는 트럭이 없으면 중단
            if(queue.isEmpty() && currentWeight == 0) break;
            //대기중인 트럭이 있고 트럭의 무게가 다리가 견딜수 있는 무게 이내일 경우 트럭을 다리에 추가
            if(!queue.isEmpty() && queue.peek() + currentWeight <= weight) {
                Integer poll = queue.poll();
                rail.add(poll);
                currentWeight += poll;
            } else  { // 트럭의 무게가 다리가 견딜 수 있는 무게 이상일 경우 다리에 0을 추가함
                rail.add(0);
            }
        }

        return answer;
    }
}