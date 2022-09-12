import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//BOJ 1759 암호 만들기
public class Main {
	static int l,c;
	static char[] selected, arr;
	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		l = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		sb = new StringBuilder();
		arr = new char[c];
		selected = new char[l];
		visited = new boolean[c];
		String str = br.readLine().replace(" ", "");
		for (int i = 0; i < c; i++) {
			arr[i] = str.charAt(i);
		}
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);

	}

	public static void dfs(int index, int cnt) {
		if(cnt == l) {
			StringBuilder temp = new StringBuilder();
			int vowel = 0;
			int consonant = 0;
			for(int i = 0; i < l; i++) {
				temp.append(selected[i]);
				if(checkVowels(selected[i])) {
					vowel++;
				} else {
					consonant++;
				}
			}
			temp.append('\n');
			if(vowel > 0 && consonant > 1) {
				sb.append(temp);
			}
			return;
		}

		for(int i = index; i < c; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[cnt] = arr[i];
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static boolean checkVowels(char c) {
		for (char vowel : vowels) {
			if(vowel == c) return true;
		}
		return false;
	}
}

