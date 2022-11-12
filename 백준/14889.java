import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 14889 스타트와 링크
public class Main {
	static int N;
	static int[][] S;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N+1][N+1];
		visited = new boolean[N+1];

		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 1);
		System.out.println(min);
	}

	public static void comb(int cnt, int idx) {
		if(cnt == N / 2) {
			int team1 = 0;
			int team2 = 0;
			for(int i = 1; i < N; i++) {
				for(int j = i+1; j <= N; j++) {
					if(visited[i] && visited[j]) {
						team1 += S[i][j] + S[j][i];
					} else if(!visited[i] && !visited[j]) {
						team2 += S[i][j] + S[j][i];
					}
				}
			}
			min = Math.min(Math.abs(team1 - team2), min);
			return;
		}

		for(int i = idx; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(cnt + 1, i);
				visited[i] = false;
			}
		}
	}
}
