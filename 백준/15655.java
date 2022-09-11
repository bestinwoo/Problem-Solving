import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ 15655 N과 M (6)
public class Main {
	static int n, m;
	static int[] selected, arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		arr = new int[n];
		selected = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);
	}

	public static void dfs(int index, int cnt) {
		if(cnt == m) {
			for(int i = 0; i < cnt; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append('\n');
			return;
		}

		for(int i = index; i < n; i++) {
				selected[cnt] = arr[i];
				dfs(i+1, cnt+1);
		}
	}
}

