#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
#include <queue>
/*
* 그리디 알고리즘을 적용하여 회의 종료시간을 오름차순으로 정렬 후 회의 시작 시간이 전 회의 종료시간보다 클경우
* 회의의 수 증가
*/
using namespace std;

struct meet {
	int s_time, e_time;
};
bool compare(meet a, meet b) {
	if (a.e_time == b.e_time) return a.s_time < b.s_time;
	return a.e_time < b.e_time;
}

int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	vector<meet> v;
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		int s, e;
		cin >> s >> e;
		v.push_back({ s, e });
	}

	sort(v.begin(), v.end(), compare);
	int preS = 0, preE = 0, cnt = 0;
	for (int i = 0; i < v.size(); i++) {
		if (v[i].s_time >= preE) {
			preS = v[i].s_time;
			preE = v[i].e_time;
			cnt++;
		}
	}
	cout << cnt;
	return 0;
}
