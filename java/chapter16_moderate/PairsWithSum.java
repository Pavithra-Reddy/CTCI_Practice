package chapter16_moderate;

import java.util.ArrayList;
import java.util.Arrays;

public class PairsWithSum {

	public static void main(String[] args) {
		int[] arr = {1,5,6,7,2,3,4,0,-2,-1,0};
		ArrayList<int[]> pairs = getPairsWithSum(arr, 5);
		for (int[] p :pairs) {
			System.out.println(p[0] + " " + p[1]);
		}

	}
	
	private static ArrayList<int[]> getPairsWithSum(int[] arr, int sum) {
		ArrayList<int[]> pairs = new ArrayList<int[]>();
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int currSum = arr[start] + arr[end];
			if (currSum == sum) {
				int[] pair = {arr[start], arr[end]};
				pairs.add(pair);
				start++;
				end--;
			} else {
				if (currSum < sum) {
					start++;
				} else {
					end--;
				}
			}
		}
		return pairs;
	}

}
