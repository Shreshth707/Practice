package trees;

import java.util.ArrayList;

/*
 * Construction
 * isBST
 * Largest Possible BST
 * Path to any Node from Root
 * Print K Down
 * Print K Far
 * Remove
 * Convert to Greater Tree
 * 
 */
public class binarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bst = { 8, 6, 10, 11, 15, 4, 7 };
		Node root = null;
		for (int i = 0; i < bst.length; i++) {
			root = Construction(root, bst, i);
		}
		printInorder(root);
		System.out.println();
		// BSTpair BST = isBST(root);
		// System.out.println(BST.isbst + " " + BST.Lbstsize + " " + BST.Lbstroot.data);
		// printKdown(root, null, 2);
		// printKfar(root, 10, 2);
		// remove(root, 8);
		BSTtoGST(root);
		printInorder(root);

	}

	private static void printInorder(Node root) {
		// TODO Auto-generated method stub
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	static int val = 0;

	static int BSTtoGST(Node node) {
		if (node == null)
			return 0;
		int r = BSTtoGST(node.right);
		val += r + node.data;
		node.data = val;
		int l = BSTtoGST(node.left);
		return l;
	}

	public static Node remove(Node root, int data) {
		if (root == null)
			return null;
		if (data > root.data) {
			root.right = remove(root.right, data);
		} else if (root.data > data) {
			root.left = remove(root.left, data);
		} else {
			if (root.left == null || root.right == null) {
				return root.left == null ? root.right : root.left;
			} else {
				int lmax = max(root.left);
				root.data = lmax;
				root.left = remove(root.left, lmax);
			}
		}
		return root;
	}

	public static int max(Node root) {
		if (root == null)
			return 0;
		else {
			int maxval = max(root.right);
			maxval = Math.max(maxval, root.data);
			return maxval;
		}
	}

	public static Node Construction(Node root, int[] bst, int i) {
		if (i == 0) {
			root = new Node(bst[i]);
			return root;
		}
		if (root.left != null) {
			if (root.data > bst[i]) {
				Construction(root.left, bst, i);
			}
		}
		if (root.right != null) {
			if (root.data < bst[i]) {
				Construction(root.right, bst, i);
			}
		}
		if (root.left == null) {
			if (root.data > bst[i]) {
				root.left = new Node(bst[i]);
			}
		}
		if (root.right == null) {
			if (root.data < bst[i]) {
				root.right = new Node(bst[i]);
			}
		}
		return root;
	}

	static class BSTpair {
		boolean isbst = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Node Lbstroot;
		int Lbstsize = 0;
	}

	static BSTpair isBST(Node root) {
		if (root == null) {
			BSTpair bp = new BSTpair();
			return bp;
		}
		BSTpair lbst = isBST(root.left);
		BSTpair rbst = isBST(root.right);
		BSTpair mp = new BSTpair();
		mp.min = Math.min(root.data, Math.min(lbst.min, rbst.min));
		mp.max = Math.max(root.data, Math.max(lbst.max, rbst.max));
		mp.isbst = lbst.isbst && rbst.isbst && root.data > lbst.max && root.data < rbst.min;
		if (mp.isbst) {
			mp.Lbstroot = root;
			mp.Lbstsize = lbst.Lbstsize + rbst.Lbstsize + 1;
		} else {
			if (lbst.Lbstsize > rbst.Lbstsize) {
				mp.Lbstroot = lbst.Lbstroot;
				mp.Lbstsize = lbst.Lbstsize;
			} else if (lbst.Lbstsize < rbst.Lbstsize) {
				mp.Lbstroot = rbst.Lbstroot;
				mp.Lbstsize = rbst.Lbstsize;
			}
		}
		return mp;
	}

	public static boolean path(Node root, int n, ArrayList<Node> pathN) {
		// TODO Auto-generated method stub
		if (root == null) {
			return false;
		}
		pathN.add(root);

		if (root.data == n) {
			return true;
		}

		if (path(root.left, n, pathN) || path(root.right, n, pathN)) {
			return true;
		}

		pathN.remove(pathN.size() - 1);
		return false;
	}

	public static void printKdown(Node tnode, Node blocker, int k) {
		if (tnode == null || k < 0 || tnode == blocker)
			return;
		if (k == 0) {
			System.out.print(tnode.data + " ");
		}
		printKdown(tnode.left, blocker, k - 1);
		printKdown(tnode.right, blocker, k - 1);

	}

	public static void printKfar(Node root, int data, int k) {
		ArrayList<Node> pathN = new ArrayList<>();
		path(root, data, pathN);
		// for (int i = 0;i<pathN.size();i++) System.out.println(pathN.get(i).data);
		System.out.println();
		printKdown(pathN.get(pathN.size() - 1), null, k);
		int a = 1;
		for (int i = pathN.size() - 2; i >= 0; i--) {
			printKdown(pathN.get(i), pathN.get(pathN.size() - 1), k - a);
			a++;
		}

	}

}
