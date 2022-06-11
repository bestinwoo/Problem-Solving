#include <iostream>
using namespace std;

int hansu(int num) {
	// 100 미만의 수는 그 수가 한수의 수임
	if (num < 100) return num;
	if (num == 1000) return 144;
	
	int cnt = 0;
	cnt += 99;
	for (int i = 111; i <= num; i++) {
		int a = i / 100; // 100의 자릿수
		int b = i % 100 / 10; // 10의 자리
		int c = i % 10; // 1 자리
		
		if (a - b == b - c) cnt++;
	}
	
	return cnt;
}

int main() {
	//입출력 속도 개선(c type IO 사용불가)
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	
	int num = 0;
	cin >> num;
	cout << hansu(num) << endl;

	return 0;
}