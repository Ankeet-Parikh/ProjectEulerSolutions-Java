//repeat of problem 18, same algorithm though



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem67 {

	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scan  = new Scanner(new File("src/Problem67Triangle.txt"));
			
		int[] SummedLine = new int[1];
		int i=1;
		while(scan.hasNextLine())
		{
			int[] currentLine = new int[i];
			for(int j =0; j< currentLine.length; j++) //scan in the current line
			{
				currentLine[j] = Integer.parseInt(scan.next());
			}
			//printArray(currentLine);
			//add summed to the current line, make sure to choose the higher of the two above values
			for(int j =0; j < currentLine.length; j++) 
			{
				if( j !=0 && j!= currentLine.length-1)
				{
					currentLine[j] += max(SummedLine[j-1],SummedLine[j]);
				}
				if(j ==0)
				{
					currentLine[j]+=SummedLine[0];
				}
				if(j == currentLine.length-1)
				{
					currentLine[j] +=SummedLine[SummedLine.length-1];
				}
			
			}
			
			SummedLine= currentLine;
			i++;
		}
		
		int max =0;
		for(i = 0; i< SummedLine.length; i++)
		{
			if(SummedLine[i] > max) max =SummedLine[i];
		}
		
		System.out.println(max);

	}
	private static void printArray(int[] arr) {
		for(int x : arr)
		{
			System.out.print(x +" ");
		}
		System.out.println("");
	}
	public static int max(int a, int b)
	{
		if(a >= b) return a;
		else return b;
	}


}
