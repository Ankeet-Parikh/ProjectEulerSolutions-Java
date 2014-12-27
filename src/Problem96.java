
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem96 {
	public static void main(String[] args) throws FileNotFoundException
	{
		
		int count=0;
		Scanner scan = new Scanner(new File("src/p096_sudoku.txt"));
		
		while(scan.hasNextLine())
		{
			String TitleLine = scan.nextLine();
			int[][] solved = new int[9][9];
			for(int i=0; i<9; i++)
			{
				char[] line = scan.nextLine().toCharArray();
				for(int j =0;j<9;j++)
				{
					solved[i][j] = (int)(line[j] -'0');
				}
			}
			
			
			solved = SolveSudoku(solved);
			
			count+=100*solved[0][0]+10*solved[0][1]+solved[0][2];
		}
		
		System.out.println(count);
	
	}
	
	public static int[][] SolveSudoku(int[][] p)
	{
		//for location purposes: each cell has an index between 0 and 80 in loc
		//the index is [loc/9][loc%9]
		int current =0;
		while(p[current/9][current%9] !=0) current++;
		int nx =current/9, ny =current%9;
		int min = 1;
		ArrayList<Integer> locStack = new ArrayList<Integer>(0); //this is the stack
		
		while(current < 81)
		{
			
			for(;min<=9;min++)
			{
				int r=0,c=0, z =((nx/3)*3)*9+(ny/3)*3;
				
				boolean canHave =true;
				for(;r<9 && c<9; r++, c++, z = z%3==2 ?z+7:z+1)
				{
					
					if(p[r][ny]==min || p[nx][c]==min || p[z/9][z%9]==min )
						canHave =false;
				}
				if(canHave)
				{
					p[nx][ny] =min;
					break;
				}
			}
			if(min ==10)
			{
				p[nx][ny] =0;
				current = locStack.remove(locStack.size()-1);//go back a step
				nx = current/9;
				ny = current%9;
				min = p[nx][ny]+1;
			}
			else
			{
				locStack.add(current);
				while(p[nx][ny] !=0)
				{
					current++;
					nx =current/9;
					ny =current%9;
					if(current == 81)
						break;
					
				}
				min=1;
				
			}
		}
		return p;
		
	}
	
	
	public static void PrintArray(int[][] p)
	{
		for(int i=0; i<p.length; i++)
		{
			for(int j =0; j<p[i].length; j++)
			{
				System.out.print(p[i][j] +" ");
			}
			System.out.println("");
		}
	}
}
