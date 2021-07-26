package chapter8_recursion_and_dp;

public class Coins {
	public static void main(String args[])
	{
		int[] coins = {25, 10, 5, 1};
		int n = 20;
		int[][] dp = new int[n + 1][coins.length];
		int res = coinchange(coins, n, 0, dp);
		System.out.println(res);
	}

	private static int coinchange(int[] coins, int n, int i, int[][] dp) {
		if (dp[n][i] > 0) { 
			return dp[n][i];
		}
		
		int curr = coins[i];
		if (i == coins.length - 1) {
			int rem =  n%curr; 
			if(rem == 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		int res = 0;
		for (int j = 0; j <= n; j += curr) { 
			res = res + coinchange(coins, n - j, i + 1, dp);
		}
		
		dp[n][i] = res;
		return res;
	}
	
}
