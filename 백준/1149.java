import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] cost = new int[n+1][3];
		int[][] memo = new int[n+1][3];

		for(int i = 1; i < cost.length; i++) {
			for(int j = 0; j < cost[i].length; j++) {
				cost[i][j] = sc.nextInt();
			}
		}

		for(int i = 1; i < memo.length; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + cost[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + cost[i][1];
			memo[i][2] = Math.min(memo[i-1][1], memo[i-1][0]) + cost[i][2];
		}

		System.out.println(Math.min(Math.min(memo[n][0], memo[n][1]), memo[n][2]));
	}
}
