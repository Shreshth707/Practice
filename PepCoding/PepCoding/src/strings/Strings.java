package strings;

import java.util.ArrayList;

/*
 * SubSequence of String Problem (Post nad Pre)
 * Keypad SubString Problem (Post nad Pre)
 * Stair Path (Post nad Pre)
 * Stair Path with Ladder to skip (Post nad Pre)
 * Dynamic Stair Path Problem (Post nad Pre)
 * Maze Path (Post nad Pre)
 * Multi Maze Path (Post nad Pre)
 * Rat In Maze 
 * Longest Common Sub String (Pre)
 * Permutations in Box and Objects Method 1,2,3
 * Combination in Box and Objects Method 1,2
 * How many ways to Print a No using given nos in an Array(Coin Change)
 * N Queens Problem 
 */
public class Strings {

	static String[] codes = { ".", "abc", "def", "ghi", "jklm", "no", "pqrs", "tu", "vwxy", "z" };
	static int[] ar = { 0, 0, 5, 0, 0, 0 }; /* Ladder Problem */
	static int[] dynamicstair = { 3, 2, 0, 4, 1, 2, 0, 2, 3, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String string = "835";
		// ArrayList<String> ss = getss(string);
		// System.out.println(ss);
		// ArrayList<String> kpc = getkpc(string);
		// System.out.println(kpc);
		// System.out.println(kpc.size());
		// ArrayList<String> a = stairpath(10);
		// System.out.println(a);
		// ArrayList<String> a = Matrixpath(0, 0, 2, 2);
		// System.out.println(a);
		// ArrayList<String> a = MultiMatrixpath(0, 0, 3, 3);
		// System.out.println(a);
		// System.out.println(a.size());
		// System.out.println(a.size());
		// ArrayList<String> a = DynamicStairpath(0, 10);
		// System.out.println(a);
		// System.out.println(a.size());
		// getssPre("ab", "");
		// stairpathPre(0,3,"0");
		// gkpcPre("835", "");
		// System.out.println(count);
		// mazepathPre(0,0,1,1,"");
		// MultimazepathPre(0, 0, 3, 3, "");
		// System.out.println(count);
		// int[][] check = new int[2][2];
		// int[][] matrix = { { 0, 0 }, { 0, 0 } };
		// ratInMazePre(0, 0, 1, 1, "", check, matrix);
		// System.out.println(count);
		// lcs("ABC","AC");
		// System.out.println(length);
		// int[] pbox = new int[5];
		// permutationinbox(5,2,box,"");
		// int[] cbox = new int[5];
		// combinationinbox(5, 3, cbox, "");
		// combinationinbox2(3,2,0,"");
		// System.out.println(count);
		// int[] items = new int[2];
		// permutationinbox2(3,2,0,0,"",items);
		// System.out.println(count);
		// permutation3(5,3,0,1,"");
		// System.out.println(count);
		// int[] num = { 2, 3, 5, 6 };
		// waystoprintnoPermu(num, 0, 7, "");
		// waystoprintnoCombi(num, 0, 7, 0, "");
		//int[][] check = new int[4][4];
		//nQueens(check,1,0,-1,"");
	}

	static int length = 0;

	static int count = 0;
	
	public static void nQueens(int[][]check,int currQ,int qi,int qj,String asf) {
		if (currQ > check.length) {
			System.out.println(++count + asf);
			return;
		}
		for (int i = qi;i<check.length;i++) {
			for (int j = (i == qi?qj+1:0);j<check.length;j++) {
				if (check[i][j]!=1 && isSafe(i,j,check)) {
					check[i][j]=1;
					nQueens(check,currQ+1,i,j,asf + "("+i+","+j+")"+"-");
					check[i][j]=0;
				}
			}
		}
	}
	
	
	

	private static boolean isSafe(int qi, int qj, int[][] check) {
		// TODO Auto-generated method stub
		for (int i = qi;i>=0;i--) {
			if (check[i][qj]==1) return false;
		}
		for (int j = qj;j>=0;j--) {
			if (check[qi][j]==1) return false;
		}
		for (int i = qi , j = qj;i>=0 && j>=0;i--,j--) {
			if (check[i][j]==1) return false;
		}
		for (int i = qi,j=qj;i>=0&&j<check[0].length;i--,j++) {
			if (check[i][j]==1) return false;
		}
		return true;
	}




	

