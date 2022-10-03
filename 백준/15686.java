import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

//BOJ 15686 치킨 배달
public class Main {
	public static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n, m;
	static int[][] map;
	static Stack<Point> open = new Stack<>();
	static ArrayList<Point> home = new ArrayList<>();
	static ArrayList<Point> shop = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new Point(j, i));
				} else if(map[i][j] == 2) {
					shop.add(new Point(j, i));
				}
			}
		}

		combination(0,0);

		System.out.println(answer);
	}

	public static void combination(int start, int cnt) {
		if(cnt == m) {
			chicken();
		}
		for(int i = start; i < shop.size(); i++) {
			open.push(new Point(shop.get(i).x, shop.get(i).y));
			combination(i+1, cnt+1);
			open.pop();
		}
	}

	public static void chicken() {
		int sum = 0;

		for(int i = 0; i < home.size(); i++) {
			int min = Integer.MAX_VALUE;
			Point curHome = Main.home.get(i);
			for(Point curShop : open) {
				min = Math.min(min, Math.abs(curHome.y - curShop.y) + Math.abs(curHome.x - curShop.x));
			}
			sum += min;
		}

		answer = Math.min(answer, sum);
	}
}
