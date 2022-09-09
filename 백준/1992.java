import java.io.*;
import java.util.*;
//BOJ 1992 쿼드트리
public class Main {
	static int[][] video;
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		video = new int[n][n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				video[i][j] = s.charAt(j) - '0';
			}
		}
		quadTree(0,0,n);
		System.out.println(str);
	}

	static void quadTree(int x, int y, int n) {
		if(check(x,y,n)) {
			str.append(video[y][x]);
			return;
		}
		str.append("(");
		int divide = n / 2;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				quadTree(x + j * divide, y + i * divide, divide);
			}
		}
		str.append(")");
	}

	static boolean check(int x, int y, int n) {
		for(int i = y; i < y + n; i++) {
			for(int j = x; j < x + n; j++) {
				if(video[y][x] != video[i][j]) return false;
			}
		}
		return true;
	}
}

