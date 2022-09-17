import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BOJ 15683 감시
/*
1. DFS를 이용해 CCTV들 방향의 모든 조합을 구함
2. 각 경우마다 사각지대 개수를 구하여 최소 사각지대의 개수를 구함
 */
public class Main {
	static public class CCTV {
		int x;
		int y;
		int type;
		int direction;
		CCTV(int x, int y, int type, int direction) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.direction = direction;
		}
	}

	static int n, m;
	static int[][] map, copyMap;
	static ArrayList<CCTV> cctvs;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][m];
		copyMap = new int[n][m];
		cctvs = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new CCTV(j,i,map[i][j],0));
				}
			}
		}
		permutation(0);
		check();
		System.out.println(result);
	}

	//cctv 방향별 경우의 수 순열 구하기
	public static void permutation(int index) {
		if(index == cctvs.size()) {
			copy();
			for (CCTV cctv1 : cctvs) {
				direction(cctv1);
				check();
			}
		} else {
			for(int i = 0; i < 4; i++) {
				CCTV cctv = cctvs.get(index);
				cctv.direction = i;
				permutation(index + 1);
			}
		}
	}
	//cctv 경우의 수에 따라 방향 설정해서 사각지대 구하기
	public static void direction(CCTV cctv) {
		if(cctv.type == 1) {
			observe(cctv, cctv.direction);
		} else if(cctv.type == 2) {
			if(cctv.direction == 0 || cctv.direction == 2) {
				observe(cctv, 2); // 좌우
				observe(cctv, 3);
			} else {
				observe(cctv, 0); // 상하
				observe(cctv, 1);
			}
		} else if(cctv.type == 3) {
			if(cctv.direction == 0) {
				observe(cctv, 0); // 상우
				observe(cctv, 3);
			} else if(cctv.direction == 1) {
				observe(cctv, 3); // 우하
				observe(cctv, 1);
			} else if(cctv.direction == 2) {
				observe(cctv, 2); // 좌하
				observe(cctv, 1);
			} else if(cctv.direction == 3) {
				observe(cctv, 2); // 좌상
				observe(cctv, 0);
			}
		} else if(cctv.type == 4) {
			if (cctv.direction == 0) {
				observe(cctv, 2); // 좌상우
				observe(cctv, 0);
				observe(cctv, 3);
			} else if (cctv.direction == 1) {
				observe(cctv, 0); // 상우하
				observe(cctv, 3);
				observe(cctv, 1);
			} else if (cctv.direction == 2) {
				observe(cctv, 2); // 좌우하
				observe(cctv, 3);
				observe(cctv, 1);
			} else if (cctv.direction == 3) {
				observe(cctv, 2); // 좌상하
				observe(cctv, 0);
				observe(cctv, 1);
			}
		} else if(cctv.type == 5) {
			observe(cctv, 0); // 상하좌우
			observe(cctv, 1);
			observe(cctv, 2);
			observe(cctv, 3);
		}

	}
	//사각지대 구하기
	public static void observe(CCTV cctv, int direction) {
		int nx = cctv.x + dx[direction];
		int ny = cctv.y + dy[direction];

		while(nx >= 0 && nx < m && ny >= 0 && ny < n && copyMap[ny][nx] != 6) {
			copyMap[ny][nx] = -1;
			nx += dx[direction];
			ny += dy[direction];
		}
	}

	//사각지대 개수 계산
	public static void check() {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		result = Math.min(result, cnt);
	}
	//배열 복사
	public static void copy() {
		for(int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, m);
		}
	}
}
