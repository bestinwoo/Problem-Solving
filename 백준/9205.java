import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int t, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		String[] result = new String[t];

		for(int i =0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			ArrayList<Node> nodes = new ArrayList<>();

			for(int j = 0; j < n+2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				nodes.add(new Node(x,y));
				adj.add(new ArrayList<>());
			}

			for(int j =0 ; j < n+2; j++) {
				for(int k = j+1; k < n+2; k++) {
					//맨해튼 거리
					int x = Math.abs(nodes.get(j).x - nodes.get(k).x);
					int y = Math.abs(nodes.get(j).y - nodes.get(k).y);
					int distance = x + y;
					if(distance <= 1000) {
						adj.get(j).add(k);
						adj.get(k).add(j);
					}
				}
			}

			result[i] = bfs(adj) ? "happy" : "sad";

		}
		for (String s : result) {
			System.out.println(s);
		}
	}

	public static boolean bfs(ArrayList<ArrayList<Integer>> adj) {
		//집에서부터 출발
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		boolean[] visited = new boolean[n+2];
		visited[0] = true;
		while(!q.isEmpty()) {
			Integer cur = q.poll();
			//현재 위치에서 갈 수 있는 곳 탐색
			for (Integer next : adj.get(cur)) {
				//그곳이 락 페스티벌장이면 종료
				if(next == n+1) {
					return true;
				}
				//방문하지 않은 곳이면 이동
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		//방문할 수 있는 모든 장소 방문했는데 축제장 도착 못했으면 실패
		return false;
	}
}
