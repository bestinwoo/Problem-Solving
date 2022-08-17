import java.io.*;
import java.util.*;
//BOJ 1753 최단경로
class Node implements Comparable<Node> {
	int v, weight;

	Node(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.weight, o.weight);
	}
}

public class Main {
	static int v,e,k;
	static int[] dist;
	static List<Node>[] adj;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());

		adj = new ArrayList[v+1];
		for(int i = 1; i <= v; i++) {
			adj[i] = new ArrayList<>();
		}

		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;

		for(int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken())].add(
				new Node(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		dijkstra();

		for(int i = 1; i < dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

	}

	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[v+1];
		pq.add(new Node(k, 0));

		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			if(check[poll.v]) continue;
			check[poll.v] = true;

			for (Node next : adj[poll.v]) {
				if(!check[next.v] && dist[next.v] > dist[poll.v] + next.weight) {
					dist[next.v] =  dist[poll.v] + next.weight;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
}

