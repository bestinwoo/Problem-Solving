import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 14890 경사로 (G3)
public class Main {
	static int n,l;
	static int[][] map;
	static int[][] checkArr;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		l = Integer.parseInt(s[1]);
		map = new int[100][100];
		checkArr = new int[200][100];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//가로 삽입
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				checkArr[row][col] = map[row][col];
			}
		}
		//세로 삽입
		for(int col = 0; col < n; col++) {
			for(int row = 0; row < n; row++) {
				checkArr[col+n][row] = map[row][col];
			}
		}

		for(int i = 0; i < n*2; i++) {
			int sameRoad = 1;
			boolean canCrossRoad = true;
			for(int j = 0; j < n-1; j++) {
				if(checkArr[i][j] == checkArr[i][j+1]) {
					sameRoad++;
					continue;
				}
				if(checkArr[i][j] + 1 == checkArr[i][j+1]) { // 뒤에가 더 높을 때
					if(sameRoad >= l) {
						sameRoad = 1;
					} else {
						canCrossRoad = false;
						break;
					}
				} else if(checkArr[i][j] == checkArr[i][j+1] + 1) { // 뒤에가 더 낮을 때
					int cnt = 1;
					for(int k = 1; k < l; k++) {
						if(checkArr[i][j+k] == checkArr[i][j+k+1]) {
							cnt++;
						}
					}

					if(cnt == l) {
						j += cnt-1;
						sameRoad = 0;
					}
				} else if(Math.abs(checkArr[i][j] - checkArr[i][j+1]) > 1) {
					canCrossRoad = false;
					break;
				}
			}
			if(canCrossRoad) {
				answer++;
			}
		}
		System.out.println(answer);
	}


}
