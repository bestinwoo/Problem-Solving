import java.io.*;
import java.util.*;
//BOJ 2346 풍선 터뜨리기
public class Main {
	public static void main(String[] args) throws Exception {
		Deque<int[]> deque = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 1; i <= n; i++) {
			deque.add(new int[]{i, sc.nextInt()});
		}
		int[] first = deque.pollFirst();
		System.out.print(first[0]);
		while(!deque.isEmpty()) {
			if(first[1] > 0) {
				for(int i = 1; i < first[1]; i++) {
					int[] poll = deque.pollFirst();
					deque.addLast(poll);
				}
				first = deque.poll();

			} else {
				for(int i = 1; i < Math.abs(first[1]); i++) {
					int[] poll = deque.pollLast();
					deque.addFirst(poll);
				}
				first = deque.pollLast();
			}
			System.out.print(" " + first[0]);
		}


	}
}

