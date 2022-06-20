#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
using namespace std;

bool visited[101] = {};

void dfs(vector<int> graph[], int x) {
	visited[x] = true;
	for (int i = 0; i < graph[x].size(); i++) {
		int y = graph[x][i];
		if (!visited[y]) dfs(graph, y);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m; // 컴퓨터 수, 컴퓨터 쌍의 수
	int cnt = 0;

	cin >> n >> m;
	vector<int>* graph = new vector<int>[n + 1];
	
	for (int i = 0; i < m; i++) {
		int head, tail;
		cin >> head >> tail;
		graph[head].push_back(tail);
		graph[tail].push_back(head);
	}
	// 하나의 정점에서 다음 정점을 탐색할 때 node 값에 순차적으로 접근하기 위해 정렬
	for (int i = 1; i <= n; i++) sort(graph[i].begin(), graph[i].end());
	
	dfs(graph, 1);
	for (int i = 2; i <= n; i++) {
		if (visited[i]) cnt++;
	}
	cout << cnt;
	return 0;
}
