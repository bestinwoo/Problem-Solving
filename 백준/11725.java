import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parents = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		for(int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			adj.get(node1).add(node2);
			adj.get(node2).add(node1);
		}

		bfs(1);

		for(int i = 2; i < parents.length; i++) {
			System.out.println(parents[i]);
		}
	}

	public static void bfs(int root) {
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		parents[root] = root;
		while(!q.isEmpty()) {
			Integer poll = q.poll();
			for (Integer child : adj.get(poll)) {
				if(parents[child] == 0) {
					parents[child] = poll;
					q.add(child);
				}
			}
		}
	}
}
