#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
#include <queue>
/*
* 좌표의 범위가 넓을 때, 오름차순으로 정렬 후 중복을 제거한 인덱스 vector에서
* 해당 좌표의 값을 이진 탐색(lower_bound)하여 몇번 째 인덱스인지 출력
*/
using namespace std;

int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	vector<int> v(n);
	vector<int> idx(n);
	for (int i = 0; i < n; i++) {
		cin >> idx[i];
		v[i] = idx[i];
	}
	sort(idx.begin(), idx.end());
	idx.erase(unique(idx.begin(), idx.end()), idx.end());
	for (auto c : v) {
		cout << lower_bound(idx.begin(), idx.end(), c) - idx.begin() << ' ';
	}
	return 0;
}
