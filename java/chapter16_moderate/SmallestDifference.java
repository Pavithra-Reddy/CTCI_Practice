package chapter16_moderate;

import java.util.Arrays;

public class SmallestDifference {

	public static void main(String[] args) {
		int[] arr1 = {1,3,15,11,21,11,18};
		int[] arr2 = {23,127,235,19,8};
		System.out.println(getSmallestDifference(arr1, arr2));
	}

	private static int getSmallestDifference(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
				
		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		
		while(i < arr1.length && j < arr2.length) {
			//System.out.println(arr1[i] + " " + arr2[j]);
			if(arr1[i] == arr2[j]) {
				return 0;
			}
			else if(arr1[i] < arr2[j]) {
				i++;
			}
			else {
				int curr = arr1[i] - arr2[j];
				if(curr < min) {
					min = curr;
				}
				j++;
			}
			//System.out.println(min);
		}
		return min;
	}

}
