import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Problem83 {
	public static void main(String[] args) throws FileNotFoundException
	{
		/*
		int[][] map = {{131, 673, 234, 103,  18},
					   {201,  96, 342, 965, 150},
					   {630, 803, 746, 422, 111},
					   {537, 699, 497, 121, 956},
					   {805, 732, 524,  37, 331}};
					   */
		Scanner scan = new Scanner(new File("src/matrix.txt"));
		int side = 80;
		int[][] map = new int[side][side];
		for(int i=0; i< side; i++)
		{
			String[] v = scan.nextLine().split(",");
			for(int j=0; j<side; j++)
			{
				map[i][j] = Integer.parseInt(v[j]);
			}
		}
		System.out.println(DjikstraCost(map));
		
	}
	public static long DjikstraCost(int[][] map) //top left to bottom right on square matrix
	{
		//http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
		int[][] tent = new int[map.length][map[0].length]; //tentative distances
		ArrayList<Integer> unv = new ArrayList<Integer>(0); // list of unvisited nodes
		int s = map.length;
		for(int i = 0; i<map.length*map.length; i++)
		{
			unv.add(i); //add it to the unvisited list
			tent[i/map.length][i%map.length] = Integer.MAX_VALUE; // infinity
		}
		int curr = 0;
		tent[curr/s][curr%s] = map[curr/s][curr%s];
		while(true)
		{
			ArrayList<Integer> ne = getNeighbors(curr, s);
			//assign tentative values to neighbors
			for(int i=0; i<ne.size(); i++)
			{
				int n = ne.get(i);
				if(unv.contains(n)) //check if the neighbor is unvisited
				{
					int t = tent[curr/s][curr%s]+ map[n/s][n%s];
					if(t < tent[n/s][n%s])
						tent[n/s][n%s] = t;
				}
			}
			unv.remove(unv.indexOf(curr));
			if(!unv.contains(s*s-1)) break;
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
		return tent[s-1][s-1];
	}
	
	public static ArrayList<Integer> getNeighbors(int loc, int s)
	{
		//returns the neigbors of loc in an s by s matrix
		ArrayList<Integer> n = new ArrayList<Integer>(0);
		if(loc-s >= 0) //not on top edge
			n.add(loc-s);
		if(loc%s != 0) //not on left edge
			n.add(loc-1);
		if(loc%s != s-1) //not on the right edge
			n.add(loc+1);
		if(loc+s < s*s) //not on bottom edge
			n.add(loc+s);
			
		return n;
	}
}
