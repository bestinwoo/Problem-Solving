import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 14499 주사위 굴리기(Gold 4)
class Point {
	int x;
	int y;
	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int[] dx = {0,1,-1,0,0};
	static int[] dy = {0,0,0,-1,1};
	static int[] dice = {0,0,0,0,0,0,0};
	static int[][] map;
	static int k;
	static Point dicePos;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		map = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
		dicePos = new Point(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
		k = Integer.parseInt(s[4]);
		for(int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		String[] oper = br.readLine().split(" ");
		for(int i = 0; i < k; i++) {
			int operation = Integer.parseInt(oper[i]);
			int nx = dicePos.x + dx[operation];
			int ny = dicePos.y + dy[operation];
			if(nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
			dicePos.x = nx;
			dicePos.y = ny;
			rotate(operation);
			if(map[ny][nx] != 0) {
				dice[6] = map[ny][nx];
				map[ny][nx] = 0;
			} else {
				map[ny][nx] = dice[6];
			}
			System.out.println(dice[1]);
		}
	}

	public static void rotate(int dir) {
		if(dir == 1) { // 동
			int temp = dice[3];
			dice[3] = dice[1];
			dice[1] = temp;
			temp = dice[6];
			dice[6] = dice[1];
			dice[1] = temp;
			temp = dice[4];
			dice[4] = dice[1];
			dice[1] = temp;
		} else if(dir == 2) { // 서
			int temp = dice[4];
			dice[4] = dice[1];
			dice[1] = temp;
			temp = dice[6];
			dice[6] = dice[1];
			dice[1] = temp;
			temp = dice[3];
			dice[3] = dice[1];
			dice[1] = temp;
		} else if(dir == 3) { // 북
			int temp = dice[5];
			dice[5] = dice[6];
			dice[6] = temp;
			temp = dice[1];
			dice[1] = dice[6];
			dice[6] = temp;
			temp = dice[2];
			dice[2] = dice[6];
			dice[6] = temp;
		} else if(dir == 4) { //남
			int temp = dice[1];
			dice[1] = dice[2];
			dice[2] = temp;
			temp = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
			temp = dice[6];
			dice[6] = dice[2];
			dice[2] = temp;
		}
	}

}

