import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static int n,m;
	static int[] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		map = new int[n+1];
		visited = new boolean[n+1];
		dfs(1, 0);

	}

	public static void dfs(int num, int count) {
		if(count == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println();
			return;
		} else {
			for(int i = num; i <= n; i++) {
				if(!visited[i]) {
					visited[i] = true;
					map[count] = i;
					dfs(i + 1, count + 1);
					visited[i] = false;
				}
			}
		}
	}
}
