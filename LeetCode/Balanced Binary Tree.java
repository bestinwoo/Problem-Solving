//LeetCode Invert Binary Tree
// Definition for a binary tree node.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//LeetCode Balanced Binary Tree
class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}

		return dfs(root) != -1;
	}

	public int dfs(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int left = dfs(root.left);
		int right = dfs(root.right);

		if(left == -1 || right == -1) {
			return -1;
		}
		if(Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}
