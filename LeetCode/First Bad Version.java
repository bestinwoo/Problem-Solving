//LeetCode First Bad Version
class Solution {
	public int firstBadVersion(int n) {
		int start = 1;
		int end = n;
		while(start <= end) {
			int mid = (start + end) >>> 1;
			boolean isBad = isBadVersion(mid);
			if(isBad) {
				if(!isBadVersion(mid - 1)) {
					return mid;
				}
				end = mid - 1;
			} else {
				if(isBadVersion(mid + 1)) {
					return mid + 1;
				}
				start = mid + 1;
			}
		}
		return -1;
	}
}
