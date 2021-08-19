#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <math.h>
#include <queue>
/*
* 분할 정복을 이용한 2차원 배열에서 해당 좌표 찾기
*/
using namespace std;

int n, r, c;
int cnt;
void divide(int x, int y, int n) {
	if (x == c && r == y) {
		cout << cnt;
		return;
	}
	if (x + n <= c || y + n <= r || r < y || c < x) {
		cnt += n * n;
		return;
	}
	else {
		divide(x, y, n / 2);
		divide(x + n / 2, y, n / 2);
		divide(x, y + n / 2, n / 2);
		divide(x + n / 2, y + n / 2, n / 2);
	}
}

int main(void)
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> n >> r >> c;
	divide(0, 0, (1 << n)); // 1 << n 비트연산을 하면 2의n승이 된다.
	
	return 0;
}
