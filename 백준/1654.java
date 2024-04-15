import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ 1654 랜선 자르기 (S2)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int k = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		long[] lines = new long[k];

		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lines[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(lines);

		long left = 1;
		long right = lines[k - 1];

		while (left <= right) {
			long mid = (left + right) / 2;
			int cnt = 0;

			for (int i = 0; i < k; i++) {
				cnt += lines[i] / mid;
			}

			if(cnt >= n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(right);
	}
}
