import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N;
    static boolean[][] visited;
    static int[] cnt = {0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < 2; i++) {
            for(int y = 0; y < N; y++) {
                for(int x = 0; x < N; x++) {
                    if(!visited[y][x]) {
                        bfs(y, x);
                        cnt[i]++;
                    }
                }
            }

            for(int y = 0; y < N; y++) {
                for(int x = 0; x < N; x++) {
                    visited[y][x] = false;
                    if(map[y][x] == 'R') {
                        map[y][x] = 'G';
                    }
                }
            }
        }

        System.out.println(cnt[0] + " " + cnt[1]);
    }

    public static void bfs(int y, int x) {
        char color = map[y][x];
        Queue<int[]> node = new LinkedList<>();
        node.add(new int[]{y, x});
        visited[y][x] = true;
        while(!node.isEmpty()) {
            int[] poll = node.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[1] + dx[i];
                int ny = poll[0] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(!visited[ny][nx] && map[ny][nx] == color) {
                    visited[ny][nx] = true;
                    node.add(new int[]{ny, nx});
                }
            }
        }
    }

}