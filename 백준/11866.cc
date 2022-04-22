#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <math.h>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n,k;
	vector<int> v;
	cin >> n >> k;
	int k1 = k-1;
	for (int i = 1; i <= n; i++) v.push_back(i);
	cout << '<';
	while (!v.empty()) {
		//k1 += k;
		while (k1 >= v.size()) {
			k1 -= v.size();
		}
		cout << v[k1];
		v.erase(v.begin() + (k1));
		if (v.size() > 0) cout << ", ";
		k1 += k-1;
	}
	cout << ">";
	
	return 0;
}
