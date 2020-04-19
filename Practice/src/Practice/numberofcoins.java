package Practice;

import java.util.Scanner;

public class numberofcoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		while (test-- > 0) {
			int V = scan.nextInt();
			int n = scan.nextInt();
			int[] c = new int[n];
			for (int i = 0; i < n; i++)
				c[i] = scan.nextInt();
			quicksort(0, n - 1, c);
			numberofcoin(c, 0, V, 0, 0, "");
			System.out.println(length);
			length = -1;
		}
	}

	static int length = -1;

	public static void numberofcoin(int[] c, int src, int dst, int li, int count, String asf) {
		if (src == dst) {
			if (length == -1) {
				length = count;
			} else {
				length = Math.min(length, count);
			}
		}
		if (src > dst)
			return;
		for (int i = li; i < c.length; i++) {
			numberofcoin(c, src + c[i], dst, i, count + 1, asf + Integer.toString(c[i]) + "->");
		}
	}

	public static void quicksort(int low, int high, int[] arr) {
		if (low >= high)
			return;
		int pi = partition(low, high, arr);
		quicksort(low, pi - 1, arr);
		quicksort(pi + 1, high, arr);
	}

	public static int partition(int low, int high, int[] arr) {
		int pivot = arr[high];
		int i = low - 1;
		int j = low;
		while (j < high) {
			if (arr[j] > pivot) {
				int temp = arr[++i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			j++;
		}
		int temp = arr[++i];
		arr[i] = arr[high];
		arr[high] = temp;
		return i;
	}

}