	public static void waystoprintnoCombi(int[] num, int src, int dst, int li, String asf) {
		if (src == dst) {
			System.out.println(asf);
			return;
		}
		if (src > dst)
			return;
		for (int i = li; i < num.length; i++) {
			waystoprintnoCombi(num, src + num[i], dst, i, asf + Integer.toString(num[i]) + "->");
		}
	}

	public static void waystoprintnoPermu(int[] num, int src, int dst, String asf) {

		if (src == dst) {
			System.out.println(asf);
			return;
		}
		if (src > dst)
			return;
		for (int i = 0; i < num.length; i++) {
			if (num[i] <= dst - src) {
				waystoprintnoPermu(num, src + num[i], dst, asf + Integer.toString(num[i]) + "->");
			}
		}
	}

	public static void permutation3(int boxes, int objects, int cb, int isf, String asf) {

		if (cb == boxes) {
			if (isf == objects + 1) {
				System.out.println(asf);
				count++;
				return;
			}
			return;
		}

		for (int i = isf; i <= objects; i++) {
			permutation3(boxes, objects, cb + 1, isf + 1, asf + "O" + Integer.toString(i) + "B" + Integer.toString(cb));
		}
		permutation3(boxes, objects, cb + 1, isf, asf);
	}

	public static void permutationinbox2(int boxes, int objects, int cb, int isf, String asf, int[] items) {
		if (cb == boxes) {
			if (isf == objects) {
				System.out.println(asf);
				count++;
				return;
			}
			return;
		}
		permutationinbox2(boxes, objects, cb + 1, isf, asf, items);
		for (int i = 0; i < objects; i++) {
			if (items[i] == 0) {
				items[i] = 1;
				permutationinbox2(boxes, objects, cb + 1, isf + 1,
						asf + "O" + Integer.toString(i) + "B" + Integer.toString(cb), items);
				items[i] = 0;
			}
		}
	}

	public static void combinationinbox2(int boxes, int objects, int ind, String asf) {
		if (objects == 0) {
			System.out.println(asf);
			count++;
			return;
		}
		if (ind == boxes)
			return;
		combinationinbox2(boxes, objects - 1, ind + 1,
				asf + /* "O" + Integer.toString(objects) */ "B" + Integer.toString(ind));
		combinationinbox2(boxes, objects, ind + 1, asf);
	}

	public static void combinationinbox(int boxes, int objects, int[] box, String asf) {
		if (objects == 0) {
			System.out.println(asf);
			count++;
			return;
		}
		for (int i = 0; i < boxes; i++) {
			if (box[i] == 0) {
				box[i] = 1;
				combinationinbox(boxes, objects - 1, box,
						asf + "O" + Integer.toString(objects) + "B" + Integer.toString(i) + " ");
				for (int j = i + 1; j < boxes; j++) {
					box[j] = 0;
				}
			}
		}
	}

	public static void permutationinbox(int boxes, int objects, int[] box, String asf) {
		if (objects == 0) {
			System.out.println(asf);
			count++;
			return;
		}
		for (int i = 0; i < boxes; i++) {
			if (box[i] == 0) {
				box[i] = 1;
				permutationinbox(boxes, objects - 1, box,
						asf + "O" + Integer.toString(objects) + "B" + Integer.toString(i) + " ");
				box[i] = 0;
			}
		}
	}

	public static void lcss(String s1, String s2) {
		if (s1.length() == 0) {
			return;
		}
		char ch = s1.charAt(0);
		int index = 0;
		for (int i = 0; i < s2.length(); i++) {
			if (ch == s2.charAt(i)) {
				index = 1;
				int j = i + 1;
				while (j < s2.length() && index < s1.length()) {
					if (s1.charAt(index) == s2.charAt(j)) {
						index++;
						j++;
					} else {
						break;
					}
				}
				length = Math.max(length, index);
			}
		}
		String s1s = s1.substring(1, s1.length());
		lcss(s1s, s2);

	}

