#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <math.h>
#include <queue>
/*
* 분류 : 브루트포스 알고리즘
* i를 666부터 차례로 증가시켜 666이 포함될 때마다 cnt를 더해주고
* cnt와 n이 같아지면 값을 출력
*/
using namespace std;

int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n, cnt = 0, i;
	cin >> n;

	for (i = 666;;i++) {
		string s = to_string(i);
		if (s.find("666") != string::npos) cnt++;
		if (cnt == n) {
			cout << i;
			break;
		}
	}
	return 0;
}
