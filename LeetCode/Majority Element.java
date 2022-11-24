import java.util.Stack;
//LeetCode Majority Element
//Boyer-Moore 과반수 투표 알고리즘 사용
class Solution {
	public int majorityElement(int[] nums) {
		int major = nums[0];
		int count = 0;
		for (int num : nums) {
			if(num == major) {
				count++;
			} else {
				count--;
			}

			if(count <= 0) {
				major = num;
				count = 1;
			}
		}
		return major;
	}
}
