#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <math.h>
#include <unordered_map>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	unordered_map<string, int> um;
	string name[100001];
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> name[i];
		um[name[i]] = i+1;
	}

	for (int i = 0; i < m; i++) {
		string keyword;
		cin >> keyword;
		try {
			int num = stoi(keyword);
			cout << name[num - 1] << '\n';
		}
		catch (invalid_argument) {
			cout << um[keyword] << '\n';
		}

	}
	return 0;
}
