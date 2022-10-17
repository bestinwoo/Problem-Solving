import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 13335 트럭 (실버 1)
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); // 트럭의 수
		int w = Integer.parseInt(input[1]); // 다리의 길이
		int L = Integer.parseInt(input[2]);  // 다리의 최대하중
		int answer = 0;
		Queue<Integer> wait = new LinkedList<>(); // 트럭 무게
		Queue<Integer> bridge = new LinkedList<>();
		int currentWeight = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int weight = Integer.parseInt(st.nextToken());
			wait.add(weight);
		}

		while(true) {
			answer++;
			if(!bridge.isEmpty() && bridge.size() == w) {
				Integer weight = bridge.poll();
				currentWeight -= weight;
			}

			if(wait.isEmpty() && currentWeight == 0) break;

			if (!wait.isEmpty() && wait.element() + currentWeight <= L) {
				Integer weight = wait.poll();
				bridge.add(weight);
				currentWeight += weight;
			} else {
				bridge.add(0);
			}
		}
		System.out.println(answer);
	}

}

