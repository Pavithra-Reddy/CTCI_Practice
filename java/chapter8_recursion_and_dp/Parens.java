package chapter8_recursion_and_dp;

import java.util.HashSet;
import java.util.Set;

public class Parens {

	public static void main(String[] args) {
		Set<String> res = getParens(2);
		for(String s:res) {
			System.out.println(s);
		}
	}

	private static Set<String> getParens(int n) {
		Set<String> res = new HashSet<String>();
		if(n <= 0) {
			res.add("");
			return res;
		}
		
		Set<String> prev = getParens(n-1);
		for(String p : prev) {
			res.add(p + "()");
			res.add("()" + p);
			res.add("(" + p + ")");
		}
		
		return res;
	}

}
