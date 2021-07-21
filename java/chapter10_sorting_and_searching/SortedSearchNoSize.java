package chapter10_sorting_and_searching;

public class SortedSearchNoSize {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,8,9,10};
		Listy ls = new Listy(arr);
		int searchIndex = search(ls, 7);
		if(searchIndex == -1) {
			System.out.println("Not Found");
		}
		else {
			System.out.println("Found at index: "+ searchIndex);
		}

	}

	private static int search(Listy ls, int k) {
		int i = 1;
		while(ls.elementAt(i) != -1 && ls.elementAt(i) < k) {
			i = i*2;
		}
		if(ls.elementAt(i) == k) {
			return i;
		}
		return binarySearch(ls, i/2, i, k);
	}

	private static int binarySearch(Listy ls, int low, int high, int k) {
		
		while(low <= high) {
			int mid = (low+high)/2;
			int midValue = ls.elementAt(mid);
			if(midValue == -1 ||k < midValue) {
				high = mid-1;
			}
			else if( k > midValue) {
				low = mid+1;
			}
			else {
				return mid;
			}
		}
		
		return -1;
	}

}

class Listy{
	int[] arr;
	Listy(int[] arr){
		this.arr = arr;
	}
	int elementAt(int index){
		if(arr.length <= index)
			return -1;
		else {
			return arr[index];
		}
	}
}
