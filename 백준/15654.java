class Solution {
    int cx = 0;
    int cy = 0;
    int cnt = 1;
    public int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        answer[0][0] = 1;

        while(!check(answer)) {
            clean(answer, horizontal);
            horizontal = !horizontal;
        }

        return answer;
    }

    public boolean check(int[][] answer) {
        for (int[] i : answer) {
            for (int j : i) {
                if(j == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clean(int[][] answer, boolean horizontal) {
        if(horizontal) {
            cx++;
            int x = cx;
            int y = cy;
            int i = Math.max(x,y);
            for(; cy <= i; cy++) {
                if(cx < i) {
                    for (; cx <= i; cx++) {
                        answer[cy][cx] = ++cnt;
                    }
                } else {
                    for(; cx > 0; cx--) {
                        answer[cy][cx] = ++cnt;
                    }
                }
                answer[cy][cx] = ++cnt;
            }
        } else {
            cy++;
            int x = cx;
            int y = cy;
            for(; cy < Math.max(x, y); cy++) {
                for(;cx < Math.max(x,y); cx++) {
                    answer[cy][cx] = ++cnt;
                }
            }
        }
    }
}

// class Solution {
//     int answer = 0;
//     public int solution(int[] grade) {
//         for(int i = 0; i < grade.length; i++) {
//
//             if(i+1 < grade.length ) {
//                while(findMax(i+1, grade) != -1) {
//
//                }
//
//             }
//         }
//
//         return answer;
//     }
//
//     public int findMax(int num, int[] grade) {
//         int result = -1;
//         for(int i = num; i >= 0; i--) {
//             if(grade[num] < grade[i]) {
//                 answer += (grade[i] - grade[num]);
//                 result = (grade[i] - grade[num]);
//                 grade[i] = grade[num];
//             }
//         }
//         return result;
//     }
// }
