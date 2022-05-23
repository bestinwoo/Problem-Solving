import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows+1][columns+1];
        for(int i = 1; i < map.length; i++) {
            for(int j = 1; j < map[i].length; j++) {
                map[i][j] = (i-1) * columns + j;

            }
        }
        ArrayList<Integer> answer = new ArrayList<>();

        for (int[] query : queries) {
            int y = query[0], y1 = query[2], x = query[1], x1 = query[3];
            int min = map[y][x];
            int temp = map[y][x];
            for(int i = y; i < y1; i++) {
                min = Math.min(min, map[i][x]);
                map[i][x] = map[i+1][x];
            }

            for(int i = x; i < x1; i++) {
                min = Math.min(min, map[y1][i]);
                map[y1][i] = map[y1][i+1];
            }

            for(int i = y1; i > y; i--) {
                min = Math.min(min, map[i][x1]);
                map[i][x1] = map[i-1][x1];
            }

            for(int i = x1; i > x; i--) {
                min = Math.min(min, map[y][i]);
                map[y][i] = map[y][i-1];
            }
            map[y][x+1] = temp;
            answer.add(min);
        }


        return answer;
    }
}