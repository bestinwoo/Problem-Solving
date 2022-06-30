import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][][] map;
    static int[] dz = {0,0,0,0,-1,1};
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {-1,1,0,0,0,0};
    static int N,M,H;
    static boolean[][][] visited;
    static int cnt = 0;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); N = sc.nextInt(); H = sc.nextInt();
        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    map[i][j][k] = sc.nextInt();
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!visited[i][j][k] && map[i][j][k] == 1) {
                        q.add(new int[]{k, j, i});
                        visited[i][j][k] = true;
                        //bfs(k, j, i);
                    }
                }
            }
        }

        bfs();

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    cnt = Math.max(cnt, map[i][j][k] - 1);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            for(int i = 0; i < 6; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                int nz = poll[2] + dz[i];
                if(nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                if(!visited[nz][ny][nx] && map[nz][ny][nx] == 0) {
                    map[nz][ny][nx] = map[poll[2]][poll[1]][poll[0]] + 1;
                    q.add(new int[]{nx,ny,nz});
                    visited[nz][ny][nx] = true;
                }
            }
        }
    }
}