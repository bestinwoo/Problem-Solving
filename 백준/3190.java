import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 3190 뱀 (골드 4)
public class Main {
	static class Move {
		int sec;
		char dir;

		public Move(int sec, char dir) {
			this.sec = sec;
			this.dir = dir;
		}
	}
	static class Pos{
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n,k,l;
	static int[][] map;

	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		map[1][1] = 1;
		for(int i = 0; i < k; i++) {
			String[] pos = br.readLine().split(" ");
			map[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = 2;
		}
		l = Integer.parseInt(br.readLine());

		Queue<Move> moveQ = new LinkedList<>();
		for(int i = 0; i < l; i++) {
			String[] input = br.readLine().split(" ");
			moveQ.add(new Move(Integer.parseInt(input[0]), input[1].charAt(0)));
		}

		Deque<Pos> snake = new LinkedList<>();
		snake.add(new Pos(1,1));
		int dir = 1;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		while(true) {
			dir %= 4;
			answer++;
			int nx = snake.getLast().x + dx[dir];
			int ny = snake.getLast().y + dy[dir];

			if (nx > n || nx < 1 || ny > n || ny < 1 || map[ny][nx] == 1) {
				break;
			}

			snake.addLast(new Pos(nx, ny));
			if(map[ny][nx] != 2) {
				Pos poll = snake.pollFirst();
				map[poll.y][poll.x] = 0;
			}
			map[ny][nx] = 1;

			if(!moveQ.isEmpty() && moveQ.element().sec == answer) {
				char c = moveQ.poll().dir;
				if(c == 'D') dir += 1;
				else if(c == 'L') dir += 3;
			}
		}

		System.out.println(answer);

	}



}

