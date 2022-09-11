import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 1182 부분수열의 합
public class Main {
	static int n, s;
	static int[] arr, sub;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		s = Integer.parseInt(input[1]);
		arr = new int[n];
		sub = new int[n];
		visited = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(0, 0);
		//s가 0인 경우 공집합도 cnt에 포함되므로 하나를 빼줌
		if(s == 0) cnt--;
		System.out.println(cnt);
	}

	public static void backtracking(int depth, int sum) {
		if (depth == n) {
			if(s == sum) {
				cnt++;
			}
			return;
		}
		backtracking(depth+1, sum+arr[depth]);
		backtracking(depth+1, sum);
	}

}