	public static void ratInMazePre(int sr, int sc, int dr, int dc, String asf, int[][] check, int[][] matrix) {
		if (sr == dr && sc == dc) {
			System.out.println(asf);
			count++;
			return;
		}
		if (sc > dc || sc < 0 || sr > dr || sr < 0)
			return;
		if (check[sr][sc] == 1)
			return;
		check[sr][sc] = 1;
		if (sc < dc) {
			ratInMazePre(sr, sc + 1, dr, dc, asf + "R", check, matrix);
		}
		if (sr < dr) {
			ratInMazePre(sr + 1, sc, dr, dc, asf + "D", check, matrix);
		}
		if (sc > 0) {
			ratInMazePre(sr, sc - 1, dr, dc, asf + "L", check, matrix);
		}
		if (sr > 0) {
			ratInMazePre(sr - 1, sc, dr, dc, asf + "U", check, matrix);
		}
		check[sr][sc] = 0;
	}

	public static void MultimazepathPre(int sr, int sc, int dr, int dc, String asf) {
		if (sr == dr && sc == dc) {
			System.out.println(asf);
			return;
		}
		if (sc < dc) {
			for (int ms = 1; ms <= (dc - sc); ms++)
				MultimazepathPre(sr, sc + ms, dr, dc, asf + "X" + Integer.toString(ms));
		}
		if (sr < dr) {
			for (int ms = 1; ms <= (dr - sr); ms++)
				MultimazepathPre(sr + ms, sc, dr, dc, asf + "Y" + Integer.toString(ms));
		}
		if (sc < dc && sr < dr) {
			for (int ms = 1; ms <= Math.min(dc - sc, dr - sr); ms++)
				MultimazepathPre(sr + ms, sc + ms, dr, dc, asf + "D" + Integer.toString(ms));
		}
	}

	public static ArrayList<String> MultiMatrixpath(int sr, int sc, int dr, int dc) {

		if (sc == dc && sr == dr) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> stod = new ArrayList<>();
		// nh
		for (int ms = 1; ms <= dc - sc; ms++) {
			ArrayList<String> ntod = MultiMatrixpath(sr, sc + ms, dr, dc);
			for (int i = 0; i < ntod.size(); i++) {
				String ntodpath = ntod.get(i);
				stod.add("X" + Integer.toString(ms) + ntodpath);
			}
		}
		// nv
		for (int ms = 1; ms <= dr - sr; ms++) {
			ArrayList<String> ntod = MultiMatrixpath(sr + ms, sc, dr, dc);
			for (int i = 0; i < ntod.size(); i++) {
				String ntodpath = ntod.get(i);
				stod.add("Y" + Integer.toString(ms) + ntodpath);
			}
		}
		// nd
		for (int ms = 1; ms <= Math.min(dc - sc, dr - sr); ms++) {
			ArrayList<String> ntod = MultiMatrixpath(sr + ms, sc + ms, dr, dc);
			for (int i = 0; i < ntod.size(); i++) {
				String ntodpath = ntod.get(i);
				stod.add("D" + Integer.toString(ms) + ntodpath);
			}
		}
		return stod;
	}

	public static void mazepathPre(int sr, int sc, int dr, int dc, String asf) {
		if (sr == dr && sc == dc) {
			System.out.println(asf);
			return;
		}
		if (sc < dc) {
			mazepathPre(sr, sc + 1, dr, dc, asf + "R");
		}
		if (sr < dr) {
			mazepathPre(sr + 1, sc, dr, dc, asf + "D");
		}
	}

	public static ArrayList<String> Matrixpath(int sr, int sc, int dr, int dc) {

		if (sc == dc && sr == dr) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> nh = new ArrayList<>();
		ArrayList<String> nv = new ArrayList<>();
		if (sr < dr) {
			nh = Matrixpath(sr + 1, sc, dr, dc);
		}
		if (sc < dc) {
			nv = Matrixpath(sr, sc + 1, dr, dc);
		}

		ArrayList<String> sToD = new ArrayList<>();
		for (int i = 0; i < nh.size(); i++) {
			String n = nh.get(i);
			sToD.add("x" + n);
		}
		for (int i = 0; i < nv.size(); i++) {
			String n = nv.get(i);
			sToD.add("y" + n);
		}

		return sToD;
	}

