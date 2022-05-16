import java.util.*;

public class Main {
    static int w,h;
    static int cnt = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1,1,-1,1,-1};
    static int[] dy = {1,-1,0,0,1,1,-1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 || h == 0) {
                break;
            }
            map = new int[h][w];
            visited = new boolean[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(j, i);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }

    public static void dfs(int x, int y) {
        visited[y][x] = true;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx > -1 && nx < w && ny > -1 && ny < h) {
                if(map[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(nx,ny);
                }
            }
        }
    }
}