#include <iostream>
#include <algorithm>
using namespace std;
long long fibo[50] = { 0, 1, };
long long fibonacci(int n) {
	if (n <= 1) return fibo[n];
	else if(fibo[n] == 0){
		fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
	}
	return fibo[n];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		if (x == 0)
			cout << "1 0" << '\n';
		else 
			cout << fibonacci(x - 1) << ' ' << fibonacci(x) << '\n';
	}

	return 0;
}
