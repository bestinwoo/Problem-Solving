#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
bool comp(string a, string b) {
	if (a.length() != b.length()) return a.length() < b.length();
	else return a < b;
}

int main() {
	//입출력 속도 개선(c type IO 사용불가)
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int n;
	string words[20000];
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> words[i];
	}
	sort(words, words + n, comp);
	
	for (int i = 0; i < n; i++) {
		if (words[i] == words[i + 1]) continue;
		cout << words[i] << endl;
	}
	
	return 0;
}
