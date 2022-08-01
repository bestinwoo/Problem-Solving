import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int[][] arr = new int[n+1][n+1];
		int[][] d = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				d[i][j] = d[i][j - 1] + d[i-1][j] - d[i-1][j-1] + arr[i][j];
			}
		}

		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			System.out.println(d[ey][ex] - d[ey][sx-1] - d[sy-1][ex] + d[sy-1][sx-1]);
		}
	}
}
