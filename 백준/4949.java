import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//BOJ 4949 균형잡힌 세상 (S4)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;

		while(!(input = br.readLine()).equals(".")) {
			Stack<Character> stack = new Stack<>();
			String result = "";
			for (char aChar : input.toCharArray()) {
				if(aChar == '(' || aChar == '[') stack.push(aChar);
				else if (aChar == ')' && (stack.isEmpty() || stack.pop() != '(')) result = "no";
				else if (aChar == ']' && (stack.isEmpty() || stack.pop() != '[')) result = "no";
			}
			System.out.println(stack.isEmpty() && result.isEmpty() ? "yes" : "no");
		}
	}

}
