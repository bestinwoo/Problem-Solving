import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//BOJ 18111 마인크래프트 (S2)
public class Main {
	static int[][] map;
	static int optimalTime = Integer.MAX_VALUE;
	static int optimalHeight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int b = Integer.parseInt(input[2]);
		map = new int[n][m];
		int max = 0, min = Integer.MAX_VALUE;

		// Initialize the map and find min and max heights
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int height = Integer.parseInt(st.nextToken());
				map[i][j] = height;
				max = Math.max(max, height);
				min = Math.min(min, height);
			}
		}


		for (int targetHeight = min; targetHeight <= max; targetHeight++) {
			int time = calculateTime(n, m, targetHeight, b);
			if (time != -1 && time <= optimalTime) {
				optimalTime = time;
				optimalHeight = targetHeight;
			}
		}

		System.out.println(optimalTime + " " + optimalHeight);
	}

	private static int calculateTime(int n, int m, int targetHeight, int inventory) {
		int time = 0;
		int blocks = inventory;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int currentHeight = map[i][j];
				if (currentHeight > targetHeight) {
					int removeBlocks = currentHeight - targetHeight;
					blocks += removeBlocks;
					time += removeBlocks * 2;
				} else if (currentHeight < targetHeight) {
					int addBlocks = targetHeight - currentHeight;
					blocks -= addBlocks;
					time += addBlocks;
				}
			}
		}

		return blocks >= 0 ? time : -1;
	}
}
