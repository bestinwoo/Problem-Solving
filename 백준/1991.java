import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static Tree tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new Tree();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree.createNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
}

class Node {
	char data;
	Node left;
	Node right;

	Node(char data) {
		this.data = data;
	}
}

class Tree {
	public Node root;
	public void createNode(char data, char leftData, char rightData) {
		if(root == null) {
			root = new Node(data);
			if(leftData != '.') {
				root.left = new Node(leftData);
			}
			if(rightData != '.') {
				root.right = new Node(rightData);
			}
		} else {
			searchNode(root, data, leftData, rightData);
		}
	}

	public void searchNode(Node root, char data, char leftData, char rightData) {
		if(root == null) return;
		if(root.data == data) {
			if(leftData != '.') {
				root.left = new Node(leftData);
			}
			if(rightData != '.') {
				root.right = new Node(rightData);
			}
		} else {
			searchNode(root.left, data, leftData, rightData);
			searchNode(root.right, data, leftData, rightData);
		}
	}

	public void preOrder(Node root) {
		if(root == null) return;
		System.out.print(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void inOrder(Node root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.data);
		inOrder(root.right);
	}

	public void postOrder(Node root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data);
	}
}
