import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Node {
		int x;
		int y;
		int breakingWall;

		Node(int y, int x, int breakingWall) {
			this.x = x;
			this.y = y;
			this.breakingWall = breakingWall;
		}
	}

	static int n, m;
	static int[][] map;
	static int[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		System.out.println(bfs(map));
	}

	public static int bfs(int[][] map) {
		visited = new int[n][m][2];
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0));
		visited[0][0][0] = 1;
		while (!q.isEmpty()) {
			Node poll = q.poll();
			//목적지에 도착하면 거리값 리턴 (최단거리가 먼저 이 조건에 도착할 수 밖에 없음)
			if (poll.y == n - 1 && poll.x == m - 1) {
				return visited[poll.y][poll.x][poll.breakingWall];
			}

			for (int i = 0; i < 4; i++) {
				int nx = poll.x + dx[i];
				int ny = poll.y + dy[i];
				if (nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;
				//방문하지 않은 벽이 없는 곳
				if (visited[ny][nx][poll.breakingWall] == 0 && map[ny][nx] == 0) {
					q.add(new Node(ny, nx, poll.breakingWall));
					visited[ny][nx][poll.breakingWall] = visited[poll.y][poll.x][poll.breakingWall] + 1;
					// 벽을 깬 적이 없는데 벽을 만난 경우
				} else if (poll.breakingWall == 0 && map[ny][nx] == 1) {
					q.add(new Node(ny, nx, 1));
					visited[ny][nx][1] = visited[poll.y][poll.x][poll.breakingWall] + 1;
				}
			}
		}
		return -1;
	}
}
