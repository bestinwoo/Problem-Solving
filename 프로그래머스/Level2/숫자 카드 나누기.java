import java.util.ArrayList;
import java.util.Arrays;

//프로그래머스 숫자 카드 나누기
// 1. 카드 뭉치의 모든 공약수 구하기
// 2. 반대쪽 카드 뭉치가 모두 안나눠지는지 확인
class Solution {
	ArrayList<Integer> divisor1 = new ArrayList<>();
	ArrayList<Integer> divisor2 = new ArrayList<>();

	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		for(int i = 2; i <= arrayA[0]; i++) {
			if(arrayA[0] % i == 0) {
				divisor1.add(i);
			}
		}

		for(int i = 2; i <= arrayB[0]; i++) {
			if(arrayB[0] % i == 0) {
				divisor2.add(i);
			}
		}

		for(int i = 1; i < arrayA.length; i++) {
			getDivisors(arrayA[i], divisor1);
			getDivisors(arrayB[i], divisor2);
		}

		answer = getAnswer(arrayB, answer, divisor1, divisor2);
		answer = getAnswer(arrayA, answer, divisor2, divisor1);

		return answer;
	}

	private int getAnswer(int[] array, int answer, ArrayList<Integer> divisor2, ArrayList<Integer> divisor1) {
		for (Integer divisor : divisor2) {
			boolean flag = false;
			for (int operand : array) {
				if(operand % divisor == 0 || divisor1.contains(divisor)) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				answer = Math.max(divisor, answer);
			}
		}
		return answer;
	}

	public void getDivisors(int operand, ArrayList<Integer> list) {
		list.removeIf(i -> operand % i != 0);
	}
}
