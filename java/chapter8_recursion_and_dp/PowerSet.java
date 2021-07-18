package chapter8_recursion_and_dp;

import java.util.ArrayList;

public class PowerSet {

	public static void main(String[] args) {
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for(int i = 1; i <= 8; i++) {
			ls.add(i);
		}
		ArrayList<ArrayList<Integer>> result = getAllSubsets(ls);
		for(int i = 0; i < result.size(); i++) {
			for(int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	private static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();
		for(int i = 0; i < max; i++) {
			res.add(getSubset(i,set));
		}
		return res;
		
	}

	private static ArrayList<Integer> getSubset(int n, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		for(int k = n, ind = 0; k > 0; k = k >> 1,ind++) {
			if((k & 1) == 1) {
				subset.add(set.get(ind));
			}
		}
		return subset;
	}

}
