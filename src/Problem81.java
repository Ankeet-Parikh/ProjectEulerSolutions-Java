
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Problem81 {

	
	public static void main(String[] args) throws FileNotFoundException
	{
		final int range =80;
		Scanner scan = new Scanner(new File("src/matrix.txt"));

		String[][] $matrix = new String[range][range];
		int[][] matrix = new int[range][range];
		
		for(int i =0; i< range; i++)
		{
			$matrix[i] = scan.nextLine().split(",");
			for(int j =0; j< $matrix[0].length; j++)
			{
				matrix[i][j] = Integer.parseInt($matrix[i][j]);
			}
			
		}
		for(int i =0; i< matrix.length; i++)
		{
			for(int j =0; j< matrix.length; j++)
			{
				if(i ==0 && j ==0) continue;
				if(i ==0) matrix[i][j] += matrix[i][j-1];
				if(j ==0) matrix[i][j] += matrix[i-1][j];
				if(i!=0 &&j !=0)
				{
					if(matrix[i-1][j] > matrix[i][j-1])
					{
						matrix[i][j]+=matrix[i][j-1];
					}
					else
						matrix[i][j]+=matrix[i-1][j];
				}
				
			}
			
		}
		System.out.println(matrix[matrix.length-1][matrix[0].length-1]);
	}

}
