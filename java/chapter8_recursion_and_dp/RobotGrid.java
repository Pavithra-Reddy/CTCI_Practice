package chapter8_recursion_and_dp;

import java.util.ArrayList;
import java.util.List;

public class RobotGrid {

	static boolean found = false;
	static List<List<Integer>> path = new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		int[][] grid = {{0,0,0,0,1,0},{1,0,1,0,1,0},{0,0,1,1,0,1},{0,0,0,0,0,1},{1,0,0,0,0,0}};
		
		findPath(grid, 0, 0);
		if(found == true) {
			System.out.println(path);
		}
		else {
			System.out.print("Not Found");
		}
	}

	private static void findPath(int[][] grid, int i, int j) {
		if(i < 0 || i > grid.length || j < 0 || j > grid[0].length) {
			return;
		}
		List<Integer> currPos = new ArrayList<Integer>();
		currPos.add(i);
		currPos.add(j);
		path.add(currPos);
		
		if( i == grid.length-1 && j == grid[0].length -1) {
			found = true;
			return;
		}
		
		if(((i+1) > 0 && (i+1) < grid.length && grid[i+1][j] == 1) && ((j+1) > 0 && (j+1) < grid[0].length && grid[i][j+1] == 1)) {
			path.remove(path.size()-1);
			grid[i][j] = 1;
			return;
		}
		
		if((j+1) > 0 && (j+1) < grid[0].length && grid[i][j+1] != 1) {
			findPath(grid,i,j+1);
			if(found) {
				return;
			}
		}
		
		if((i+1) > 0 && (i+1) < grid.length && grid[i+1][j] != 1) {
			findPath(grid,i+1,j);
			if(found) {
				return;
			}
		}
		
		
	}

}
