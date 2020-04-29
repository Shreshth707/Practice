package dynamicProgramming;

public class Dp {

	/*
	 * Finbonacci Climb Stairs Total no of possible paths given an array of steps
	 * Minimum Steps and Path Print
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fibonacci(44));
		System.out.println(ClimbStairs(3));
		int[] jumps = { 4, 0, 2, 1, 5 };
		System.out.println(PossiblePaths(jumps));
		System.out.println(MinSteps(jumps));
	}

	public static int MinSteps(int[] jumps) {
		int[] dp = new int[jumps.length];
		dp[0] = 0;
		for (int i = dp.length - 2; i >= 0; i--) {
			if (jumps[i] == 0) {
				dp[i] = dp.length;
				continue;
			}
			int min = dp[i + 1];
			for (int j = i + 1; j <= i + jumps[i]; j++) {
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
