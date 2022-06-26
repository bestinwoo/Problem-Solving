class Solution {
    int[] results;
    int answer = 0;
    public int solution(int[][] board, int[] moves) {
        results = new int[moves.length];
        for(int move : moves) {
            choice(move - 1, board);
        }
        return answer;
    }

    public void choice(int move, int[][] board) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][move] != 0) {
                addResult(board[i][move]);
                board[i][move] = 0;
                return;
            }
        }
    }

    public void addResult(int doll) {
        for(int i = 0; i < results.length; i++) {
            if(results[i] == 0) {
                results[i] = doll;
                checkDoll();
                return;
            }
        }
    }

    public void checkDoll() {
        for(int i = 1; i < results.length; i++) {
            if(results[i] != 0 && results[i-1] == results[i]) {
                results[i-1] = 0;
                results[i] = 0;
                answer += 2;
                i = 1;
            }
        }
    }
}