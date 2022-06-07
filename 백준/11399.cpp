#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <stack>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	int p[1000];
	int sum = 0;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> p[i];
	sort(p, p + n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			sum += p[j];
		}
	}

	cout << sum << '\n';
	return 0;
}
