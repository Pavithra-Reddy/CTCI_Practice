package chapter17_hard;

import java.util.HashMap;

public class ShortestSubsequence {

	public static void main(String[] args) {
		int[] arr1 = {8,5,9};
		int[] arr2 = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
		int[] res = findSubsequence(arr1, arr2);
		System.out.println(res[0] + " " + res[1]);

	}

	public static int[] findSubsequence(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;

        if(m < n){
            return findSubsequence(arr2,arr1);
        }
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr2.length; i++) {
			int count = map.getOrDefault(arr2[i], 0) + 1;
			map.put(arr2[i], count);
		}

		int i = 0;
        int j = 0;
        int c = map.size();
        int start = 0;
        int end = arr1.length;
       
        boolean found = false;
        while(j < m){
            while(c > 0 && j < m){
                if(map.containsKey(arr1[j])){
                    int count = map.get(arr1[j]) - 1;
                    map.put(arr1[j],count);
                    if(count == 0){
                        c--;
                    }
                }
                j++;
            }
            
            while(c == 0 && i < j){
                if(map.containsKey(arr1[i])){
                    int count = map.get(arr1[i]) + 1;
                    map.put(arr1[i],count);
                    if(count > 0){
                        c++;
                    }
                }
                i++;
            }
            
            if((j-i) < (end - start)){
                start = i - 1;
                end = j - 1;
                found = true;
            }
        }
        
        int[] res = new int[2];
        if(found) {
        	res[0] = start;
        	res[1] = end;
        }
        
        return res;
	}
	
}
