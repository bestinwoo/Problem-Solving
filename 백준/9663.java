import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] board;
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		board = new int[n];
		nQueen(0);
		System.out.println(cnt);
	}

	public static void nQueen(int x) {
		if(x == n) {
			cnt++;
			return;
		}

		for(int i = 0; i < n; i++) {
			//모든 행을 돌면서 하나씩 퀸을 놓음
			board[x] = i;
			if(promising(x)) {
				nQueen(x+1);
			}
		}
	}

	public static boolean promising(int x) {
		//i = 그 전의 퀸들의 행, board[i] = 그 전 퀸들의 열, x = 지금 놓으려는 행, board[x] = 지금 놓으려는 열
		//열의 차와 행의 차가 같으면 대각선에 놓여져 있다는 것
		for(int i = 0; i < x; i++) {
			if(board[x] == board[i] || Math.abs(i-x) == Math.abs(board[i] - board[x])) {
				return false;
			}
		}
		return true;
	}
}
