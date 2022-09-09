import java.io.*;
import java.util.*;
//BOJ 1780 종이의 개수
public class Main {
	static int[][] paper;
	static int[] answer; // 0 = -1 1 = 0 2 = 1
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		answer = new int[3];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0,0, n);
		for (int i : answer) {
			System.out.println(i);
		}
	}

	public static void solve(int x, int y, int n) {
		if(check(x,y,n)) {
			answer[paper[y][x] + 1]++;
			return;
		}
		int divide = n / 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				solve(x + divide * j, y + divide * i, divide);
			}
		}

	}

	public static boolean check(int x, int y, int n) {
		for(int i = y; i < y + n; i++) {
			for(int j = x; j < x + n; j++) {
				if(paper[y][x] != paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}


}

