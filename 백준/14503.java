import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int y;
		int dir;
	}
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int n,m;
	static int[][] map;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		map = new int[n][m];

		Node robot = new Node();
		s = br.readLine().split(" ");
		robot.y = Integer.parseInt(s[0]);
		robot.x = Integer.parseInt(s[1]);
		robot.dir = Integer.parseInt(s[2]);


		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Node> q = new LinkedList<>();
		q.add(robot);

		while(!q.isEmpty()) {
			Node cur = q.poll();
			//1. 현재 위치를 청소한다.
			if(map[cur.y][cur.x] == 0) {
				map[cur.y][cur.x] = 2;
				count++;
			}

			for(int i = 0; i < 4; i++) {
				Node next = new Node();
				//2. 현재 방향을 기준으로 왼쪽방향으로 회전하면서 청소할 공간 탐색
				next.dir = (cur.dir + 3 - i) % 4;
				next.y = cur.y + dy[next.dir];
				next.x = cur.x + dx[next.dir];
				//2-b. 왼쪽 방향에 청소할 공간이 없으면 그 방향으로 회전 하고 2번으로 돌아간다.
				if(next.y < 0 || next.y >= n || next.x < 0 || next.x >= m || map[next.y][next.x] != 0) continue;
				//2-a.  청소할 곳을 찾으면 그 방향으로 한칸 전진하고 1번부터 시작
				q.add(next);
				//break를 해주는 이유는 일반적인 BFS와 다르게 로봇이 한 곳에만 존재해야 하기 때문이다.
				break;
			}

			if(q.isEmpty()) { // 4방향 모두 청소할 곳이 없다면 뒤로 후진
				Node next = new Node();
				next.dir = cur.dir;
				next.x = cur.x + dx[(next.dir+2) % 4];
				next.y = cur.y + dy[(next.dir+2) % 4];

				if(next.y < 0 || next.y >= n || next.x < 0 || next.x >= m || map[next.y][next.x] == 1) {
					//2-d. 맵 밖으로 나가거나 후진할 곳이 벽인 경우 종료
					break;
				} else {
					//2-c. 바라보는 방향을 유지한 채로 한 칸 후진한 뒤 2번부터 시작한다.
					q.add(next);
				}
			}
		}
		System.out.println(count);
	}
}
