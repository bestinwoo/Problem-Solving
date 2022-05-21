import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;
        for (int lotto : lottos) {
            if(lotto == 0) {
                zeroCnt++;
                continue;
            }
            OptionalInt any = Arrays.stream(win_nums).filter(i -> i == lotto).findAny();
            if(any.isPresent()) {
                cnt++;
            }
        }

        answer[0] = getRank(cnt + zeroCnt);
        answer[1] = getRank(cnt);
        return answer;
    }

    private int getRank(int cnt) {
        int rank = 6;
        switch (cnt) {
            case 6 : rank = 1;
            break;
            case 5: rank =  2;
            break;
            case 4: rank =  3;
            break;
            case 3: rank =  4;
            break;
            case 2: rank =  5;
            break;
            default: rank =  6;
        }
        return rank;
    }
}