#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <math.h>
#include <queue>
/*
* BFS를 이용한 최단 경로 찾기
*/
using namespace std;
int visited[100001];
int n, k;
void bfs() {
	queue<int> q;
	q.push(n);
	visited[n]++;

	while (!q.empty()) {
		int x = q.front();
		q.pop();
		if (x == k) cout << visited[x] - 1 << '\n';
		if (x - 1 >= 0 && !visited[x - 1]) {
			q.push(x - 1);
			visited[x - 1] = visited[x] + 1;
		}

		if (x + 1 < 100001 && !visited[x + 1]) {
			q.push(x + 1);
			visited[x + 1] = visited[x] + 1;
		}

		if (x * 2 < 100001 && !visited[x * 2]) {
			q.push(x * 2);
			visited[x * 2] = visited[x] + 1;
		}
		
	}
}

int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> n >> k;
	bfs();
	

	return 0;
}
