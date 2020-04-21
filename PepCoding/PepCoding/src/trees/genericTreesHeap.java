package trees;

import java.util.ArrayList;
import java.util.Stack;

/* Max Value
 * Min Value
 * Preoder Successor 
 * Preorder Prediccessor
 * Find
 * Kth Max Value
 */


public class genericTreesHeap {

	public static class HMpair {
		int prev = -1;
		int predi = -1;
		int succ = -1;
		boolean find = false;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int ceil = Integer.MAX_VALUE;
		int floor = Integer.MIN_VALUE;
	}

	public static class Node {
		int data = 0;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node Constructor(int[] arr) {
		Stack<Node> stack = new Stack<>();
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) {
				root = new Node(arr[i]);
				stack.push(root);
			} else if (!stack.isEmpty()) {
				if (arr[i] != -1) {
					Node node = new Node(arr[i]);
					stack.peek().children.add(node);
					stack.push(node);
				} else if (arr[i] == -1) {
					stack.pop();
				}
			}
		}
		return root;
	}

	public static void MultiPurpose(Node root, HMpair pair, int data) {
		if (pair.find == false && root.data == data) {
			pair.find = true;
			pair.predi = pair.prev;
		}
		if (pair.find == true && pair.prev == data) {
			pair.succ = root.data;
		}
		if (root.data > data) {
			pair.ceil = Integer.min(pair.ceil, root.data);
		}
		if (root.data < data) {
			pair.floor = Integer.max(pair.floor, root.data);
		}

		pair.max = Math.max(pair.max, root.data);
		pair.min = Math.min(pair.min, root.data);
		pair.prev = root.data;
		for (Node child : root.children) {
			MultiPurpose(child, pair, data);
		}

	}
	public static void KthLargest(Node root,int k,HMpair pair) {
		int ans = Integer.MAX_VALUE;
		for (int i = 0;i<k;i++) {
			MultiPurpose(root,pair,ans);
			ans = pair.floor;
			pair.floor = Integer.MIN_VALUE;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 40, -1, 50, -1, -1, 30, -1, -1 };
		Node root = Constructor(arr);
		HMpair pair = new HMpair();
		MultiPurpose(root, pair, 10);
		System.out.println(pair.predi + " " + pair.succ);
		KthLargest(root,3,pair);
	}

}
