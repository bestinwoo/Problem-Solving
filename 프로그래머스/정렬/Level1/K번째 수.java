import java.util.*;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int k = 0;
        for (int[] command : commands) {
            ArrayList<Integer> result = new ArrayList<>();
            for(int i = command[0] - 1; i < command[1]; i++) {
                result.add(array[i]);
            }
            result.sort(Comparator.naturalOrder());
            answer[k++] = result.get(command[2]-1);
        }
        return answer;
    }
}