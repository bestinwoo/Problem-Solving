import java.io.*;
import java.util.*;
//BOJ 15649 N과 M (1)
public class Main {
	static int n,m;
	static int[] arr;
	static boolean[] isUsed;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		arr = new int[m];
		isUsed = new boolean[n+1];
		backtracking(0);
	}

	public static void backtracking(int cnt) {
		if(cnt == m) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for(int i = 1; i <= n; i++) {
			if(!isUsed[i]) {
				arr[cnt] = i;
				isUsed[i] = true;
				backtracking(cnt+1);
				isUsed[i] = false;
			}
		}
	}



}

