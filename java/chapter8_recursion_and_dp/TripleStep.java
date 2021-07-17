package chapter8_recursion_and_dp;
import java.util.Scanner;

public class TripleStep {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getCount(n));
		sc.close();
	}

	private static int getCount(int n) {

		int[] memo = new int[n+1];
		
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		
		for(int i = 4; i <= n; i++) {
			memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
		}
		
		return memo[n];
	}
	

}
