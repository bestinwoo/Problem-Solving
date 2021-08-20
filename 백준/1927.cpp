#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <math.h>
#include <queue>
/*
* 최소 힙
*/
using namespace std;
int heap[100001];
int heap_count = 0;
void push(int x) {
	heap[++heap_count] = x;
	int child = heap_count;
	int parent = child / 2;
	while (child > 1 && heap[child] < heap[parent]) {
		swap(heap[child], heap[parent]);
		child = parent;
		parent = child / 2;
	}
}

int pop() {
	if (heap_count <= 0) return 0;
	//루트 노드 값 저장
	int data = heap[1];
	//루트 노드와 가장 마지막 노드 swap
	swap(heap[1], heap[heap_count]);
	heap_count--;
	//swap해서 루트 노드가 된 노드와 자식 노드들 비교
	int parent = 1;
	int child = parent * 2;
	if (child + 1 <= heap_count)
		child = heap[child] < heap[child + 1] ? child : child + 1;

	while (heap[child] < heap[parent] && child <= heap_count) {
		swap(heap[child], heap[parent]);
		parent = child;
		child = parent * 2;
		if (child + 1 <= heap_count)
			child = heap[child] < heap[child + 1] ? child : child + 1;
	}
	return data;

}
int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		if (x == 0) cout << pop() << '\n';
		else push(x);
	}

	return 0;
}
