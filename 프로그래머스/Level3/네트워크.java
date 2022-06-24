class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int[][] computers, int x, boolean[] visited) {
        if(visited[x]) return;
        visited[x] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[x][i] == 1) {
                dfs(computers, i, visited);
            }
        }
    }
}