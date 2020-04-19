package Practice;

import java.util.Scanner;
import java.util.Stack;

public class constructTreeFromPreorderTraversal {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] pre = new int[n];
		char[] preLN = new char[n];
		for (int i = 0; i < n; i++)
			pre[i] = scan.nextInt();
		for (int i = 0; i < n; i++)
			preLN[i] = scan.next().charAt(0);
		Node root2 = constructTree(n, pre, preLN);
		printInorder(root2);

	}

	private static void printInorder(Node root) {
		// TODO Auto-generated method stub
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	static class Cons {
		Node node;
		char val;

		Cons(int data, char val) {
			this.node = new Node(data);
			this.val = val;
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static Node constructTree(int n, int pre[], char preLN[]) {
		// Add your code here.
		Stack<Cons> stack = new Stack<>();
		Node root = null;
		int i = 0;
		while ((root == null || !stack.isEmpty()) && i != pre.length) {
			if (stack.isEmpty()) {
				Cons bp = new Cons(pre[i], preLN[i]);
				root = bp.node;
				stack.push(bp);

			} else {
				Cons sp = stack.peek();
				if (sp.val == 'N') {
					Cons mp = new Cons(pre[i], preLN[i]);
					if (sp.node.left == null) {
						sp.node.left = mp.node;
						stack.push(mp);

					} else {
						// node.right==null
						sp = stack.pop();
						sp.node.right = mp.node;
						stack.push(mp);

					}
				} else if (sp.val == 'L') {
					stack.pop();
					i--;
				}

			}
			i++;
		}
		return root;

	}
}
