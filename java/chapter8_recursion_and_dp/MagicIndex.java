package chapter8_recursion_and_dp;

public class MagicIndex {

	public static void main(String[] args) {
		int arr[] = {-2,-1,2,8,10,15,16,17};
		//int arr[] = {1,1,3,3,5,6,7,8,9};
		//int arr[] = {1,2,4,5,5,6,6,9};
		int magicIndex = getMagicIndex(arr, 0, arr.length-1);
		if(magicIndex != -1) {
			System.out.println(magicIndex);
		}
		else {
			System.out.println("Magic Index Not Found");
		}
	}

	private static int getMagicIndex(int[] arr, int begin, int end) {
		if(begin>end) {
			return -1;
		}
		
		int mid = (begin + end)/2;
		if(arr[mid] == mid) {
			return mid;
		}
		
		//left side
		int ind1 = getMagicIndex(arr,begin,mid-1);
		if(ind1 != -1) {
			return ind1;
		}
		//right side
		int ind2 = getMagicIndex(arr,mid+1,end);
		if(ind2 != -1) {
			return ind2;
		}
		
		return -1;
	}

}
