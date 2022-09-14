#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	//입출력 속도 개선(c type IO 사용불가)
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int testCase;
	cin >> testCase;
	for (int i = 0; i < testCase; i++) {
		int h, w, n;
		cin >> h >> w >> n;
		int a = n - h;
		int row = 2;
		if (a <= 0) {
			cout << to_string(a + h) << "01" << endl;
			continue;
		}
		while (a > 0) {
			a -= h;
			if (a <= 0) {
				if (row > 9) cout << to_string(a + h) << row << endl;
				else cout << to_string(a + h) << "0" << row << endl;
				break;
			}
			row++;
		}
		
	} // 
	return 0;
}
