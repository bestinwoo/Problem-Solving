#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <stack>
using namespace std;

int recursive(int n) {
	if (n == 1) return 1;
	if (n == 2) return 2;
	if (n == 3) return 4;
	
	return recursive(n - 1) + recursive(n - 2) + recursive(n - 3);

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t,n;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> n;
		cout << recursive(n) << '\n';
	}
	
	
	return 0;
}
