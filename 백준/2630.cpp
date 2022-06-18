#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <stack>
using namespace std;
int square[129][129];
int w_cnt = 0, b_cnt = 0;
void solve(int x, int y, int n) {
	int tempCnt = 0;
	for (int i = x; i < x+n; i++) {
		for (int j = y; j < y+n; j++) {
			if (square[i][j] == 1) tempCnt++;
		}
	}
	if (tempCnt == 0) w_cnt++;
	else if (tempCnt == n*n) b_cnt++;
	else {
		solve(x, y, n/2);
		solve(x + n / 2, y, n / 2);
		solve(x, y + n / 2, n / 2);
		solve(x + n / 2, y + n / 2, n / 2);
	}
}



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n; 
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> square[i][j];
		}
	}

	solve(0, 0, n);
	cout << w_cnt << '\n' << b_cnt;

	return 0;
}
