package chapter10_sorting_and_searching;

public class SortedMerge {

	public static void main(String[] args) {
		int[] arr1 = {1,3,4,5,8,9,0,0,0,0};
		int[] arr2 = {2,5,6,7};
		merge(arr1, arr2);
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

	private static void merge(int[] arr1, int[] arr2) {
		int arr2Index = arr2.length - 1;
		int arr1Index = arr1.length - arr2.length-1;
		
		int currIndex = arr1.length-1;
		while(arr2Index >= 0) {
			if(arr1[arr1Index] > arr2[arr2Index]) {
				arr1[currIndex] = arr1[arr1Index];
				arr1Index--;
				
			}
			else {
				arr1[currIndex] = arr2[arr2Index];
				arr2Index--;
			}
			currIndex--;
		}
		
	}

}
