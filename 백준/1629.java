import java.io.*;
import java.util.*;

public class Main {
	static long a, b, c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());

		System.out.println(pow(b));

	}

	public static long pow(long b) {
		if(b == 0) {
			return 1;
		} else {
			long temp = pow(b / 2);
			temp = temp * temp % c;
			if(b % 2 == 0) {
				return temp;
			} else {
				return a * temp % c;
			}
		}
	}
}
