#include <iostream>
#include <string>
using namespace std;

int main() {
	int range;
	int cnt = 0;
	cin >> range;
	
	for (int i = 0; i < range; i++) {
		string word;
		cin >> word;
		if (word.size() == 1) {
			cnt++;
			continue;
		}
		for (int j = 0; j < word.size(); j++) {
			bool group = true;
			for (int k = j+1; k < word.size(); k++) {
				if (word[j] == word[k] && word[k - 1] != word[k]) {
					group = false;
					break;
				}
			}
			if (!group) {
				break;
			}
			else if (group && j == word.size() - 1) cnt++;
		}
	}
	cout << cnt;
	return 0;
}