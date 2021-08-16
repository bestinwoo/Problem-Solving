#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <math.h>
#include <queue>
/*
* 최대 힙 자료구조 
*/
using namespace std;

int n;
// 부모 노드가 자식 노드 index / 2라는 식을 지키기 위해 count는 1부터 시작
int heap_count = 1;
int heap[100001];

void heap_push(int data) {
	heap[++heap_count] = data;
	int child = heap_count;
	int parent = child / 2;
	while (child > 1 && heap[parent] < heap[child]) {
		swap(heap[parent], heap[child]);
		child = parent;
		parent = child / 2;
	}
}


int heap_pop() {
	if (heap_count <= 0) return 0;
	// 최댓값인 첫번째 원소 저장
	int result = heap[1];
	
	//첫번째 원소를 가장 마지막 원소와 바꾸고 heap의 크기 1 감소
	swap(heap[1], heap[heap_count]);
	heap_count--;

	// 첫번째 원소로 올라온 원소를 알맞은 위치로 보냄
	int parent = 1;
	int child = parent * 2;
	if (child + 1 <= heap_count) { // 형제 노드 크기 비교
		child = heap[child] > heap[child + 1] ? child : child + 1;
	}
	while (child <= heap_count && heap[child] > heap[parent]) {
		swap(heap[parent], heap[child]);
		parent = child;
		child *= 2;
		if (child + 1 <= heap_count) {
			child = heap[child] > heap[child + 1] ? child : child + 1;
		}
	}
	return result;
}
int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int oper;
		cin >> oper;
		if (oper == 0) cout << heap_pop() << '\n';
		else {
			heap_push(oper);
		}
	}

	return 0;
}
