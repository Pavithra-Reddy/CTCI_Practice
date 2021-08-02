package chapter16_moderate;

import java.util.ArrayList;
import java.util.List;

public class PondSizes {

	public static void main(String args[]) {
		int[][] grid = {{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
		System.out.println(getAllPondSizes(grid));
	}

	public static List<Integer> getAllPondSizes(int[][] grid) {
		List<Integer> allPondSizes = new ArrayList<Integer>();
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == 0){
					allPondSizes.add(getPondSize(grid, i, j));
				}
			}
		}
		return allPondSizes;
	}

	private static int getPondSize(int[][] grid, int i, int j){
		if(i < 0 || i > grid.length-1 || j < 0 || j > grid.length -1 || grid[i][j] != 0){
			return 0;
		}

		grid[i][j] = 1;

		int size = 1;
		size += getPondSize(grid, i-1, j);
		size += getPondSize(grid, i+1, j);
		size += getPondSize(grid, i, j-1);
		size += getPondSize(grid, i, j+1);
		
		size += getPondSize(grid, i-1, j-1);
		size += getPondSize(grid, i-1, j+1);
		size += getPondSize(grid, i+1, j-1);
		size += getPondSize(grid, i+1, j+1);
		
		return size;
	}

}
