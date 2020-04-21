package recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		char s = 'S', d = 'D', h = 'H';
		toh(n, s, d, h);
	}

	static void toh(int n, char s, char d, char h) {
		if (n == 0) {
			return;
		} else {
			toh(n - 1, s, h, d);
			System.out.println(n + " " + s + "->" + d);
			toh(n - 1, h, d, s);
		}
	}
}
