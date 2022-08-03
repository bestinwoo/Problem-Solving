#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool binarySearch(vector<int> &list, int findNum) {
	int start = 0;
	int end = list.size() - 1;
	

	while (start <= end) {
		int mid = (end + start) / 2;
		if (findNum == list[mid]) return true;
		else if (findNum < list[mid]) end = mid - 1;
		else start = mid + 1;
	}
	return false;
}

void pushVector(vector<int> &v, int n) {
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		v.push_back(x);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	vector<int> v;
	vector<int> v1;
	int n;
	cin >> n;
	pushVector(v, n);
	cin >> n;
	pushVector(v1, n);
	sort(v.begin(), v.end());

	for (int i = 0; i < v1.size(); i++) {
		if (binarySearch(v, v1[i])) cout << '1' << '\n';
		else cout << '0' << '\n';
	}

	return 0;
}
