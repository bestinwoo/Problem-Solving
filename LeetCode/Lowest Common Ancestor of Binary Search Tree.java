//LeetCode Lowest Common Ancestor of Binary Search Tree
class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(q.val == root.val || p.val == root.val) {
			return root;
		}
		if(q.val > root.val && p.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if(q.val < root.val && p.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}
}
