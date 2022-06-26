class Solution {
    public Integer solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        Integer answer = 0;
        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}