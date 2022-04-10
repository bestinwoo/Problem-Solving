import java.util.*;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, List<String>> reported = new HashMap<>();
        LinkedHashMap<String, Long> getMailCnt = new LinkedHashMap<>();



        for (String s : report) {
            String[] splitStr = s.split(" ");
            if(reported.get(splitStr[1]) == null) {
                reported.put(splitStr[1], new ArrayList(List.of(splitStr[0])));
            }
            else if(!reported.get(splitStr[1]).contains(splitStr[0])) {
               reported.get(splitStr[1]).add(splitStr[0]);
           }
        }

        System.out.println("reported = " + reported);

        for (String s : id_list) {

            if(!getMailCnt.containsKey(s)) {
                getMailCnt.put(s, 0L);

            }
        }

        for (String s : id_list) {
            if(reported.containsKey(s) && reported.get(s).size() >= k) {
                for (String s1 : reported.get(s)) {
                    getMailCnt.put(s1, getMailCnt.get(s1) + 1);
                }
            }
        }

        System.out.println("getMailCnt = " + getMailCnt.values());
        int i = 0;
        for (Long value : getMailCnt.values()) {
            answer[i++] += value;

        }
        //1. 신고목록 취합해서 아이디별로 신고당한 횟수 카운트
        //2. 정지당한(k <= 신고당한 횟수) 아이디 배열로
        //3. 신고한 애들 처리결과 메일 개수

        return answer;
    }
}