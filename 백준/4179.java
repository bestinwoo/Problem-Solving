import java.io.*;
import java.util.*;
//BOJ 4179 불!
public class Main {
	static int m,n;
	static char[][] map;
	static int[][] fireMap, jihunMap;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1, 1, 0, 0};
	static int escapeTime = Integer.MAX_VALUE;
	static Queue<int[]> fireQueue = new LinkedList<>();
	static Queue<int[]> jihunQueue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		map = new char[n][m];
		fireMap = new int[n][m];
		jihunMap = new int[n][m];
		visited = new boolean[n][m];

		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < m; j++) {
				char c = input.charAt(j);
				map[i][j] = c;
				if(c == 'J') {
					jihunMap[i][j] = 0;
					jihunQueue.add(new int[]{i,j});
				} else if(c == 'F') {
					fireMap[i][j] = 0;
					fireQueue.add(new int[]{i, j});
					visited[i][j] = true;
				} else {
					jihunMap[i][j] = Integer.MAX_VALUE;
					fireMap[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		setFireMap();
		visited = new boolean[n][m];
		findEscape();
		if(escapeTime == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(escapeTime);
		}


	}

	public static void setFireMap() {
		while(!fireQueue.isEmpty()) {
			int[] poll = fireQueue.poll();
			for(int i = 0; i < 4; i++) {
				int ny = poll[0] + dy[i];
				int nx = poll[1] + dx[i];
				if(!boundaryCheck(ny, nx)) continue;

				if(!visited[ny][nx] && map[ny][nx] != '#') {
					visited[ny][nx] = true;
					fireMap[ny][nx] = fireMap[poll[0]][poll[1]] + 1;
					fireQueue.add(new int[] {ny, nx});
				}
			}
		}
	}

	public static boolean boundaryCheck(int ny, int nx) {
		if(ny < 0 || ny >= n || nx < 0 || nx >= m) return false;
		return true;
	}

	public static void findEscape() {
		while(!jihunQueue.isEmpty()) {
			int[] poll = jihunQueue.poll();
			visited[poll[0]][poll[1]] = true;
			if(poll[0] == 0 || poll[0] == n - 1 || poll[1] == 0 || poll[1] == m - 1) {
				escapeTime = jihunMap[poll[0]][poll[1]] + 1;
				return;
			}

			for(int i = 0; i < 4; i++) {
				int ny = poll[0] + dy[i];
				int nx = poll[1] + dx[i];
				if(!boundaryCheck(ny,nx)) continue;

				if(!visited[ny][nx] && map[ny][nx] == '.') {
					jihunMap[ny][nx] = jihunMap[poll[0]][poll[1]] + 1;
					visited[ny][nx] = true;
					if(jihunMap[ny][nx] < fireMap[ny][nx]) {
						jihunQueue.add(new int[]{ny, nx});
					}
				}
			}
		}
	}

}

