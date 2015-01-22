

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem11 {

	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan  =new Scanner(new File("src/Problem11Grid.txt"));
		int[][] grid =  new int[20][20];
		for(int i = 0; i< grid.length; i++) //read grid into 2d array
		{
			String s = scan.nextLine();
			String[] k = s.split(" ");
			for(int j=0; j< k.length; j++)
			{
				grid[i][j] = Integer.parseInt(k[j]);
			}
			
		}
		
		
		int maxProduct =0;
		for(int i =0; i < grid.length; i++)
		{
			for(int j =0; j< grid[0].length; j++)
			{
				
				int product = 1;
				
				if(i <= grid.length-4)//down
				{
					product = grid[i][j]*grid[i+1][j]*grid[i+2][j]*grid[i+3][j];
					if(product > maxProduct) 
						maxProduct = product;
				}
				
				if(j <= grid[i].length-4)
				{
					product= grid[i][j]*grid[i][j+1]*grid[i][j+2]*grid[i][j+3]; //right
					if(product > maxProduct) 
						maxProduct = product;
				}
				
				if(i <= grid.length-4 && j <= grid[i].length-4)
				{
					product =grid[i][j]*grid[i+1][j+1]*grid[i+2][j+2]*grid[i+3][j+3];//diagonal right down
					
					if(product > maxProduct) 
						maxProduct = product;
				}
				if(j >=4 && i <= grid.length-4)
				{
					product =grid[i][j]*grid[i+1][j-1]*grid[i+2][j-2]*grid[i+3][j-3];
					if(product > maxProduct) 
					maxProduct = product;
				}
				
			}
		}
		System.out.println(maxProduct);
		

	}

}

