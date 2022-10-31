//LeetCode Invert Binary Tree
// Definition for a binary tree node.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//LeetCode Binary Search
class Solution {
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}

