import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1,-1,-2,-2,+1,+1,+2,+2};
    static int[] dy = {-2,+2,-1,+1,-2,+2,-1,+1};
    static int N,T;
    static int[][] visited;
    static int result = 0;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T= sc.nextInt();
        for(int i = 0; i < T; i++) {
            N = sc.nextInt();
            int[] start = new int[]{sc.nextInt(),sc.nextInt()};
            int[] object = new int[]{sc.nextInt(), sc.nextInt()};
            bfs(start, object);

        }
    }

    public static void bfs(int[] start, int[] object) {
        visited = new int[N][N];
        q.add(new int[]{start[0], start[1]});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if(poll[0] == object[0] && poll[1] == object[1]) {
                System.out.println(visited[object[0]][object[1]]);
                q.clear();
                return;
            }
            for(int i = 0; i < 8; i++) {
                int nx = poll[1] + dx[i];
                int ny = poll[0] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if(visited[ny][nx] == 0) {
                    q.add(new int[]{ny,nx});
                    visited[ny][nx] = visited[poll[0]][poll[1]] + 1;
                }
            }
        }
    }
}