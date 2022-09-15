import java.io.BufferedReader;
import java.io.InputStreamReader;

//BOJ 2579 계단 오르기
public class Main {
	static int n;
	static int[] dp;
	static int[] stairs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		stairs = new int[n+1];
		for(int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = stairs[1];

		if(n > 1) {
			dp[2] = stairs[1] + stairs[2];
		}

		for(int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
		}

		System.out.println(dp[n]);
	}
}
