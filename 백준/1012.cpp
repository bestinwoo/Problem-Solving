#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <stack>
using namespace std;
int visited[50][50] = { 0 };
int arr[50][50] = { 0 };
int t, m, n, k;
int dy[4] = { 1, -1, 0, 0 };
int dx[4] = { 0, 0, 1, -1 };

void dfs(int x, int y) {
	visited[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
			if (arr[ny][nx] && !visited[ny][nx]) dfs(nx, ny);
		}
	}
}

void reset() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			arr[i][j] = 0;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			visited[i][j] = 0;
		}
	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	for (int i = 0; i < t; i++) {
		reset();
		int cnt = 0;
		cin >> m >> n >> k;
		for (int j = 0; j < k; j++) {
			int x, y;
			cin >> x >> y;
			arr[y][x] = 1;
		}

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (arr[y][x] && !visited[y][x]) {
					cnt++;
					dfs(x, y);
				}
			}
		}
		cout << cnt << '\n';
	}
	

	return 0;
}
