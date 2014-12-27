package problems_210_219;

import java.text.DecimalFormat;

public class Problem213 {
	public static void main(String[] args)
	{
		
		int r= 30;
		int rings =50;
		int[][] vn = new int[r*r][4]; //list of valid neighbors
		double[][] probmat = new double[r][r]; //probability matrix, same size as the flea circus
		for(int i=0;i<vn.length; i++)
		{
			vn[i] = getValidNeighbors(i,r); //store the list of valid neighbors into a vector
			probmat[i/r][i%r] = 1.0; //initiate all the squares to 1, indicating 100% probability that they are filled
		}
		
		//now we compute fifty iterations or "bell rings"
		for(int b = 1; b<=rings; b++)
		{
			//iterate over the map, distribute the probability for each cell into its neighbors, and repeat
			//create a new map for this
			double[][] p2 = new double[r][r];
			
			for(int i =0; i<r*r; i++)
			{
				int[] g = vn[i];
				double eachgets = probmat[i/r][i%r]/g.length;
				//System.out.println(eachgets);
				for(int n =0; n <g.length; n++)
				{
					p2[g[n]/r][g[n]%r] += eachgets;
				}
			}
			
			probmat = p2;
			
		}
		Print(probmat);
		double sum =0;
		/*For each cell, the chance that it is unoccupied is 1-probmat[i][j].
		 * If we sum all of those up, we get the number of unoccupied squares 
		 */
		for(int i =0; i<r*r; i++)
		{
			if(probmat[i/r][i%r] < 1)
			sum+=1-probmat[i/r][i%r];
		}
		DecimalFormat f = new DecimalFormat("#.000000");
		System.out.println(f.format(sum));
		
		
	}
	
	public static int[] getValidNeighbors(int loc, int s)//location of cell, size of matrix
	{
		if(loc <0 || loc >= s*s) return null;
		int[] n = new int[4]; //temporary size
		if(loc ==0 || s-1 == loc || s*s-1 == loc || loc == s*s-s) //test for corner piece
		{
			n = new int[2];
			if(loc == 0 || s-1 ==loc) //top corner pieces
			{
				if(loc == s-1) n[0] = loc-1;
				if(loc ==   0) n[0] = loc+1;
				n[1] = loc+s;
				
			}
			if(s*s-1 == loc || loc == s*s-s)
			{
				n[0] = loc-s;
				if(s*s-s == loc) n[1] = loc+1;
				if(s*s-1 == loc) n[1] = loc-1;
				
			}
		}
		else if(loc-s < 0 || loc+s > s*s || loc%s ==0 || loc%s ==s-1) //test for edge piece
		{
			n = new int[3];
			if(loc-s < 0 || loc+s > s*s) //2 horizontal edges
			{
				if(loc+s > s*s)n[2] = loc-s;
				n[0] = loc-1;
				n[1] = loc+1;
				if(loc-s < 0 ) n[2] = loc+s;
				
			}
			if(loc%s ==0 || loc%s ==s-1)//two vertical edges
			{
				n[0] = loc-s;
				if(loc%s == s-1) n[1] = loc-1;
				if(loc%s == 0) n[1] = loc+1;
				n[2] = loc+s;
			}
		}
		else
		{
			n[0] =loc-s;
			n[1] =loc-1;
			n[2] =loc+1;
			n[3] =loc+s;
		}
		return n;
		
	}
	public static void Print(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] +" ");
		}
		System.out.println("");
	}
	public static void Print(double[][] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j =0; j<arr[i].length; j++)
			    System.out.print(arr[i][j] +" ");
			System.out.println("");
		}
		System.out.println("");
	}
}
