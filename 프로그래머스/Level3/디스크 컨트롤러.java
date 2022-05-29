import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        //jobs를 요청시간을 기준으로 오름차순 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        //우선순위 큐는 작업의 소요시간을 기준으로 오름차순 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int currentTime = 0; // 현재 시간
        int totalTime = 0; // 작업 시간의 합산
        int taskCnt = 0; // 큐에 들어간 작업의 개수

        while(taskCnt < jobs.length || !queue.isEmpty()) {
            //요청시간이 현재 시간보다 전일 때 작업 큐에 넣어줌
           while(taskCnt < jobs.length && jobs[taskCnt][0] <= currentTime) {
                queue.add(jobs[taskCnt++]);
            }
            // 작업 큐가 비어있지 않다면
            if(!queue.isEmpty()) {
                //가장 소요시간이 짧은 작업 poll
                int[] poll = queue.poll();
                currentTime += poll[1]; // 현재시간에 소요시간을 더해줌
                totalTime += currentTime - poll[0]; // 합산 시간은 현재 시간에서 작업의 요청시간을 뺀 시간
            } else {
                currentTime = jobs[taskCnt][0]; //작업이 없는 경우 다음 작업시간으로 현재시간 변경
            }
        }

        return totalTime / jobs.length;
    }
}