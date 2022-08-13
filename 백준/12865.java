import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	static int[] w, v;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		w = new int[n];
		v = new int[n];
		dp = new int[n+1][k+1];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < k+1; j++) {
				//물건의 무게가 가방 무게를 초과하지 않을 경우
				if(w[i-1] <= j) {
					dp[i][j] = Math.max(v[i-1] + dp[i-1][j-w[i-1]], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][k]);
	}

}
