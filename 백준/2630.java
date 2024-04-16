import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ 2630 색종이 만들기 (S2)
public class Main {
	static int[][] paper;
	static int[] answer = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0,0, n);
		Arrays.stream(answer).forEach(System.out::println);
	}

	static void divide(int x, int y, int n) {
		for (int i = y; i < n + y; i++) {
			for (int j = x; j < n + x; j++) {
				if(paper[i][j] != paper[y][x]) { // 나눈 범위에서 색이 일치하지 않으면 분할한다.
					divide(x, y ,n/2);
					divide(x + n/2, y, n/2);
					divide(x, y + n/2, n/2);
					divide(x+n/2, y+n/2, n/2);
					return;
				}
			}
		}
		//모두 일치하면 해당 색종이 개수를 더한다.
		answer[paper[y][x]]++;
	}
}
