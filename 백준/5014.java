import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy;
	static int f,s,g,u,d;
	static int result = 0;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		dy = new int[]{u,-d};
		visited = new int[f+1];
		bfs();
		if(visited[g] != -1) {
			System.out.println(visited[g]);
		} else {
			System.out.println("use the stairs");
		}
	}

	public static void bfs() {
		if(s == g){
			visited[g] = 0;
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = 0;
		while(!q.isEmpty()) {
			Integer poll = q.poll();
			if(poll == g) return;
			for(int i = 0; i < 2; i++) {
				int newFloor = poll + dy[i];
				if(newFloor < 1 || newFloor > f) continue;
				if(visited[newFloor] == 0 && newFloor != s) {
					visited[newFloor] = visited[poll] + 1;
					q.add(newFloor);
				}
			}
		}
		visited[g] = -1;
	}

}
