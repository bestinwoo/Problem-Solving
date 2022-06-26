import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    static Queue<int[]> queue = new LinkedList<int[]>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        int[][] maze = new int[n][m];

        for(int i = 0; i < n; i++) {

            String line = sc.nextLine();
            for(int j = 0; j < line.length(); j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(maze, 0, 0);
        System.out.println(maze[n-1][m-1]);
    }

    public static void bfs(int[][] graph, int x, int y) {
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];
                if(nextX >= m || nextX < 0 || nextY >= n || nextY < 0) continue;
                int next = graph[nextY][nextX];
                if(next == 1) {
                    queue.add(new int[]{nextX, nextY});
                    graph[nextY][nextX] = graph[poll[1]][poll[0]] + 1;
                }
            }
        }
    }
}