#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <queue>

using namespace std;
int n, m, v;
bool visited[1001];
bool visit_bfs[1001];

void dfs(vector<int> graph[], int start) {
	cout << start << " ";
	visited[start] = true;
	for (int i = 0; i < graph[start].size(); i++) {
		int x = graph[start][i];
		if (!visited[x]) 
			dfs(graph, x);

	}
}

void bfs(vector<int> graph[], int start) {
	queue<int> q;
	q.push(start);
	visited[start] = true;

	while (!q.empty()) {
		int x = q.front();
		q.pop();
		cout << x << " ";
		for (int i = 0; i < graph[x].size(); i++) {
			int y = graph[x][i];
			if (!visited[y]) {
				q.push(y);
				visited[y] = true;
			}
		}
	}
}
int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	cin >> n >> m >> v;
	vector<int>* graph = new vector<int>[n + 1];
	for (int i = 0; i < m; i++) {
		int head, tail;
		cin >> head >> tail;
		graph[head].push_back(tail);
		graph[tail].push_back(head);
	}
	for (int i = 1; i <= n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	dfs(graph, v);
	cout << "\n";
	
	fill(visited, visited + 1001, 0);
	bfs(graph, v);

	return 0;
}
