import java.util.Scanner;

public class Main {
	static int N;
	static int[] visited;
	static int[][] paths;
	static int[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[N][N];
		paths = new int[N][N];
		visited = new int[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			dfs(i);
			for (int j = 0; j < N; j++) {
				paths[i][j] = visited[j];
				visited[j] = 0;
			}
		}

		for (int[] vis : paths) {
			for (int vi : vis) {
				System.out.print(vi + " ");
			}
			System.out.println();
		}
	}

	public static void dfs(int y) {
		for (int i = 0; i < N; i++) {
			if (visited[i] == 0 && graph[y][i] == 1) {
				visited[i] = 1;
				dfs(i);
			}
		}
	}
}
