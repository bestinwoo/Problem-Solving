import java.io.*;
import java.util.*;
//BOJ 1926 그림
public class Main {
	static int m,n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1, 1, 0, 0};
	static int cnt = 0;
	static int max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
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
				if(!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					bfs(i,j);
				}
			}
		}

		System.out.println(cnt);
		System.out.println(max);

	}

	public static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{y,x});
		cnt++;
		int tempCnt = 0;
		while(!q.isEmpty()) {
			tempCnt++;
			int[] poll = q.poll();
			for(int i  = 0; i < 4; i++) {
				int ny = poll[0] + dy[i];
				int nx = poll[1] + dx[i];
				if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

				if(!visited[ny][nx] && map[ny][nx] == 1) {
					visited[ny][nx] = true;
					q.add(new int[] {ny, nx});
				}
			}
		}

		max = Math.max(max, tempCnt);
	}

}

