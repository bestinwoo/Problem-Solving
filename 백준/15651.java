import java.io.BufferedReader;
import java.io.InputStreamReader;

//BOJ 15651 N과 M (3)
public class Main {
	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		arr = new int[n];
		
		dfs(0, 1);
		System.out.println(sb);
	}

	public static void dfs(int cnt, int num) {
		if(cnt == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
			return;
		}

		for(int i = 1; i <= n; i++) {
				arr[cnt] = i;
				dfs(cnt + 1, i + 1);
		}
	}


}

