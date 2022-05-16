import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int cnt = 0;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static ArrayList<Integer> group = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String str = sc.next();
            for(int j = 0; j < n; j++) {
                //문자에서 '0'을 빼주면 정수값 획득
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    dfs(j, i);
                    group.add(cnt);
                }
            }
        }

        System.out.println(group.size());
        group.sort(Comparator.naturalOrder());
        for (Integer i : group) {
            System.out.println(i);
        }
    }

    public static void dfs(int x, int y) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > -1 && nx < map.length && ny > -1 && ny < map.length) {
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    cnt++;
                    dfs(nx, ny);
                }
            }
        }
    }
}