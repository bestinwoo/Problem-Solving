import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 11659 구간 합 구하기 4 (S3)

/**
 * 크기가 N인 정수 배열 A에서 구간 l, r이 주어졌을 때 구간의 합을 구하는 방법
 * 배열이 변하지 않으니 구간의 합도 변하지 않는다. 따라서 앞에서부터 누적된 합을 구해놓고 이를 이용해서 구간의 합을 구할 수 있다.
 * S[i] = A[1] + ... + A[i], S[0] = 0이라고 정의할 때
 * l번째 수부터 r번째 수까지의 합은 S[r] - S[l-1]과 같다.
 * 그 이유는 S[r] = A[1] ... + A[r], S[l-1] = A[1] + ... + A[l-1] 따라서 S[r] - S[l-1] = A[l] + ... A[r]이 된다.
 * 구간의 합을 구하기 위해서 뺄셈 연산 한번이면 되니 시간 복잡도가 O(1), 연산을 총 M번 수행해야 하니 총 시간 복잡도가 O(M)이 된다.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		int n,m;
		int[] nums, sum;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		nums = new int[n+1];
		sum = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		nums[1] = Integer.parseInt(st.nextToken());
		sum[1] = nums[1];

		for(int i = 2; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + nums[i];
		}

		for(int k = 0; k < m; k++) {
			String[] section = br.readLine().split(" ");
			int i = Integer.parseInt(section[0]);
			int j = Integer.parseInt(section[1]);
			System.out.println(sum[j] - sum[i-1]);
		}
	}


}
