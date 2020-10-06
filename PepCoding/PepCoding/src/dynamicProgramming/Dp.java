package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dp {

	// Finbonacci
	// Climb Stairs
	// Total no of possible paths given an array of Steps
	// Minimum Steps and Path Print
	// Max Gold can be Collected
	// Count of Binary String of length n Having no consecutive zeros
	// Target Sum SubSet
	// 0 - 1 Knapsack
	// Ways to tile the floor
	// Longest Common SubSequence (Recursion)(DP)
	// Longest Common Palandromic SubSequence (Recursion)(DP)
	// Count Palandromic SubSequence
	// Total no of Divisible SubSequence
	// Increasing Subsequence
	// Minimum Palandromic Cut
	// Egg Drop Problem
	// Matrix Multiplication
	// Coin Game (Choose One From End)(Recursion)(DP)
	// Optimal BST (DP)
	// Minimum Square Tiles to fill (DP-Memorization)
	// Longest Increasing SubSequence(LIS)
	// Rod Cutting
	// Max Sum Number Adjacent Elements
	// Activity Selection (DP) (Greedy)
	// Fractional Knapsack (Greedy)
	// Minimum Platforms Required (Greedy)
	// Job Sequence (Greedy)
	// Max Possible Square Possible of 1s

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start, end;
		start = System.currentTimeMillis();
		// System.out.println(Fibonacci(44));
		// System.out.println(ClimbStairs(3));
		// int[] jumps = { 3, 2, 5, 1, 8 };
		// System.out.println(PossiblePaths(jumps));
		// System.out.println(MinSteps(jumps));
		// System.out.println(MaxGold(grid));
		// System.out.println(BinaryStringLenCount(10));
		// System.out.println(TargetSumSubSet(jumps, 9));
		// MinCoinChangeDp(43);
		// System.out.println(Knapsack(7, weight, price));
		// System.out.println(waysToTileArea(10,2));
		// System.out.println(lcs("abcd","acbd"));
		// System.out.println(lcps("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
		// System.out.println(lcpDp("abcd","acbd"));
		// System.out.println(lcpsDp("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
		// System.out.println(cpsDp("abckycbc "));
		// System.out.println(cdivq("235168", 6));
		// System.out.println(iSS("abcbc"));
		// System.out.println(mpc("abccbc"));
		// System.out.println(EggDrop(2,100));
		// System.out.println(MatrixMulti(arr));
		// System.out.println(CoinGame(arr, 0, arr.length - 1));
		// System.out.println(CoinGameDP(arr));
		// System.out.println(OptimalBst(val, freq));
		// int[][] qb = new int [31][37];
		// System.out.println(MinCutSqTiles(30,36,qb));
		// System.out.println(liss(arr));
		// System.out.println(rodCutting(rod));
		// System.out.println(msnae(arr));
		// System.out.println(actvitySelection(starta, enda));
		// System.out.println(activitySelectionGreedy(starta,enda));
		// System.out.println(fractionalKnapsack(weights, prices, 50));
		// System.out.println(minPlatforms(arrival, departure));
		// System.out.println(jobSequence(days, profit));
		System.out.println(maxPossibleSquare(matrix));
		end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start));
	}

	static int[][] matrix = {{1,0,0,1,0,0,1,0},
							{1,1,1,1,1,1,1,1},
							{1,1,0,1,1,1,1,1},
							{1,0,1,1,1,1,1,0},
							{0,1,1,1,1,1,1,1},
							{1,0,1,0,1,1,0,1},
							{1,0,0,1,1,1,1,1}};
	static int[] days = { 2, 1, 2, 1, 3 };
	static int[] profit = { 100, 19, 27, 25, 15 };

	static int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
	static int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };
	static int[] starta = { 12, 2, 6, 7, 9, 1, 3 };
	static int[] enda = { 14, 5, 8, 10, 11, 5, 7 };
	static int[] rod = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
	static int[] val = { 10, 20, 30, 40, 50, 60, 70 };
	static int[] freq = { 2, 1, 4, 1, 1, 3, 5 };
	static int[] arr = { 5, 6, 10, 100, 10, 5, 4 };
	static int[] weights = { 10, 40, 20, 30 };
	static int[] prices = { 60, 40, 100, 120 };

	static int[][] grid = { { 1, 5, 1, 0, 3 }, { 1, 4, 0, 2, 3 }, { 4, 0, 1, 3, 2 }, { 2, 4, 0, 4, 1 },
			{ 1, 2, 3, 2, 0 } };
	static int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

	/** Max Possible Square Possible of 1s **/
	public static int maxPossibleSquare(int[][] matrix) {
		int[][] dp = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (i == matrix.length - 1 || j == matrix[0].length - 1) {
					dp[i][j] = matrix[i][j];
					max = Math.max(max, dp[i][j]);
				} else {
					if (matrix[i][j] == 1) {
						dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
						max = Math.max(max, dp[i][j]);
					}else {
						dp[i][j] = matrix[i][j];
						max = Math.max(max, dp[i][j]);
					}
					
				}
			}
		}
		return max;
	}

	/** Job Sequence (Greedy) **/
	public static class Jobs implements Comparable<Jobs> {
		int days;
		int profit;

		Jobs(int days, int profit) {
			this.days = days;
			this.profit = profit;
		}

		public int compareTo(Jobs other) {
			return (this.profit - other.profit) * (-1);
		}
	}

	public static int jobSequence(int[] days, int[] profit) {
		Jobs[] jobs = new Jobs[days.length];
		int max_days = 0;
		for (int i = 0; i < jobs.length; i++) {
			jobs[i] = new Jobs(days[i], profit[i]);
			max_days = Math.max(max_days, days[i]);
		}
		Arrays.sort(jobs);
		boolean[] check = new boolean[max_days + 1];
		int val = 0;
		for (int i = 0; i < jobs.length; i++) {
			if (check[jobs[i].days] == false) {
				check[jobs[i].days] = true;
				val += jobs[i].profit;
			} else {
				int j = jobs[i].days - 1;
				while (j > 0) {
					if (check[j] == false) {
						check[j] = true;
						val += jobs[i].profit;
						break;
					}
					j--;
				}
			}
		}
		return val;
	}

	/** Minimum Platforms Required (Greedy) **/
	public static int minPlatforms(int[] arrival, int[] departure) {
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int inda = 1, indd = 0;
		int max = 1;
		int count = 1;
		while (inda < arrival.length) {
			if (arrival[inda] < departure[indd]) {
				count++;
				max = Math.max(max, count);
				inda++;
			} else {
				count--;
				indd++;
			}
		}
		return max;
	}

	/** Fractional Knapsack **/
	public static class Ratio implements Comparable<Ratio> {
		int weight;
		int price;
		double ratio;

		Ratio(int weight, int price) {
			this.weight = weight;
			this.price = price;
			this.ratio = price * 1.0 / weight;
		}

		public int compareTo(Ratio other) {
			return (int) (this.ratio - other.ratio) * (-1);
		}
	}

	public static double fractionalKnapsack(int[] weights, int[] prices, int capacity) {
		Ratio[] wpra = new Ratio[weights.length];
		for (int i = 0; i < wpra.length; i++) {
			wpra[i] = new Ratio(weights[i], prices[i]);
		}
		Arrays.sort(wpra);
		double val = 0;
		int ind = 0;
		while (capacity != 0 && ind < wpra.length) {
			if (wpra[ind].weight <= capacity) {
				val += wpra[ind].price;
				capacity = capacity - wpra[ind].weight;
			} else {
				val += wpra[ind].ratio * capacity;
				capacity = 0;
			}
			ind++;
		}
		return val;
	}

	/** Activity Selection General **/
	public static class Interval implements Comparable<Interval> {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Interval other) {
			return this.end - other.end;
		}

	}

	/** Activity Selection Greedy **/
	public static int activitySelectionGreedy(int[] start, int[] end) {
		Interval[] intvs = new Interval[start.length];
		for (int i = 0; i < intvs.length; i++) {
			intvs[i] = new Interval(start[i], end[i]);
		}
		Arrays.sort(intvs);
		int ans = 1;
		int base = intvs[0].end;
		for (int i = 1; i < start.length; i++) {
			if (intvs[i].start > base) {
				ans++;
				base = intvs[i].end;
			}
		}
		return ans;
	}

	/** Acitivuty Selection DP **/
	public static int actvitySelection(int[] start, int[] end) {
		Interval[] intvs = new Interval[start.length];
		for (int i = 0; i < intvs.length; i++) {
			intvs[i] = new Interval(start[i], end[i]);
		}
		Arrays.sort(intvs);
		int[] dp = new int[start.length];
		dp[0] = 1;
		for (int i = 1; i < start.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (intvs[j].end < intvs[i].start) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
		}

		return dp[dp.length - 1];
	}

	/** Max Sum Number Adjacent Elements **/
	public static int msnae(int[] arr) {
		int[][] dp = new int[2][arr.length];
		dp[0][0] = arr[0];
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = dp[1][i - 1] + arr[i];
			dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 1]);
		}
		return dp[0][arr.length - 1] > dp[1][arr.length - 1] ? dp[0][arr.length - 1] : dp[1][arr.length - 1];

	}

	/** Rod Cutting */
	public static int rodCutting(int[] rod) {
		int[] dp = new int[rod.length];
		dp[1] = rod[1];
		for (int i = 2; i < rod.length; i++) {
			int low = 0;
			int high = i;
			int max = 0;
			dp[i] = rod[i];
			while (low <= high) {
				max = Math.max(max, dp[low] + dp[high]);
				low++;
				high--;
			}
			dp[i] = max;
		}
		return dp[rod.length - 1];
	}

	/** Longest Increasing SubSequence **/
	public static int liss(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
		}
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	/** Minimum Square Tiles to fill (DP-Memorisation) **/
	public static int MinCutSqTiles(int h, int w, int[][] qb) {
		if (h == 0 || w == 0) {
			return 0;
		} else if (h == w) {
			return 1;
		}
		if (qb[h][w] != 0) {
			return qb[h][w];
		}
		int res = Integer.MAX_VALUE;
		for (int x = 1; x <= Math.min(h, w); x++) {
			int lvh = h - x;
			int lvw = x;
			int rvh = h;
			int rvw = w - x;
			int lvscore = MinCutSqTiles(lvh, lvw, qb);
			int rvscore = MinCutSqTiles(rvh, rvw, qb);
			int tvscore = rvscore + lvscore;

			int uhh = x;
			int uhw = w - x;
			int dhh = h - x;
			int dhw = w;
			int uhscore = MinCutSqTiles(uhh, uhw, qb);
			int dhscore = MinCutSqTiles(dhh, dhw, qb);
			int thscore = uhscore + dhscore;

			res = Math.min(res, Math.min(thscore, tvscore));
		}
		qb[h][w] = ++res;

		return res;
	}

	/** Optimal Bst **/
	public static int OptimalBst(int val[], int freq[]) {
		int[][] dp = new int[val.length][val.length];

		int[] fpsa = new int[freq.length];
		fpsa[0] = freq[0];
		for (int i = 1; i < fpsa.length; i++) {
			fpsa[i] = freq[i] + fpsa[i - 1];
		}

		for (int gap = 0; gap < dp.length; gap++) {
			for (int i = 0; i < dp.length - gap; i++) {
				int j = i + gap;
				if (gap == 0) {
					dp[i][j] = freq[i];
				} else if (gap == 1) {
					dp[i][j] = Math.min(freq[i] + freq[j] * 2, freq[j] + freq[i] * 2);
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = 0; k <= gap; k++) {
						int left = k == 0 ? 0 : dp[i][i + k - 1];
						int down = k == gap ? 0 : dp[i + k + 1][j];
						min = Math.min(min, left + down);
					}
					int sum = i == 0 ? fpsa[j] : fpsa[j] - fpsa[i - 1];
					dp[i][j] = sum + min;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[0][dp.length - 1];
	}

	/** Coin Game (Choose One From End)(DP) **/
	public static int CoinGameDP(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];

		for (int gap = 1; gap < arr.length; gap = gap + 2) {
			for (int i = 0; i < dp.length - gap; i++) {
				int j = i + gap;
				if (gap == 1) {
					dp[i][j] = Math.max(arr[i], arr[j]);
				} else {
					dp[i][j] = Math.max(arr[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]),
							arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[0][dp.length - 1];
	}

	/** Coin Game (Choose One From End)(Recursion) **/
	public static int CoinGame(int[] arr, int start, int end) {
		if (end - start == 1) {
			return Math.max(arr[end], arr[start]);
		}
		if (start > end) {
			return 0;
		}
		return Math.max(arr[start] + Math.min(CoinGame(arr, start + 1 + 1, end), CoinGame(arr, start + 1, end - 1)),
				arr[end] + Math.min(CoinGame(arr, start + 1, end - 1), CoinGame(arr, start, end - 1 - 1)));
	}

	/** Matrix Multiplication **/
	public static int MatrixMulti(int[] arr) {
		int[][] dp = new int[arr.length - 1][arr.length - 1];
		for (int gap = 0; gap < dp.length; gap++) {
			for (int i = 0; i < dp.length - gap; i++) {
				int j = i + gap;
				if (gap == 0) {
					// nothing
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int left = dp[i][k];
						int down = dp[k + 1][j];
						min = Math.min(min, left + down + arr[i] * arr[j + 1] * arr[k + 1]);
				    	}
					dp[i][j] = min;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[0][dp.length - 1];
	}

	/** Egg Drop Problem **/
	public static int EggDrop(int egg, int floor) {
		int[][] dp = new int[egg + 1][floor + 1];
		for (int j = 1; j < floor + 1; j++) {
			dp[1][j] = j;
		}
		for (int i = 2; i < egg + 1; i++) {
			for (int j = 1; j < floor + 1; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < j; k++) {
					int breaks = dp[i - 1][k];
					int survive = dp[i][j - k - 1];
					min = Math.min(min, Math.max(breaks, survive));
				}
				dp[i][j] = min + 1;
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[egg][floor];
	}

	/** Minimum Palandromic Cut **/
	public static int mpc(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0; i < s.length() - gap; i++) {
				int j = i + gap;
				if (gap == 0) {

				} else if (gap == 1) {
					if (s.charAt(i) != s.charAt(j)) {
						dp[i][j] = 1;
					}
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 0) {

					} else {
						int min = Integer.MAX_VALUE;
						for (int k = 0; k < gap; k++) {
							int left = dp[i][i + k];
							int down = dp[i + k + 1][j];
							if (min > left + down) {
								min = left + down;
							}
						}
						dp[i][j] = min + 1;
					}
				}
			}
		}
		return dp[0][s.length() - 1];
	}

	/** Increasing SubSequence **/
	public static int iSS(String s) {
		int[] dp = new int[s.length()];
		dp[0] = 2;
		for (int i = 1; i < dp.length; i++) {
			boolean found = false;
			for (int j = i - 1; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j)) {
					found = true;
					if (j != 0) {
						dp[i] = dp[i - 1] * 2 - dp[j - 1];
					} else {
						dp[i] = dp[i - 1] * 2 - 1;
					}
					break;
				}
			}
			if (!found) {
				dp[i] = dp[i - 1] * 2;
			}
		}
		return dp[s.length() - 1];
	}

	/** Total no of Divisible SubSequence **/

	public static int cdivq(String s, int d) {
		int[][] dp = new int[s.length()][d];
		dp[0][0] = 1;
		dp[0][(s.charAt(0) - 48) % d] = 1;

		for (int i = 0; i < s.length() - 1; i++) {

			for (int j = 0; j < d; j++) {
				dp[i + 1][j] += dp[i][j];
				int num = s.charAt(i + 1) - 48;
				dp[i + 1][(j * 10 + num) % d] += dp[i][j];
			}
		}
		return dp[s.length() - 1][0];
	}

	/** Count Palandromic SubSequence **/

	public static int cpsDp(String s) {
		int[][] strg = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0; i < s.length() - gap; i++) {
				int j = i + gap;
				if (gap == 0) {
					strg[i][j] = 1;
				} else if (gap == 1) {
					strg[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = strg[i][j - 1] + strg[i + 1][j] + 1;
						;
					} else {
						strg[i][j] = (strg[i][j - 1] + strg[i + 1][j]) - strg[i + 1][j - 1];
					}
				}
			}
		}
		return strg[0][s.length() - 1];
	}

	public static int lcpsDp(String s) {
		int[][] strg = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0; i < s.length() - gap; i++) {
				int j = i + gap;
				if (gap == 0) {
					strg[i][j] = 1;
				} else if (gap == 1) {
					strg[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = 2 + strg[i + 1][j - 1];
					} else {
						strg[i][j] = Math.max(strg[i][j - 1], strg[i + 1][j]);
					}
				}
			}
		}
		return strg[0][s.length() - 1];
	}

	public static int lcpDp(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < s1.length() + 1; i++) {
			char ch1 = s1.charAt(i - 1);
			for (int j = 1; j < s2.length() + 1; j++) {
				char ch2 = s2.charAt(j - 1);
				if (ch1 == ch2) {
					strg[i][j] = strg[i - 1][j] + 1;
				} else {
					strg[i][j] = Math.max(strg[i - 1][j], strg[i][j - 1]);
				}
			}
		}
		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				System.out.print(strg[i][j] + " ");
			}
			System.out.println();
		}
		return strg[s1.length()][s2.length()];
	}

	public static int lcps(String s) {
		if (s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		char ch1 = s.charAt(0), ch2 = s.charAt(s.length() - 1);
		if (ch1 == ch2) {
			int ans = 2 + lcps(s.substring(1, s.length() - 1));
			return ans;
		} else {
			int ans = Math.max(lcps(s.substring(0, s.length() - 1)), lcps(s.substring(1, s.length())));
			return ans;
		}
	}

	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 && s2.length() == 0) {
			return 0;
		}
		if (s1.length() == 0) {
			return -1;
		}
		if (s2.length() == 0) {
			return -1;
		}

		char ch1 = s1.charAt(0), ch2 = s2.charAt(0);
		if (ch1 == ch2) {
			int ans = 1 + lcs(s1.substring(1, s1.length()), s2.substring(1, s2.length()));
			return ans;
		} else {
			int ans = Math.max(lcs(s1.substring(1, s1.length()), s2.substring(0, s2.length())),
					lcs(s1.substring(0, s1.length()), s2.substring(1, s2.length())));
			return ans;
		}

	}

	public static int waysToTileArea(int n, int m) {
		int[] strg = new int[n + 1];
		strg[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			if (i - m >= 0) {
				strg[i] = strg[i - m] + strg[i - 1];
			} else {
				strg[i] = strg[i - 1];
			}
		}
		return strg[n];
	}

	public static int Knapsack(int bagsize, int[] w, int[] p) {
		int[][] strg = new int[w.length][bagsize + 1];

		for (int j = 1; j < bagsize + 1; j++) {
			strg[0][j] = -1;
		}
		for (int i = 0; i < w.length; i++) {
			for (int j = 1; j < bagsize + 1; j++) {
				if (i == 0) {
					if (j - w[i] >= 0) {
						strg[i][j] = p[i];
						break;
					}
				} else {
					strg[i][j] = strg[i - 1][j];
					if (j - w[i] >= 0) {
						if (strg[i - 1][j - w[i]] != -1) {
							strg[i][j] = Math.max(strg[i - 1][j - w[i]] + p[i], strg[i][j]);
						}
					}
				}
			}
		}
		int max = strg[w.length - 1][1];
		int indj = 1;
		for (int j = 2; j < bagsize + 1; j++) {
			if (max < strg[w.length - 1][j]) {
				indj = j;
				max = strg[w.length - 1][j];
			}
		}

		printKnapsack(strg, w, p, w.length - 1, indj, "");
		return max;
	}

	public static void printKnapsack(int[][] strg, int[] w, int[] p, int i, int j, String asf) {
		// TODO Auto-generated method stub
		if (j == 0) {
			System.out.println(asf);
			return;
		}
		if (i < 0) {
			return;
		}
		if (j - w[i] >= 0) {
			if (strg[i][j] - strg[i][j - w[i]] == p[i]) {
				// take the option
				printKnapsack(strg, w, p, i - 1, j - w[i], asf + w[i] + "->");
				if (i >= 0 && strg[i][j] == strg[i - 1][j]) {
					printKnapsack(strg, w, p, i - 1, j, asf);
				}
			} else {
				// dont take
				printKnapsack(strg, w, p, i - 1, j, asf);
			}
		} else {
			// dont take
			printKnapsack(strg, w, p, i - 1, j, asf);
		}

	}

	public static void MinCoinChangeDp(int n) {
		int[][] strg = new int[coins.length][n + 1];
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < n + 1; j++) {
				strg[i][j] = n + 1;
			}
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i == 0) {
					if (j - coins[i] >= 0) {
						if (strg[0][j - coins[0]] != n + 1) {
							strg[0][j] = 1 + strg[0][j - coins[0]];
						}
					}
				} else {
					strg[i][j] = strg[i - 1][j];
					if (j - coins[i] >= 0) {
						strg[i][j] = Math.min(1 + strg[i][j - coins[i]], strg[i][j]);
					}
				}
			}
		}
		printMinPath(strg, 0, coins.length - 1, n, "");

	}

	public static void printMinPath(int[][] strg, int count, int i, int j, String asf) {
		// TODO Auto-generated method stub
		if (j == 0) {
			System.out.println(asf);
			// System.out.println(count);
			return;
		}
		if (i == -1) {
			return;
		}
		if (j - coins[i] >= 0) {
			if (strg[i][j - coins[i]] != strg[0].length) {
				// take it
				printMinPath(strg, count + 1, i, j - coins[i], asf + Integer.toString(coins[i]) + " ");
			}
		} else {
			printMinPath(strg, count, i - 1, j, asf);
		}

	}

	public static boolean TargetSumSubSet(int[] arr, int target) {
		boolean[][] strg = new boolean[arr.length][target + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < target + 1; j++) {
				if (i != 0) {
					if (strg[i - 1][j] == true) {
						strg[i][j] = true;
					} else {
						if (j - arr[i] >= 0) {
							if (strg[i - 1][j - arr[i]] == true) {
								strg[i][j] = true;
							}
						}
					}
				} else {
					if (arr[0] <= target) {
						strg[i][arr[0]] = true;
					}
					break;
				}
			}
		}
		return strg[arr.length - 1][target];
	}

	public static int BinaryStringLenCount(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 2;
		dp[2] = 3;
		for (int i = 3; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static int MaxGold(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			dp[i][0] = grid[i][0];
		}

		for (int j = 1; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length; i++) {
				if (i == 0) {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j - 1]) + grid[i][j];
				} else if (i == grid.length - 1) {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j - 1]) + grid[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i + 1][j - 1])) + grid[i][j];
				}
			}
		}
		int maxgold = dp[0][grid[0].length - 1];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 1; i < grid.length; i++) {
			maxgold = Math.max(maxgold, dp[i][grid[0].length - 1]);
		}
		return maxgold;

	}

	public static int MinSteps(int[] jumps) {
		int[] dp = new int[jumps.length];
		dp[jumps.length - 1] = 0;
		for (int i = dp.length - 2; i >= 0; i--) {
			if (jumps[i] == 0) {
				dp[i] = dp.length;
				continue;
			}
			int min = dp[i + 1];
			for (int j = i + 1; j <= i + jumps[i] && j < jumps.length; j++) {
				min = Math.min(min, dp[j]);
			}
			dp[i] = min + 1;
		}
		return dp[0];
	}

	public static int PossiblePaths(int[] jumps) {
		int[] dp = new int[jumps.length];
		dp[jumps.length - 1] = 1;
		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = i + 1; j <= i + jumps[i]; j++) {
				dp[i] += dp[j];
			}
		}
		return dp[0];
	}

	public static int ClimbStairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			if (i == 1) {
				dp[i] = dp[0];
			} else if (i == 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
		}
		return dp[n];
	}

	public static int Fibonacci(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

}
