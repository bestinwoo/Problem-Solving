import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Shark {
		int x, y, time;
	}
	static int[][] map;
	static Shark shark = new Shark();
	static int size = 2,eat = 0;
	static int n;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					shark.y = i;
					shark.x = j;
					shark.time = 0;
					map[i][j] = 0;
				}
			}
		}

		boolean isUpdate = true;
		while(isUpdate) {
			isUpdate = false;
			boolean[][] visited = new boolean[n][n];
			Queue<Shark> q = new LinkedList<>();
			visited[shark.y][shark.x] = true;
			q.add(shark);

			Shark candi = new Shark(); // 먹을놈
			candi.y = n;
			candi.time = -1;
			while(!q.isEmpty()) {
				Shark cur = q.poll();

				if(candi.time != -1 && candi.time < cur.time) {
					break;
				}

				if(map[cur.y][cur.x] < size && map[cur.y][cur.x] != 0) {
					isUpdate = true;
					if(candi.y > cur.y || (candi.y == cur.y && candi.x > cur.x)) {
						candi = cur;
					}
				}
				for(int i = 0; i < 4; i++) {
					Shark next = new Shark();
					next.y = cur.y + dy[i];
					next.x = cur.x + dx[i];
					next.time = cur.time + 1;

					if(next.y < 0 || next.y >= n || next.x < 0 || next.x >= n) continue;

					if(!visited[next.y][next.x] && map[next.y][next.x] <= size) {
						visited[next.y][next.x] = true;
						q.add(next);
					}
				}
			}
			if(isUpdate) {
				shark = candi;
				eat++;
				if(eat == size) {
					size++;
					eat = 0;
				}
				map[shark.y][shark.x] = 0;
			}
		}
		System.out.println(shark.time);

	}


}
