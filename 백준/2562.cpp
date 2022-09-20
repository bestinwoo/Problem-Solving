#include <iostream>
using namespace std;
int main() {
	//입출력 속도 개선(c type IO 사용불가)
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int arr[9], index = 0, max = 0;
	for (int i = 0; i < 9; i++) {
		cin >> arr[i];
		if (max < arr[i]) {
			max = arr[i];
			index = i + 1;
		}
	}
	cout << max << '\n' << index;

	return 0;
}