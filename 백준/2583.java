import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int n, m, k;
	static int cnt = 0;
	static int[][] map;
	static ArrayList<Integer> results = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		map = new int[m][n];

		for(int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int y = y1; y < y2; y++) {
				for(int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					dfs(map, j, i);
					results.add(cnt);
					cnt = 0;
				}
			}
		}
		System.out.println(results.size());
		results.sort(Comparator.naturalOrder());
		for (Integer result : results) {
			System.out.print(result + " ");
		}
	}

	public static void dfs(int[][] map, int x, int y) {
		map[y][x] = 1;
		cnt++;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= n || ny < 0 | ny >= m) continue;
			if(map[ny][nx] == 0) {
				map[ny][nx] = 1;
				dfs(map, nx, ny);
			}
		}
	}
}
