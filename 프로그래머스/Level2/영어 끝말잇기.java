import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> a = new ArrayList<>();
        //첫 단어 리스트에 저장
        a.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            //num : 번호 , index: 차례
            int num = i % n + 1;
            int index = i / n + 1;
            String lastWord = a.get(i-1); // 마지막 단어
            //이미 선언되어 리스트에 포함된 단어나 마지막 단어의 마지막 글자와 첫 글자가 동일하지 않은 경우 끝말잇기 종료
            if(!a.contains(words[i]) && words[i].startsWith(lastWord.substring(lastWord.length() - 1))) {
                a.add(words[i]);
            } else {
                answer[0] = num;
                answer[1] = index;
                break;
            }
        }
        return answer;
    }
}