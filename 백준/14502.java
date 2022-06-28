import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    static int[][] map;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        putWall(0, 0, 0);
        System.out.println(result);
    }

    public static void putWall(int count, int sy, int sx) {
        if(count == 3) {
            //벽 3개를 모두 설치한 경우 종료
            bfs();
            return;
        }
        //dfs로 벽을 세울 수 있는 모든 경우의 수 탐색
        for(int y = sy; y < n; y++) {
            for(int x = sx; x < m; x++) {
                if(map[y][x] == 0) {
                    map[y][x] = 1;
                    putWall(count+1, y, x);
                    map[y][x] = 0;
                }
            }
            sx = 0;
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] vMap = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < map[i].length; j++) {
                vMap[i][j] = map[i][j];
                if(vMap[i][j] == 2) {
                    queue.add(new int[]{j,i});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];
                vMap[poll[1]][poll[0]] = 2;
                if(nextX >= m || nextX < 0 || nextY >= n || nextY < 0) continue;
                int next = vMap[nextY][nextX];
                if(!visited[nextY][nextX] && next == 0) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextY][nextX] = true;
                }
            }
        }
        int cnt = 0;
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(vMap[y][x] == 0) {
                    cnt++;
                }
            }
        }
        result = Math.max(result, cnt);
    }
}