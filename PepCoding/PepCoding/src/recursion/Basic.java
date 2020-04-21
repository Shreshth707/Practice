package recursion;

public class Basic {

	/*
	 * Display Display Reverse Max Search All Index Reverse Array Using Recursion
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int ind = 0;
		int key = 6;
		display(arr, ind);
		System.out.println();
		displayR(arr, ind);
		System.out.println();
		System.out.println(max(arr, ind));
		System.out.println(lsearch(arr, key, ind));
		int[] ans = allIndex(arr, ind, key, 0);
		for (int i :ans) {
			System.out.print(i + " ");
		}
		System.out.println();
		reverse(arr, 0);
		for (int i:arr) {
			System.out.print(i + " ");
		}
	}

	private static int reverse(int[] arr, int i) {
		// TODO Auto-generated method stub
		if (i == arr.length)
			return 0;
		int data = arr[i];
		int j = reverse(arr, i + 1);
		arr[j] = data;
		return j + 1;
	}

	static int[] allIndex(int[] arr, int ind, int key, int count) {
		if (ind == arr.length) {
			int[] ans = new int[count];
			return ans;
		}
		if (arr[ind] == key)
			count++;
		int[] ans = allIndex(arr, ind + 1, key, count);
		if (arr[ind] == key) {
			ans[count - 1] = ind;
		}
		return ans;

	}

	private static int lsearch(int[] arr, int key, int ind) {
		// TODO Auto-generated method stub
		int index = -1;
		if (ind == arr.length)
			return -1;
		if (arr[ind] == key)
			return ind;
		else
			index = lsearch(arr, key, ind + 1);
		return index;
	}

	private static int max(int[] arr, int ind) {
		// TODO Auto-generated method stub
		int val = Integer.MIN_VALUE;
		if (ind == arr.length)
			return val;
		val = max(arr, ind + 1);
		val = Math.max(val, arr[ind]);
		return val;
	}

	private static void displayR(int[] arr, int ind) {
		// TODO Auto-generated method stub
		if (ind == arr.length)
			return;
		display(arr, ind + 1);
		System.out.print(arr[ind] + " ");
	}

	private static void display(int[] arr, int ind) {
		// TODO Auto-generated method stub
		if (ind == arr.length)
			return;
		System.out.print(arr[ind] + " ");
		display(arr, ind + 1);
	}

}
