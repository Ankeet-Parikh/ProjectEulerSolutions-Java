package problems_10_19;

import java.math.BigInteger;

/*
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20×20 grid?
 */
public class Problem15 {

	public static void main(String[] args) {
		int sideLength = 20;
		BigInteger[][] grid = new BigInteger[sideLength][sideLength];
		for(int i = 0; i< grid.length; i++) grid[i][0] =new BigInteger(String.valueOf(i+2));
		for(int i = 0; i< grid[0].length; i++) grid[0][i] =new BigInteger(String.valueOf(i+2));
		
		for(int i = 1; i< grid.length; i++ )
		{
			for(int j =1; j< grid[0].length; j++)
			{
				grid[i][j]= grid[i-1][j].add(grid[i][j-1]);
			}
		}
		System.out.println(grid[grid.length-1][grid[0].length-1]);
		

	}

}
