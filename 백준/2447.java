import java.io.*;
import java.util.*;
//BOJ 2447 별 찍기 - 10
public class Main {
	static char[][] star;
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		star = new char[n][n];
		drawStar(0,0,n,false);

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				str.append(star[i][j]);
			}
			str.append('\n');
		}

		System.out.println(str);
	}

	public static void drawStar(int y, int x, int n, boolean isBlank) {
		//빈 공간일 경우
		if(isBlank) {
			for(int i = y; i < y + n; i++) {
				for(int j = x; j < x + n; j++) {
					star[i][j] = ' ';
				}
			}
			return;
		}
		//더 이상 분할 할 수 없을 경우 별을 찍음 (공백은 위에서 처리)
		if(n == 1) {
			star[y][x] = '*';
			return;
		}
		//n을 3으로 분할
		int divide = n / 3;

		/*
		  for문을 divide만큼 증가시키면 총 3 * 3 9번 돌아가는데 5번째 반복은 무조건 공백처리임
		  3이라고 치면
		  ***(1,2,3)
		  * *(4,5는공백,6)
		  ***(7,8,9)
		 */
		int cnt = 0;
		for(int i = y; i < y + n; i+= divide) {
			for(int j = x; j < x + n; j+= divide) {
				cnt++;
				drawStar(i,j,divide, cnt == 5);
			}
		}
	}

}

