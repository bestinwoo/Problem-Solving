import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 18808 스티커 붙이기
/*
	1. 스티커의 면적이 노트북의 면적을 넘지 않는지 체크
	2. 스티커를 붙일 공간에 이미 다른 스티커가 없는지 체크
	3. 이 때 붙일 수 없으면 90도 회전, 3번 회전 후에도 못 붙이면 버림
	4. 반복 후 모든 스티커 붙이기가 끝나면 스티커 칸 계산
 */
public class Main {
	static int n,m,k;
	static int[][] notebook;
	static int[][][] stickers;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);
		stickers = new int[k][][];
		notebook = new int[n][m];
		for(int i = 0; i < k; i++) {
			int r,c;
			String[] sticker = br.readLine().split(" ");
			r = Integer.parseInt(sticker[0]);
			c = Integer.parseInt(sticker[1]);
			stickers[i] = new int[r][c];
			for(int j = 0; j < r; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int l = 0; l < c; l++) {
					stickers[i][j][l] = Integer.parseInt(st.nextToken());
				}
			}
		}
		attachCheck(0, 0);
		check();
		System.out.println(result);
	}

	public static void attachCheck(int index, int cnt) {
		if(index == k) return;
		int[][] sticker = stickers[index];
		for(int i = 0; i <= n - sticker.length; i++) {
			for(int j = 0; j <= m - sticker[0].length; j++) {
				if(attach(j,i,index)) {
					attachCheck(index + 1, 0);
					return;
				}
			}
		}
		if(cnt < 3) {
			rotate(index);
			attachCheck(index, cnt + 1);
		} else {
			attachCheck(index + 1, 0);
		}
	}

	public static void rotate(int index) {
		int[][] tmp = new int[stickers[index][0].length][stickers[index].length];
		for(int i = 0; i < stickers[index].length; i++) {
			for(int j = 0; j < stickers[index][0].length; j++) {
				tmp[j][i] = stickers[index][stickers[index].length - (i + 1)][j];
			}
		}
		stickers[index] = tmp;
	}

	public static boolean attach(int x, int y, int index) {
		for(int i = 0; i < stickers[index].length; i++) {
			for(int j = 0; j < stickers[index][i].length; j++) {
				if(stickers[index][i][j] == 1 && notebook[i+y][j+x] == 1)
					return false;
			}
		}

		for(int i = 0; i < stickers[index].length; i++) {
			for(int j = 0; j < stickers[index][i].length; j++) {
				if(stickers[index][i][j] == 1) {
					notebook[i + y][j + x] = stickers[index][i][j];
				}
			}
		}
		return true;
	}

	public static void check() {
		int cnt = 0;
		for (int[] ints : notebook) {
			for (int anInt : ints) {
				if(anInt == 1) {
					cnt++;
				}
			}
		}
		result = Math.max(result,cnt);
	}

}
