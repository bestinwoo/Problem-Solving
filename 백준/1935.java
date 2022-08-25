import java.io.*;
import java.util.*;
//BOJ 1935 후위 표기식2
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Double> st = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '+' || c == '-' || c == '*' || c == '/') {
				Double oper2 = st.pop();
				Double oper1 = st.pop();
				switch (c) {
					case '+':
						st.add(oper1 + oper2);
						break;
					case '-':
						st.add(oper1 - oper2);
						break;
					case '*':
						st.add(oper1 * oper2);
						break;
					case '/':
						st.add(oper1 / oper2);
						break;
				}
			} else {
				double operand = arr[c - 'A'];
				st.add(operand);
			}
		}
		System.out.printf("%.2f", st.pop());
	}
}

