#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <set>
#include <math.h>
using namespace std;

string getName() {
	string name;
	cin >> name;
	return name;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	set<string> a;
	set<string> b;
	int n, m;
	int cnt = 0;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		a.insert(getName());
	}
	
	for (int i = 0; i < m; i++) {
		b.insert(getName());
	}
	set<string> c;
	set_intersection(a.begin(), a.end(), b.begin(), b.end(), inserter(c, c.begin()));
	cout << c.size() << '\n';
	for (set<string>::iterator it = c.begin(); it != c.end(); it++) {
		cout << *it << '\n';
	}
	return 0;
}
