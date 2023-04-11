import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ 1676 팩토리얼 0의 개수 (S5)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println((n/5)+(n/25)+(n/125));
	}
}
