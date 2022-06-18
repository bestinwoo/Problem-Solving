class Solution {
    public int solution(String name) {
        int answer = 0;
        int horizontalMove = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            //상하 이동 (알파벳 이동)
            int min = Math.min(name.charAt(i) - 'A', 'Z' - (name.charAt(i) - 1));
            answer += min;
            if(i < name.length() - 1 && name.charAt(i+1) == 'A') {
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A') {
                    endA++;
                }
                // 좌우 이동 (자리 이동) 우측으로 가다가 A를 마주치고 다시 돌아와서 오른쪽 끝으로 가는 경우와 처음부터 뒤로가는 경우
                horizontalMove = Math.min(horizontalMove, i * 2 + (name.length() - endA));
                horizontalMove = Math.min(horizontalMove, (name.length() - endA) * 2 + i);
            }
        }


        return answer + horizontalMove;
    }
}