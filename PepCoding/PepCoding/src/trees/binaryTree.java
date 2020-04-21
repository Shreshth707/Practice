package trees;

import java.util.ArrayList;
import java.util.Vector;

/* DeleteLeafNode
 * PathBetweenNodes
 * Path from root 
 * Diameter of a Binary Tree O(n*2)
 */

public class binaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = constructor();
		// leafNode(root);
		print(root);
		pathBetweenNodes(root, 60, 30);
		// ArrayList<Integer> path = new ArrayList<>();
		// pathFromRoot(root,path,50);
		// System.out.println(path);
	}

	public static boolean pathFromRoot(Node node, ArrayList<Integer> path, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			path.add(data);
			return true;
		} else {
			boolean lr = pathFromRoot(node.left, path, data);
			if (!lr) {
				boolean rr = pathFromRoot(node.right, path, data);
				if (rr) {
					path.add(node.data);
					return true;
				} else {
					return false;
				}
			} else {
				path.add(node.data);
				return true;
			}
		}
	}

	public static void print(Node root) {
		// TODO Auto-generated method stub
		if (root != null) {
			System.out.print(root.data + " ");
			print(root.left);
			print(root.right);
		}
	}

	public static class Node {
		int data;
		Node left = null;
		Node right = null;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node constructor() {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(50);
		root.left.left = new Node(30);
		root.left.left.right = new Node(40);
		root.left.right.right = new Node(60);
		return root;
	}

	public static boolean leafNode(Node root) {
		if (root.left == null && root.right == null) {
			return true;
		}
		boolean rl = false, rr = false;
		if (root.left != null)
			rl = leafNode(root.left);
		if (root.right != null)
			rr = leafNode(root.right);
		if (rl)
			root.left = null;
		if (rr)
			root.right = null;
		return false;
	}

	public static void pathBetweenNodes(Node root, int n1, int n2) {
		ArrayList<Integer> pathN1 = new ArrayList<>();
		ArrayList<Integer> pathN2 = new ArrayList<>();
		path(root, n1, pathN1);
		path(root, n2, pathN2);
		int intersection = -1;
		int i = 0, j = 0;
		while (i < pathN1.size() && j < pathN2.size()) {
			if (pathN1.get(i) == pathN2.get(j)) {
				i++;
				j++;
			} else {
				break;
			}
		}
		intersection = j - 1;
		for (int a = pathN1.size() - 1; a > intersection; a--) {
			System.out.print(pathN1.get(a) + "->");
		}
		for (int a = intersection; a < pathN2.size(); a++) {
			System.out.print(pathN2.get(a) + "->");
		}

	}

	private static boolean path(Node root, int n, ArrayList<Integer> pathN) {
		// TODO Auto-generated method stub
		if (root == null) {
			return false;
		}
		pathN.add(root.data);

		if (root.data == n) {
			return true;
		}

		if (path(root.left, n, pathN) || path(root.right, n, pathN)) {
			return true;
		}

		pathN.remove(pathN.size() - 1);
		return false;
	}

	/*
	 * DIAMETER OF A BINARY TREE; // maximum distance between any two nodes in the
	 * tree //Euler in Euler public static int diameter(Node node) { if (node ==
	 * null) { return 0; }
	 * 
	 * // if one node lives in left subtree and one node lives in right subtree and
	 * // their distance is maximum int lh = height(node.left); int rh =
	 * height(node.right); int factor = lh + rh + 1;
	 * 
	 * // if both the farthest nodes live in left subtree int ld =
	 * diameter(node.left);
	 * 
	 * // if both the farthest nodes live in right subtree int rd =
	 * diameter(node.right);
	 * 
	 * return Math.max(factor, Math.max(ld, rd)); }
	 */
}
