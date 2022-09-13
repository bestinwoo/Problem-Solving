import java.io.BufferedReader;
import java.io.InputStreamReader;

//BOJ 16987 계란으로 계란치기
public class Main {
	public static class Egg {
		int s;
		int w;
		Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}
	static int result = 0;
	static int n;
	static Egg[] eggs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		if(n == 1) {
			System.out.println("0");
			return;
		}

		eggs = new Egg[n];
		for(int i = 0; i < n; i++) {
			String[] egg = br.readLine().split(" ");
			eggs[i] = new Egg(Integer.parseInt(egg[0]), Integer.parseInt(egg[1]));
		}
		attack(0);
		System.out.println(result);
	}

	public static void attack(int cur) {
		if(cur >= n) {
			int cnt = 0;
			for (Egg egg : eggs) {
				if(egg.s <= 0) cnt++;
			}
			result = Math.max(result, cnt);
			return;
		}
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			if(i == cur) continue;
			if(eggs[cur].s > 0 && eggs[i].s > 0) {
				flag = true;
				eggs[cur].s -= eggs[i].w;
				eggs[i].s -= eggs[cur].w;
				attack(cur+1);
				eggs[cur].s += eggs[i].w;
				eggs[i].s += eggs[cur].w;
			}
		}
		if(!flag) attack(cur + 1);
	}


}

