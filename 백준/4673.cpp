#include <iostream>
using namespace std;

int selfNumber(int i) {
	int num = i;
	while (i != 0) {
		num += i % 10;
		i /= 10;
	}
		
	return num;
}
int main() {
	//입출력 속도 개선(c type IO 사용불가)
	bool array[10001] = { false, };
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	for (int i = 1; i < 10001; i++) {
		int result = selfNumber(i);
		if (result < 10001) array[result] = true;
	}
	for (int i = 1; i < 10001; i++) {
		if (array[i] == false) cout << i << endl;
	}
	return 0;
}