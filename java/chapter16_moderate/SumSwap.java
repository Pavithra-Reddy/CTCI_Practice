package chapter16_moderate;

import java.util.HashSet;
import java.util.Set;

public class SumSwap {

	public static void main(String[] args) {
		int arr1[] = {1,2,3,2};
		int arr2[] = {5,0,4,0,1};
		printSumSwapPair(arr1, arr2);
	}

	private static void printSumSwapPair(int[] arr1, int[] arr2) {
		int arr1Sum = 0;
		int arr2Sum = 0;
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < arr1.length; i++) {
			arr1Sum += arr1[i];
			set.add(arr1[i]);
		}
		
		for(int i = 0; i < arr2.length; i++) {
			arr2Sum += arr2[i];
		}
		
		if((arr1Sum + arr2Sum)%2 != 0) {
			System.out.println("Sum is odd. No Pair Found");
		}
		
		int diff = (arr1Sum - arr2Sum)/2;
		for(int i = 0; i < arr2.length; i++) {
			if(set.contains(diff + arr2[i])) {
				System.out.println(diff + arr2[i] + " " + arr2[i]);
				return;
			}
		}
		System.out.println("No Pair Found");
	}

}
