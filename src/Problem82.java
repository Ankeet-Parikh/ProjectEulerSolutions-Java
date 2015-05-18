import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Problem82 {
	public static void main(String[] args) throws FileNotFoundException
	{
		double s = System.currentTimeMillis();
		Scanner scan = new Scanner(new File("src/p82matrix.txt"));
		int[][] m = new int[80][0];
		int l =0;
		while(scan.hasNextLine())
		{
			String[] vals = scan.nextLine().split(",");
			m[l] = new int[vals.length];
			for(int i=0; i<vals.length; i++) 
				m[l][i] = Integer.parseInt(vals[i]);
			l++;
		}
		int min = Integer.MAX_VALUE;
		for(int i =0; i<m.length; i++)
		{
			int c = ToRight(m ,i);
			if(c<min) min =c;
		}
		System.out.println(min);
		System.out.println((System.currentTimeMillis() -s)/1000 + " seconds");
		
	}
	
	public static int ToRight(int[][] map, int startRow)
	{
		/*
		 * Returns the length of the shortest path to the right column starting
		 * at the leftmost element in startRow
		 * We start counting rows from the zero
		 * 0: 0 1 2
		 * 1: 3 4 5
		 * 2: 6 7 8
		 */
		int s = map.length;
		ArrayList<Integer> unv = new ArrayList<Integer>(0);
		int[][] tent = new int[s][s];
		for(int i=0; i<s*s; i++)
		{
			tent[i/s][i%s] = Integer.MAX_VALUE;
			unv.add(i);
		}
		int curr = s*(startRow);
		tent[curr/s][curr%s] = map[curr/s][curr%s];
		while(true)
		{
			ArrayList<Integer> ne = getNeighbors(curr, s);
			//assign tentative values to neighbors
			boolean done = false;
			for(int i=0; i<ne.size(); i++)
			{
				int n = ne.get(i);
				if(unv.contains(n)) //check if the neighbor is unvisited
				{
					int t = tent[curr/s][curr%s]+ map[n/s][n%s];
					if(t < tent[n/s][n%s])
						tent[n/s][n%s] = t;
					if(n%s == s-1)
					{
						curr =n;
						done = true;
						break;
					}
				}
			}
			unv.remove(unv.indexOf(curr));
			if(done)
				break;
			else
			{
				//select the unvisited node with the smallest tentative value
				int minval = 0, min = Integer.MAX_VALUE;
				for(int i=0; i<unv.size(); i++)
				{
					int l = unv.get(i);
					if(tent[l/s][l%s] < min)
					{
						 minval = l;
						 min = tent[l/s][l%s];
					}
					
				}
				curr = minval;
			}
			
		}
		return tent[curr/s][curr%s];
	}
	
	public static ArrayList<Integer> getNeighbors(int loc, int s)
	{
		//returns the neigbors of loc in an s by s matrix
		/*
		 * Locations in 3 by 3 matrix:
		 * 0 1 2
		 * 3 4 5
		 * 6 7 8
		 */
		ArrayList<Integer> n = new ArrayList<Integer>(0);
		if(loc-s >= 0) //not on top edge
			n.add(loc-s);
		/*
		 * Don't need to take loc-1 into account because left movement is prohibited
		if(loc%s != 0) //not on left edge
			n.add(loc-1);*/
		if(loc%s != s-1) //not on the right edge
			n.add(loc+1);
		if(loc+s < s*s) //not on bottom edge
			n.add(loc+s);
			
		return n;
	}
	

}
