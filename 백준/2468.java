import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N;
    static boolean[][] visited;
    static int result = 0;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(max, map[i][j]);
            }
        }

        for(int i = max; i > 0; i--) {
            visited = new boolean[N][N];
            int cnt = 0;
            for(int j = 0; j < map.length; j++) {
                for(int k = 0; k < map[j].length; k++) {
                    if(map[j][k] < i) {
                        visited[j][k] = true;
                    } else if(!visited[j][k]) {
                        bfs(j, k, i);
                        cnt++;
                        visited[j][k] = true;
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }

    public static void bfs(int y, int x, int k) {
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = poll[1] + dx[i];
                int ny = poll[0] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(!visited[ny][nx] && map[ny][nx] >= k) {
                    q.add(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}