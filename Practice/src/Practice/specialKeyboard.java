package Practice;

public class specialKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		spKey(0, 10, 0, 0,"");
		System.out.println(ans);
	}

	static int ans = 0;

	public static void spKey(int src, int dst, int count, int curr, String asf) {
		if (src == dst) {
			System.out.println(asf);
			ans = Math.max(count, ans);
			return;
		}
		if (src > dst) {
			return;
		}
		spKey(src + 1, dst, count + 1, curr, asf + "A ->"); // Add 'A'

		if (dst - src >= 3) {
			spKey(src + 3, dst, count + count, count, asf + Integer.toString(count) + "A ->"); // Select Copy and Paste
		}
		if (curr != 0)
			spKey(src + 1, dst, count + curr, curr, asf + Integer.toString(curr) + "A ->"); // Paste Already Stored value
	}

}
