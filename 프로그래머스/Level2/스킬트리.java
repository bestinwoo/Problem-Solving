import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String s : skill_trees) {
            //스킬 순서를 체크해줄 배열
            boolean[] check = new boolean[skill.length()];
            for (int i = 0; i < s.length(); i++) {
                if(skill.contains(s.subSequence(i,i+1))) { // skill에 있는 스킬이 있을 경우
                    int index = skill.indexOf(s.charAt(i));
                    check[index] = true;
                    if(index != 0 && check[index-1] == false) { // 전 스킬을 배우지 않았으면 다음 스킬트리로 넘김
                        break;
                    }
                }
                if(i+1 == s.length()) {
                    answer++;
                }
            }
        }
        return answer;
    }
}