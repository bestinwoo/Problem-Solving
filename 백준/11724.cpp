#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <queue>
#define MAX 1001
/*
* DFS를 이용한 연결 요소 찾기
*/
int n, m;
bool visited[MAX];
using namespace std;

void dfs(vector<int> graph[], int x) {
	visited[x] = true;
	for (int i = 0; i < graph[x].size(); i++) {
		int next = graph[x][i];
		if (!visited[next]) dfs(graph, next);
	}
}

int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> n >> m; // 정점, 간선 개수
	vector<int>* graph = new vector<int>[n + 1];
	int components = 0; // 연결 요소
	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}
	

	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			dfs(graph, i);
			components++;
		}
	}
	cout << components;
	return 0;
}
