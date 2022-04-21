import java.util.*;

class Solution {
    public int solution(int n) {
        int ans = 0;
        int pos = n;
        //n이 짝수일 경우 2로 나누고 홀수 일 경우 건전지+1 해주고 짝수로 맞춰줌
        while(pos > 0) {
            if(pos % 2 == 0) {
                pos /= 2;
            } else {
                pos--;
                ans++;
            }
        }
        return ans;
    }
}