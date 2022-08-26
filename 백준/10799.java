import java.io.*;
import java.util.*;
//BOJ 10799 쇠막대기
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				stack.push(c);
			} else if(c == ')') {
				stack.pop();
				if(str.charAt(i-1) == ')') {
					//막대기가 끝난경우
					result += 1;
				} else {
					//레이저인 경우
					result += stack.size();
				}
			}
		}
		System.out.println(result);
	}
}

