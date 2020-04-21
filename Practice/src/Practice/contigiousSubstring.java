package Practice;

import java.util.Scanner;

public class contigiousSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int textLength = scan.nextInt();
		int n = scan.nextInt();
		int[] s = new int[n];
		int[] e = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = scan.nextInt();
			e[i] = scan.nextInt();
		}
		int ans = ContigiousSubString(textLength,s,e);
		System.out.println(ans);
	}

	private static int ContigiousSubString(int textLength, int[] s, int[] e) {
		// TODO Auto-generated method stub
		int ans = 0;
		for (int i = 0;i<s.length;i++) {
			for (int j = i+1;j<s.length;j++) {
				
				if (s[i]>e[j]||e[i]<s[j]) {
					ans++;
				}
			}
		}
		return ans;
	}

}
