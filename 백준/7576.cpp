#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <queue>
#define MAX 1001
using namespace std;
struct pos {
	int x, y;
};
int n, m;
int box[MAX][MAX];
int posX[4] = { -1, 0, 1, 0 };
int posY[4] = { 0, 1, 0, -1 };
queue<pos> q;

void bfs() {
	while (!q.empty()) {
		int x = q.front().x;
		int y = q.front().y;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + posX[i];
			int ny = y + posY[i];
			if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
			if (box[ny][nx]) continue; // 안익은 토마토만
			box[ny][nx] = box[y][x] + 1;
			q.push({ nx, ny });
		}
	}
}

// 상자를 확인해서 안익은 토마토가 있으면 -1, 모두 익었을 경우 가장 큰 값(1부터 시작했으므로 값에서 -1) 리턴
int tomato() {
	int max = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (box[i][j] == 0) return -1;
			else max = max > box[i][j] ? max : box[i][j];
		}
	}
	return max - 1;
}
int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	for (int i = 0; i < MAX; i++) for (int j = 0; j < MAX; j++) box[i][j] = 0;
	cin >> m >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> box[i][j];
			if (box[i][j] == 1) q.push({ j,i });
		}
	}
	bfs();

	cout << tomato();
	return 0;
}
