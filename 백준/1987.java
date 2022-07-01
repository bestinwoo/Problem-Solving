import java.util.Scanner;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N, M;
    static boolean[] visited;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[26];

        for(int i = 0; i < N; i++) {
            String row = sc.next();
            for(int j = 0; j < row.length(); j++) {
                map[i][j] = row.charAt(j) - 'A';
            }
        }
        visited[map[0][0]] = true;
        dfs(0,0, 1);
        System.out.println(result);
    }

    public static void dfs(int y, int x, int count) {
        result = Math.max(result, count);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

            if(!visited[map[ny][nx]]) {
                visited[map[ny][nx]] = true;
                dfs(ny,nx, count + 1);
                visited[map[ny][nx]] = false;
            }
        }
    }
}