import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//BOJ 15688 수 정렬하기 5
public class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		int[] count = new int[2000001];
		int max = 0;
		int min = 2000002;
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			count[a + 1000000]++;
			max = Math.max(max, a + 1000000);
			min = Math.min(min, a + 1000000);
		}

		for(int i = min; i <= max; i++) {
			if(count[i] > 0) {
				for (int j = 0; j < count[i]; j++) {
					sb.append(i - 1000000).append('\n');
				}
			}
		}
		System.out.print(sb);
	}
}
