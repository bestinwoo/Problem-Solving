import java.io.*;
import java.util.*;
//BOJ 14501 퇴사
public class Main {
	static int[] dp;
	static int[] time;
	static int[] pay;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[20];
		time = new int[20];
		pay = new int[20];
		for(int i = 1; i <= n; i++) {
			String[] inputs = br.readLine().split(" ");
			time[i] = Integer.parseInt(inputs[0]);
			pay[i] = Integer.parseInt(inputs[1]);
		}
		dp[1] = pay[1];
		for(int i = n; i > 0; i--) {
			if(i + time[i] > n+1) {
				dp[i] = dp[i+1];
			} else {
				dp[i] = Math.max(dp[i + 1], dp[i + time[i]] + pay[i]);
			}
		}
		int max = 0;
		for (int i : dp) {
			max = Math.max(max, i);
		}

		System.out.println(max);
	}
}

