import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//BOJ 14940 쉬운 최단거리 (S1)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int[][] map = new int[n][m];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num == 1 ? -1 : (num == 2 ? 0 : num);
				if(num == 2) q.add(new int[]{i, j});
			}
		}

		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			for (int i = 0; i < 4; i++) {
					int nextX = poll[1] + dx[i], nextY = poll[0] + dy[i];
					if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;

					if(map[nextY][nextX] == -1) {
						q.add(new int[]{nextY, nextX});
						map[nextY][nextX] = map[poll[0]][poll[1]] + 1;
					}
			}
		}

		for (int[] line : map) {
			for (int point : line) System.out.print(point + " ");
			System.out.println();
		}
	}
}
