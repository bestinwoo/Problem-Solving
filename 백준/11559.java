import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//BOJ 11559 Puyo Puyo
public class Main {
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for(int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		//1. 4개 이상 연결된 뿌요 터뜨리기
		//2. 위에있는 뿌요들 내려오게 하기
		//3. 반복
		boolean repeat;
		int answer = 0;
		do {
			repeat = false;
			for (int i = 0; i < map.length; i++) {
				char[] col = map[i];
				for (int j = 0; j < col.length; j++) {
					char row = col[j];
					if (row != '.') {
						if(bfs(row, i, j)) {
							repeat = true;
						}
					}
				}
			}
			if(repeat) {
				answer++;
				updatePuyo();
			}
		} while(repeat);

		System.out.println(answer);
	}
	//터뜨리기
	public static boolean bfs(char color, int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> temp = new ArrayList<>();
		boolean[][] visited = new boolean[12][6];
		visited[y][x] = true;
		temp.add(new int[]{y,x});
		q.add(new int[]{y,x});
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if(nx < 0 || nx >= 6 || ny < 0 || ny >= 12) continue;
				if(map[ny][nx] == color && !visited[ny][nx]) {
					visited[ny][nx] = true;
					cnt++;
					q.add(new int[] {ny, nx});
					temp.add(new int[] {ny, nx});
				}
			}
		}

		if(cnt >= 4) {
			for (int[] p : temp) {
				map[p[0]][p[1]] = '.';
			}
			return true;
		}
		return false;
	}

	//빈칸에 뿌요 내리기
	public static void updatePuyo() {
		for(int i = 11; i > 0; i--) {
			for(int j = 0; j < 6; j++) {
				if(map[i][j] == '.') {
					for(int k = i-1; k >= 0; k--) {
						if(map[k][j] != '.') {
							map[i][j] = map[k][j];
							map[k][j] = '.';
							break;
						}
					}
				}
			}
		}
	}
}

