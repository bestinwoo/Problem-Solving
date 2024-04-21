import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ 21736 헌내기는 친구가 필요해(S2)
public class Main {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static char[][] campus;
	static boolean[][] visitied;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		campus = new char[n][m];
		visitied = new boolean[n][m];

		int startX = 0, startY = 0;
		for (int i = 0; i < n; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < chars.length; j++) {
				campus[i][j] = chars[j];
				if(chars[j] == 'I') {
					startY = i; startX= j;
				}
			}
		}
		visitied[startY][startX] = true;
		dfs(startX, startY);

		System.out.println(cnt == 0 ? "TT" : cnt);

	}

	public static void dfs(int x, int y) {
		if(campus[y][x] == 'P') cnt++;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if(nextX < 0 || nextX >= campus[y].length || nextY < 0 || nextY >= campus.length || visitied[nextY][nextX] || campus[nextY][nextX] == 'X') continue;
			visitied[nextY][nextX] = true;
			dfs(nextX, nextY);
		}
	}
}