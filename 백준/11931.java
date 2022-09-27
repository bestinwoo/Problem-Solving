import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//BOJ 11931 수 정렬하기 4
public class Main {
	static int n;
	static Integer[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new Integer[n];
		for(int i = 0; i < n; i++) {
			arr[i] =  Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.print(sb);
	}

}
