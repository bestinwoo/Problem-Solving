import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 14888 연산자 끼워넣기 (실버 1)
public class Main {
	static int n;
	static int[] nums;
	static int[] operandCnt;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		operandCnt = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		String[] oper = br.readLine().split(" ");
		operandCnt[0] = Integer.parseInt(oper[0]); // +
		operandCnt[1] = Integer.parseInt(oper[1]); // -
		operandCnt[2] = Integer.parseInt(oper[2]); // *
		operandCnt[3] = Integer.parseInt(oper[3]); // /

		comb(0, nums[0]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void comb(int cnt, int sum) {
		if(cnt == n-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		if(operandCnt[0] > 0) {
			operandCnt[0]--;
			comb(cnt + 1, sum + nums[cnt+1]);
			operandCnt[0]++;
		}
		if(operandCnt[1] > 0) {
			operandCnt[1]--;
			comb(cnt + 1, sum - nums[cnt+1]);
			operandCnt[1]++;
		}
		if(operandCnt[2] > 0) {
			operandCnt[2]--;
			comb(cnt + 1, sum * nums[cnt+1]);
			operandCnt[2]++;
		}
		if(operandCnt[3] > 0) {
			operandCnt[3]--;
			comb(cnt + 1, sum / nums[cnt+1]);
			operandCnt[3]++;
		}
	}
}
