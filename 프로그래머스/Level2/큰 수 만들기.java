class Solution {
    public String solution(String number, int k) {
        int length = number.length() - k;
        String answer = "";
        int max = 0;
        int idx = 0;

        for(int i = idx; i < number.length(); i++) {
            int max1 = Integer.parseInt(number.substring(i, i + 1));
            if(max < max1) {
                max = max1;
                idx = i;
            }
            if(max == 9 || (number.length() - i <= length - answer.length())) {
                answer += max;
                i = idx;
                max = 0;
            }
        }

        return answer;
    }
}