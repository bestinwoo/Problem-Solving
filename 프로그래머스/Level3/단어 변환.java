class Solution {
    int answer = 50;
    boolean[] visited;
    public boolean diff(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        if(cnt == 1) return true;
        return false;
    }

    public void dfs(String begin, String target, String[] words, int step) {
        if(step >= answer) return;

        if(target.equals(begin)) {
            answer = Math.min(answer, step);
            return;
        }
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && diff(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, step + 1);
                //백트래킹을 위해 방문기록 삭제
                visited[i] = false;
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        if(answer == 50) return 0;
        return answer;
    }
}