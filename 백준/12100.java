import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 12100 2048(Easy)
public class Main {
	static int n;
	static int max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < 4; i++) {
			push(i, 0, board);
		}

		System.out.println(max);
	}

	public static void copy(int[][] board, int[][] copyBoard) {
		for(int i = 0; i < n; i++) {
			System.arraycopy(board[i], 0, copyBoard[i], 0, n);
		}
	}

	public static void push(int d, int cnt, int[][] board) {
		if(cnt == 5) return;
		int[][] copyBoard = new int[n][n];
		copy(board, copyBoard);
		Queue<Integer> q = new LinkedList<>();
		if(d == 0) { // left
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(copyBoard[i][j] != 0) {
						q.add(copyBoard[i][j]);
					}
					copyBoard[i][j] = 0;
				}
				int idx = 0;
				while(!q.isEmpty()) {
					Integer data = q.poll();
					if(copyBoard[i][idx] == 0) {
						copyBoard[i][idx] = data;
					} else if(copyBoard[i][idx] == data) {
						copyBoard[i][idx] *= 2;
						idx++;
					} else {
						idx++;
						copyBoard[i][idx] = data;
					}
				}
			}
		} else if(d == 1) { // right
			for(int i = 0; i < n; i++) {
				for(int j = n-1; j >= 0; j--) {
					if(copyBoard[i][j] != 0) {
						q.add(copyBoard[i][j]);
					}
					copyBoard[i][j] = 0;
				}
				int idx = n-1;
				while(!q.isEmpty()) {
					Integer data = q.poll();
					if(copyBoard[i][idx] == 0) {
						copyBoard[i][idx] = data;
					} else if(copyBoard[i][idx] == data) {
						copyBoard[i][idx] *= 2;
						idx--;
					} else {
						idx--;
						copyBoard[i][idx] = data;
					}
				}
			}
		} else if(d == 2) { // up
			for(int j = 0; j < n; j++) {
				for(int i = 0; i < n; i++) {
					if(copyBoard[i][j] != 0) {
						q.add(copyBoard[i][j]);
					}
					copyBoard[i][j] = 0;
				}
				int idx = 0;
				while(!q.isEmpty()) {
					Integer data = q.poll();
					if(copyBoard[idx][j] == 0) {
						copyBoard[idx][j] = data;
					} else if(copyBoard[idx][j] == data) {
						copyBoard[idx][j] *= 2;
						idx++;
					} else {
						idx++;
						copyBoard[idx][j] = data;
					}
				}
			}
		} else if(d == 3) { //down
			for(int j = 0; j < n; j++) {
				for(int i = n-1; i >= 0; i--) {
					if(copyBoard[i][j] != 0) {
						q.add(copyBoard[i][j]);
					}
					copyBoard[i][j] = 0;
				}
				int idx = n-1;
				while(!q.isEmpty()) {
					Integer data = q.poll();
					if(copyBoard[idx][j] == 0) {
						copyBoard[idx][j] = data;
					} else if(copyBoard[idx][j] == data) {
						copyBoard[idx][j] *= 2;
						idx--;
					} else {
						idx--;
						copyBoard[idx][j] = data;
					}
				}
			}
		}
		getMax(copyBoard);
		for(int i = 0; i < 4; i++) {
			push(i, cnt + 1, copyBoard);
		}
	}

	public static void getMax(int[][] board) {
		for (int[] ints : board) {
			for (int anInt : ints) {
				max = Math.max(max, anInt);
			}
		}
	}
}
