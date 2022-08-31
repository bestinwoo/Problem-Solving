import java.io.*;
import java.util.*;
//BOJ 16918 봄버맨
public class Main {
	static int r,c,n;
	static int[][] time_graph;
	static char[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int time = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		r = Integer.parseInt(split[0]);
		c = Integer.parseInt(split[1]);
		n = Integer.parseInt(split[2]);
		if(n % 2 == 0) {
			full();
			return;
		}
		time_graph = new int[r][c];
		map = new char[r][c];
		for(int i =0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				char item = s.charAt(j);
				map[i][j] = item;
				if(item == '.') {
					time_graph[i][j] = 0;
				} else {
					time_graph[i][j] = 2;
				}
			}
		}
		if(n == 1) {
			show();
			return;
		}

		while(true) {
			time++;
			//1초 동안 모든칸 폭탄 설치
			for(int i = 0; i < time_graph.length; i++) {
				for(int j = 0; j < time_graph[i].length; j++) {
					if(map[i][j] == '.') {
						map[i][j] = 'O';
						time_graph[i][j] = 2;
					} else {
						time_graph[i][j]--;
					}
				}
			}
			if(time == n) break;

			//터질애들 터짐
			time++;
			for(int i = 0; i < time_graph.length; i++) {
				for(int j = 0; j < time_graph[i].length; j++) {
					if(time_graph[i][j] == 1 && map[i][j] == 'O') {
						time_graph[i][j] = 0;
						map[i][j] = '.';
						for(int k = 0; k < 4; k++) {
							int nx = j + dx[k];
							int ny = i + dy[k];
							if(nx < 0 || nx >= c || ny < 0 || ny >= r) continue;
							if(time_graph[ny][nx] != 1) {
								time_graph[ny][nx] = 0;
								map[ny][nx] = '.';
							}
						}
					}
				}
			}

			if(time == n) break;
		}
		show();
	}

	public static void full() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print("O");
			}
			System.out.println();
		}
	}

	public static void show() {
		for (char[] chars : map) {
			for (char aChar : chars) {
				System.out.print(aChar);
			}
			System.out.println();
		}
	}

}

