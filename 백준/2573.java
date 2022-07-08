import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int n,m;
	static int[][] map;
	static int[][] postMap;
	static boolean[][] visited;
	static int count = 0, year = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		map = new int[n][m];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(count < 2) {
			visited = new boolean[n][m];
			postMap = new int[n][m];
			count = 0;
			year++;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						bfs(j, i);
						count++;
						ice();
					}
				}
			}
			if(count == 0) {
				year = 0;
				break;
			}
		}
		System.out.println(year);
	}

	public static void ice() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(postMap[i][j] > 0) {
					map[i][j] -= postMap[i][j];
				}
				if(map[i][j] < 0) {
					map[i][j] = 0;
				}
			}
		}
	}
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[y][x] = true;

		while(!q.isEmpty()) {
			Node poll = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = poll.x + dx[i];
				int ny = poll.y + dy[i];

				if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

				if(!visited[ny][nx]) {
					if(map[ny][nx] == 0 && map[poll.y][poll.x] > 0) {
						postMap[poll.y][poll.x]++;
					}
					if(map[ny][nx] != 0) {
						visited[ny][nx] = true;
						q.add(new Node(nx, ny));
					}
				}
			}

		}
	}

}