	public static void gkpcPre(String q, String asf) {
		if (q.length() == 0) {
			System.out.print(asf + " ");

			return;
		}
		char ch = q.charAt(0);
		String rq = q.substring(1, q.length());
		for (int step = 0; step < codes[Integer.parseInt(String.valueOf(ch))].length(); step++) {
			gkpcPre(rq, asf + codes[Integer.parseInt(String.valueOf(ch))].charAt(step));
		}
	}

	public static ArrayList<String> getkpc(String string) {
		// TODO Auto-generated method stub
		if (string.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		char ch = string.charAt(0);
		String sub = string.substring(1, string.length());
		ArrayList<String> rans = getkpc(sub);
		ArrayList<String> mans = new ArrayList<>();
		for (int i = 0; i < rans.size(); i++) {
			String r = rans.get(i);
			String code = codes[Integer.parseInt(String.valueOf(ch))];
			for (int j = 0; j < code.length(); j++) {
				mans.add(code.charAt(j) + r);
			}
		}
		return mans;

	}

	public static void stairpathPre(int src, int dst, String asf) {
		if (src == dst) {
			System.out.print(asf + " ");
			return;
		}
		if (src > dst) {
			return;
		}
		for (int step = 1; step <= 3; step++) {
			stairpathPre(src + step, dst, asf + Integer.toString(src + step));
		}
	}

	public static ArrayList<String> stairpath1(int src) {

		if (src == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("0");
			return base;
		} else if (src < 0) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}
		ArrayList<String> sToD = new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			if (src == ar[i]) {
				ArrayList<String> ntod = stairpath1(i);
				for (int j = 0; j < ntod.size(); j++) {
					String nToDpath = ntod.get(j);
					String sToDpath = nToDpath + Integer.toString(src);
					sToD.add(sToDpath);
				}
			}
		}
		for (int step = 1; step <= 3; step++) {
			ArrayList<String> nToD = stairpath1(src - step);

			for (int i = 0; i < nToD.size(); i++) {
				String nToDpath = nToD.get(i);
				String sToDpath = nToDpath + Integer.toString(src);
				sToD.add(sToDpath);
			}
		}
		return sToD;
	}

	public static ArrayList<String> stairpath(int src) {

		if (src == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("0");
			return base;
		} else if (src < 0) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}
		ArrayList<String> sToD = new ArrayList<>();
		for (int step = 1; step <= 3; step++) {
			ArrayList<String> nToD = stairpath(src - step);

			for (int i = 0; i < nToD.size(); i++) {
				String nToDpath = nToD.get(i);
				String sToDpath = nToDpath + Integer.toString(src);
				sToD.add(sToDpath);
			}
		}
		return sToD;
	}

	public static void getssPre(String q, String a) {
		if (q.length() == 0) {
			System.out.print(a + " ");
			return;
		}
		char ch = q.charAt(0);
		String rq = q.substring(1, q.length());

		getssPre(rq, a + "-");
		getssPre(rq, a + String.valueOf(ch));

	}

	public static ArrayList<String> getss(String string) {
		// TODO Auto-generated method stub
		if (string.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		char ch = string.charAt(0);
		String sub = string.substring(1, string.length());
		ArrayList<String> rans = getss(sub);
		ArrayList<String> mans = new ArrayList<>();
		for (int i = 0; i < rans.size(); i++) {
			String r = rans.get(i);
			mans.add("-" + r);
			mans.add(ch + r);
		}
		return mans;
	}

	public static ArrayList<String> DynamicStairpath(int src, int dst) {

		if (src == dst) {
			ArrayList<String> base = new ArrayList<>();
			base.add("10");
			return base;
		} else if (src > dst) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}
		ArrayList<String> sToD = new ArrayList<>();
		for (int step = 1; step <= dynamicstair[src]; step++) {
			ArrayList<String> nToD = DynamicStairpath(src + step, dst);

			for (int i = 0; i < nToD.size(); i++) {
				String nToDpath = nToD.get(i);
				String sToDpath = Integer.toString(src) + "->" + nToDpath;
				sToD.add(sToDpath);
			}
		}
		return sToD;
	}

}
