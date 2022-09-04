import java.io.*;
import java.util.*;
//BOJ 6593 상범 빌딩
public class Main {
	public static class Node {
		int z;
		int y;
		int x;
		Node(int z, int y, int x) {
			this.y = y;
			this.x = x;
			this.z = z;
		}
	}
	static int l,r,c; // 층 행 열
	static char[][][] map;
	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {-1,1,0,0,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	static Queue<Node> q;
	static int[][][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] inputs = br.readLine().split(" ");
			l = Integer.parseInt(inputs[0]);
			r = Integer.parseInt(inputs[1]);
			c = Integer.parseInt(inputs[2]);
			if(l == 0 && r == 0 && c == 0) break;
			map = new char[l][r][c];
			visited = new int[l][r][c];
			q = new LinkedList<>();
			for(int i = 0; i < l; i++) {
				for(int j = 0; j < r; j++) {
					String row = br.readLine();
					for(int k = 0; k < c; k++) {
						char c = row.charAt(k);
						map[i][j][k] = c;
						if(c == 'S') {
							q.add(new Node(i, j, k));
						}
					}
				}
				br.readLine();
			}
			bfs();

		}
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			Node poll = q.poll();
			if(map[poll.z][poll.y][poll.x] == 'E') {
				System.out.println("Escaped in " + visited[poll.z][poll.y][poll.x] + " minute(s).");
				return;
			}
			for(int i = 0; i < 6; i++) {
				int nz = poll.z + dz[i];
				int ny = poll.y + dy[i];
				int nx = poll.x + dx[i];
				if(nz < 0 || nz >= l || ny < 0 || ny >= r || nx < 0 || nx >= c) continue;

				if(visited[nz][ny][nx] == 0 && (map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E')) {
					visited[nz][ny][nx] = visited[poll.z][poll.y][poll.x] + 1;
					q.add(new Node(nz, ny, nx));
				}
			}
		}

		System.out.println("Trapped!");
	}


}

