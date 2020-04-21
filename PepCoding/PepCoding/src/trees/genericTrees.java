package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/* Construction
 * Display
 * Minimum value
 * Maximum value
 * Finding value
 * Height
 * Size(No. of Nodes)
 * Least Common Ancestor
 * Level Order
 */

public class genericTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
		Node root = constructor(arr);
		display(root);
		System.out.println(minval(root));
		System.out.println(maxval(root));
		int findval = 30;
		if (find(root, findval)) {
			System.out.println("True");
		} else
			System.out.println("False");
		System.out.println(height(root));
		System.out.println(size(root));
		System.out.println(leastCommonAncestor(root, 40, 50));
		levelOrder(root);
		preSuccPreorder(root, 20);

	}

	public static class Node {
		int data = 0;
		ArrayList<Node> child = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}

	}

	public static Node constructor(int[] arr) {
		Stack<Node> stack = new Stack<>();
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) {
				root = new Node(arr[i]);
				stack.push(root);
			} else {
				if (arr[i] != -1) {
					Node node = new Node(arr[i]);
					stack.peek().child.add(node);
					stack.push(node);
				} else {
					stack.pop();
				}
			}
		}
		return root;
	}

	public static void display(Node root) {
		System.out.print(root.data + "->");
		for (Node child : root.child) {
			System.out.print(child.data + " ");
		}
		System.out.println();
		for (Node child : root.child) {
			display(child);
		}
	}

	public static int minval(Node root) {
		int minoverall = root.data;
		for (Node child : root.child) {
			minoverall = Math.min((int) minoverall, (int) minval(child));
		}
		return minoverall;
	}

	public static int maxval(Node root) {
		int maxoverall = root.data;
		for (Node child : root.child) {
			maxoverall = Math.max((int) maxoverall, (int) maxval(child));
		}
		return maxoverall;
	}

	public static boolean find(Node root, int data) {
		if (root.data == data) {
			return true;
		} else {
			for (Node child : root.child) {
				boolean res = find(child, data);
				if (res) {
					return true;
				}
			}
		}
		return false;
	}

	public static int height(Node root) {
		int h = -1;
		for (Node child : root.child) {
			int recans = height(child);
			h = Math.max(h, recans);
		}
		return h + 1;
	}

	public static int size(Node root) {
		int count = 1;
		for (Node child : root.child) {
			count += size(child);
		}
		return count;
	}

	public static int leastCommonAncestor(Node root, int a, int b) {
		Stack<Node> stack_a = new Stack<>();
		Stack<Node> stack_b = new Stack<>();
		boolean f_a = find_a(a, stack_a, root);
		boolean f_b = find_a(b, stack_b, root);
		while (!stack_a.isEmpty() && !stack_b.isEmpty()) {
			if (stack_a.size() > stack_b.size()) {
				if (stack_a.peek() == stack_b.peek())
					return stack_a.peek().data;
				else
					stack_a.pop();
				;
			} else if (stack_a.size() == stack_b.size()) {
				if (stack_a.peek() == stack_b.peek())
					return stack_a.peek().data;
				else {
					stack_a.pop();
					stack_b.pop();
				}
			} else {
				if (stack_a.peek() == stack_b.peek())
					return stack_b.peek().data;
				else
					stack_b.pop();
			}
		}
		return -1;
	}

	public static boolean find_a(int a, Stack<Node> stack_a, Node root) {
		// TODO Auto-generated method stub
		if (root.data != a) {
			stack_a.push(root);
			for (Node child : root.child) {
				boolean recans = find_a(a, stack_a, child);
				if (recans)
					return true;
			}
		} else {
			stack_a.push(root);
			return true;
		}
		stack_a.pop();
		return false;
	}

	public static void levelOrder(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		int flag = 1;
		while (flag == 1 || !queue.isEmpty()) {
			flag = 0;
			if (queue.isEmpty()) {
				queue.push(root);
				ans.add(root.data);
			} else if (!queue.isEmpty()) {
				root = queue.removeLast();
				for (Node child : root.child) {
					queue.push(child);
					ans.add(child.data);
				}
			}

		}
		for (int i = 0; i < ans.size(); i++)
			System.out.print(ans.get(i) + " ");
	}

	public static void preSuccPreorder(Node root, int data) {
		int pre = 0, flag = 0;
		recfunc(root, data, pre, flag);
		System.out.println();
		System.out.println(pre);
		System.out.println(flag);
	}

	public static boolean recfunc(Node root, int data, int pre, int flag) {
		// TODO Auto-generated method stub
		if (root.data != data) {
			int p = -1;
			int i = 0;
			for (i = 0; i < root.child.size(); i++) {
				p = i - 1;
				boolean recans = recfunc(root.child.get(i), data, pre, flag);
				if (flag == 0) {
					if (recans) {
						if (p == -1) {
							pre = root.data;
							flag = 1;
						} else {
							pre = root.child.get(p).data;
							flag = 1;
						}
					}
				} else if (flag == 1) {
					return true;
				}
			}
		} else if (root.data == data) {
			return true;
		}
		return false;
	}

}
