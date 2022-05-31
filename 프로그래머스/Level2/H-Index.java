import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h = 1;
        while(true) {
            int cnt = 0;
            for (int citation : citations) {
                if(citation >= h) {
                    cnt++;
                }
            }
            if(cnt < h) {
                h--;
                break;
            } else {
                h++;
            }
        }
        return h;
    }
}