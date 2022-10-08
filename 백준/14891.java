import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//BOJ 14891 톱니바퀴
public class Main {
	static Deque<Integer>[] deque = new Deque[4];
	static int k;
	static int[][] rotateWheel;
	static boolean[] visited = new boolean[4];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 4; i++) {
			deque[i] = new ArrayDeque<>();
			char[] chars = br.readLine().toCharArray();
			for (char c : chars) {
				deque[i].addLast(c - '0');
			}
		}
		k = Integer.parseInt(br.readLine());
		rotateWheel = new int[k][2];
		for(int i = 0; i < k; i++) {
			String[] input = br.readLine().split(" ");
			rotateWheel[i][0] = Integer.parseInt(input[0]) - 1;
			rotateWheel[i][1] = Integer.parseInt(input[1]);
		}

		for(int i = 0; i < rotateWheel.length; i++) {
			visited = new boolean[4];
			rotate(rotateWheel[i][0], rotateWheel[i][1]);
		}

		int answer = 0;
		if(deque[0].element() == 1) {
			answer += 1;
		}
		if(deque[1].element() == 1) {
			answer += 2;
		}
		if(deque[2].element() == 1) {
			answer += 4;
		}
		if(deque[3].element() == 1) {
			answer += 8;
		}

		System.out.println(answer);

	}

	public static void rotate(int wheel, int dir) {
		Integer[] cur = deque[wheel].toArray(new Integer[8]);
		visited[wheel] = true;
		if(wheel > 0 && !visited[wheel-1]) {
			Integer preWheelFront = deque[wheel - 1].toArray(new Integer[8])[2];
			if(!preWheelFront.equals(cur[6])) {
				rotate(wheel - 1, dir * -1);
			}
		}
		if(wheel < 3 && !visited[wheel+1]) {
			Integer nextWheelBack = deque[wheel + 1].toArray(new Integer[8])[6];
			if(!nextWheelBack.equals(cur[2])) {
				rotate(wheel + 1, dir * -1);
			}
		}

		if(dir == 1) {
			//시계
			Integer pop = deque[wheel].pollLast();
			deque[wheel].addFirst(pop);
		} else {
			//반시계
			Integer poll = deque[wheel].pollFirst();
			deque[wheel].addLast(poll);
		}
	}

}

