import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 14500 테트로미노 (골드 4)
public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int answer = 0;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, map[i][j], 1);
				visited[i][j] = false;
			}
		}

		System.out.println(answer);
	}

	public static void dfs(int row, int col, int sum, int cnt) {
		if(cnt == 4) {
			answer = Math.max(answer, sum);
			return;
		}

		for(int i = 0; i < 4; i++) {
			int nx = col + dx[i];
			int ny = row + dy[i];

			if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
			if(!visited[ny][nx]) {
				if(cnt == 2) {
					visited[ny][nx] = true;
					dfs(row, col, sum + map[ny][nx], cnt + 1);
					visited[ny][nx] = false;
				}
				visited[ny][nx] = true;
				dfs(ny, nx, sum + map[ny][nx], cnt + 1);
				visited[ny][nx] = false;
			}
		}
	}


}

