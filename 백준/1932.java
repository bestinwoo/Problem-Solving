import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i > 0) {
					if(j > 0) {
						dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + map[i][j];
					} else {
						dp[i][j] = dp[i-1][j] + map[i][j];
					}
				} else {
					dp[i][j] = map[i][j];
				}
			}
		}
		int max = 0;
		for (int i : dp[n - 1]) {
			max = Math.max(max, i);
		}

		System.out.println(max);
	}

}
