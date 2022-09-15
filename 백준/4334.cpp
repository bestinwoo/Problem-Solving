#include <iostream>
#include <string>
using namespace std;
int main() {
	//입출력 속도 개선(c type IO 사용불가)
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int c;
	cin >> c;
	for (int i = 0; i < c; i++) {
			int personnel = 0, sum = 0, highman = 0;
			cin >> personnel;
			int* scores = new int[personnel];

			for (int j = 0; j < personnel; j++) {
				cin >> scores[j];
				sum += scores[j];
			}
			double avg = double(sum) / personnel;
			for (int j = 0; j < personnel; j++) if (scores[j] > avg) highman++;
			cout << fixed;
			cout.precision(3);
			cout << highman / double(personnel) * 100 << "%" << endl;

	} 

	return 0;
}