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
	int dp[1000001] = {1, 1,};
	cin >> n;
	for (int i = 2; i <= n; i++) {
		dp[i] = (dp[i-1] + dp[i-2]) % 10007;
	}

	cout << dp[n];

	return 0;
}