import java.util.HashSet;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        combination(numbers, "");
        int answer = 0;
        for (Integer num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    //문자열을 재귀함수를 이용해 모든 가능한 수열로 변경
    private void combination(String num, String comb) {
        if(!comb.equals("")) {
            set.add(Integer.valueOf(comb));
        }

        for (int i = 0; i < num.length(); i++) {
            combination(num.substring(0, i) + num.substring(i + 1, num.length()), comb + num.charAt(i));
        }
    }
    //소수 판별
    //판별할 수의 제곱근까지만 확인하면 된다.
    private boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;

        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}