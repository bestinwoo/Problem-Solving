//LeetCode Invert Binary Tree
// Definition for a binary tree node.

class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;

		if (root.left != null || root.right != null) {
			invertTree(root.left);
			invertTree(root.right);
		}

		return root;
	}
}

