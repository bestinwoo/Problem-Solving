import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        Map<String, Integer> songMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            songMap.put(genres[i], songMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> entries = songMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList());

        ArrayList<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            Map<Integer, Integer> playMap = new LinkedHashMap<>();
            for(int i = 0; i < genres.length; i++) {
                if(entry.getKey().equals(genres[i])) {
                    playMap.put(i, plays[i]);
                }
            }
            List<Map.Entry<Integer, Integer>> genreEntries = playMap.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toList());

            answer.add(genreEntries.get(0).getKey());
            if(genreEntries.size() > 1) {
                answer.add(genreEntries.get(1).getKey());
            }
        }

        return answer;
    }
}
