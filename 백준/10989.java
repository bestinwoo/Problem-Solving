import java.io.BufferedReader;
import java.io.InputStreamReader;

//BOJ 10989 수 정렬하기 3
public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[10001];
		int max = 0;
		for(int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			arr[input]++;
			max = Math.max(max, input);
		}

		for(int i = 0; i <= max; i++) {
			if(arr[i] > 0) {
				for(int j = 0; j < arr[i]; j++) {
					sb.append(i).append('\n');
				}
			}
		}
		System.out.print(sb);
	}

}
