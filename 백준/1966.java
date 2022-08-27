import java.io.*;
import java.util.*;
//BOJ 1966 프린터 큐
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			Queue<int[]> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int importance = Integer.parseInt(st.nextToken());
				q.add(new int[]{j, importance});
			}

			while(!q.isEmpty()) {
				int[] poll = q.poll();
				boolean isMax = true;
				for (int[] ele : q) {
					if(ele[1] > poll[1]) {
						//가장 앞 원소보다 큰 원소를 찾았을 경우
						isMax = false;
						break;
					}
				}
				if(isMax) { //꺼낸 원소가 가장 큰 원소일 경우
					cnt++;
					if(poll[0] == m) break; // 찾던 원소면 탐색 종료
				} else {
					q.add(poll);
				}
			}
			System.out.println(cnt);

		}
	}
}

/*
처음 생각했던 것
큐안에 일단 다 푸시를 한다음.


맥스값을 찾아서 저장함.
그리고 하나씩 팝을 하면서 맥스값보다 작으면 다시 넣음
맥스와 같으면 팝을 하고 cnt ++ 하고 맥스를 다시 찾음
반복 (언제까지? max가 m과 같은데 그놈을 찾을 때까지)

문제 : max과 m번째 애랑 같은지 알 수가 없음.

해결 : 큐에 int 배열을 넣음으로서 0번째 원소는 인덱스, 1번째 원소는 중요도로 값을 넣어주면
m과 같은지 찾을 수 있음.
 */
