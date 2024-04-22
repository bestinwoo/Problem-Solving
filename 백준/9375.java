import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//BOJ 9375 패션왕 신해빈(S3)
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int result = 1;
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				String[] clothes = br.readLine().split(" ");
				map.put(clothes[1], map.getOrDefault(clothes[1], 0) + 1);
			}

			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				result *= (entry.getValue() + 1);
			}
			System.out.println(result - 1);
		}
	}
}