#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
string blackFirst[8] = {
		{"BWBWBWBW"},
		{"WBWBWBWB"},
		{"BWBWBWBW"},
		{"WBWBWBWB"},
		{"BWBWBWBW"},
		{"WBWBWBWB"},
		{"BWBWBWBW"},
		{"WBWBWBWB"}
};
string whiteFirst[8] = {
	{"WBWBWBWB"},
	{"BWBWBWBW"},
	{"WBWBWBWB"},
	{"BWBWBWBW"},
	{"WBWBWBWB"},
	{"BWBWBWBW"},
	{"WBWBWBWB"},
	{"BWBWBWBW"}
};
string board[50];
int blackFirstCount(int x, int y) {
	int cnt = 0;
	for (int i = x; i < x + 8; i++) {
		for (int j = y; j < y + 8; j++) {
			if (board[i][j] != blackFirst[i - x][j - y]) cnt++;
		}
	}
	return cnt;
}

int whiteFirstCount(int x, int y) {
	int cnt = 0;
	for (int i = x; i < x + 8; i++) {
		for (int j = y; j < y + 8; j++) {
			if (board[i][j] != whiteFirst[i - x][j - y]) cnt++;
		}
	}
	return cnt;
}

int main() {
	//입출력 속도 개선(c type IO 사용불가)
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int m, n;
	//int min = INT32_MAX;
	int minimum = INT32_MAX;
	cin >> n >> m;
	for (int i = 0; i < n; i++) cin >> board[i];
	
	for (int i = 0; i + 7 < n; i++) {
		for (int j = 0; j + 7 < m; j++) {
			int blackCnt = blackFirstCount(i, j);
			int whiteCnt = whiteFirstCount(i, j);
			//if (min > blackCnt) min = blackCnt;
			//if (min > whiteCnt) min = whiteCnt;
			minimum = min(minimum, min(blackCnt,whiteCnt));
		}
	}
	cout << minimum;
	
	return 0;
}
