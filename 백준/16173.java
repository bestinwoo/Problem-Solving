import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] dx = new int[]{0,1};
    static int[] dy = new int[]{1,0};
    static int[][] map;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(map[poll[1]][poll[0]] == -1) {
                System.out.println("HaruHaru");
                return;
            }
            for(int i = 0; i < 2; i++) {
                int jx = poll[0] + dx[i] * map[poll[1]][poll[0]];
                int jy = poll[1] + dy[i] * map[poll[1]][poll[0]];
                if(jx < n && !visited[poll[1]][jx]) {
                    queue.add(new int[]{jx,poll[1]});
                    visited[poll[1]][jx] = true;
                }
                if(jy < n && !visited[jy][poll[0]]) {
                    queue.add(new int[]{poll[0], jy});
                    visited[jy][poll[0]] = true;
                }
            }
        }
        System.out.println("Hing");
    }
}