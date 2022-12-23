import java.util.Scanner;

//BOJ 12852 1로 만들기 2 (S1)
public class Main {
	public static void main(String[] args) {
		int n;
		int[] dp;
		int[] nums;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		dp = new int[n + 1];
		nums = new int[n + 1];

		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			nums[i] = i - 1;
			if(i % 3 == 0 && dp[i] > dp[i/3] + 1) {
				dp[i] = dp[i/3] + 1;
				nums[i] = i / 3;
			}
			if(i % 2 == 0 && dp[i] > dp[i/2] + 1) {
				dp[i] = dp[i/2] + 1;
				nums[i] = i / 2;
			}
		}

		System.out.println(dp[n]);
		int cur = n;
		while (true) {
			System.out.print(cur + " ");
			if(cur == 1) break;
			cur = nums[cur];
		}
	}


}
