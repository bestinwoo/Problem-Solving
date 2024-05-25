import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//BOJ 1389 케빈 베이컨의 6단계 법칙 (S1)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[][] map = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i != j) {
					map[i][j] = 5001;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			String[] rel = br.readLine().split(" ");
			int a = Integer.parseInt(rel[0]);
			int b = Integer.parseInt(rel[1]);
			
			map[a][b] = 1;
			map[b][a] = 1;
		}

		//플로이드-워셜  (D_ab = min(D_ab, D_ak + D_kb)
		for (int k = 1; k <= n; k++) {
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int result = -1;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += map[i][j];
			}

			if(sum < min) {
				min = sum;
				result = i;
			}
		}

		System.out.println(result);
	}
}
