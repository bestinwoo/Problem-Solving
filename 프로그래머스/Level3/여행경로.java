import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    boolean[] visited = new boolean[10001];
    ArrayList<String> routes = new ArrayList<>();
    public void dfs(String start, String route, String[][] tickets, int cnt) {
        if(cnt == tickets.length) {
            routes.add(route);
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], route + "," + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        dfs("ICN", "ICN", tickets, 0);
        routes.sort(Comparator.naturalOrder());

        answer = routes.get(0).split(",");
        return answer;
    }
}