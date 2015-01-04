
public class Problem51 {
	static int[] primes;
	public static void main(String [] args)
	{
		int range = (int)1e7;
		int [][] a = replist(8,4,null);
		System.out.println(a.length);
		Print2d(a);
		
	}
	
	
		
		
		
	public static int[][] replist(int nd, int e, int[] prev)
	{
		/*
		 * This method will return all the combinations of indeces (each one distinct)
		 * that can be produced from an n digit integer. Indeces start from zero.
		 * For example: There are 7 different replacement combinations for 
		 * an integer of length three.
		 * 3 choose 1 + 3 choose 2 + 3 choose 3 = 7
		 * The actual combinations are:
		 * {{0}, {1}, {2}, {0,1}, {0,2}, {1,2}, {0,1,2}}
		 * This method will return the arrays in this list which contain e elements.
		 * For example: replist(3,2, null) will return {{0,1}, {0,2}, {1,2}}
		 * The entire process is recursive.
		 * for the initial call, use replist(..., ..., null)
		 */
		boolean init = prev==null;
		int s = init?0:prev[prev.length-1] +1; //s for start
		int max = nd-e; //max is the limit start can go up to
		int[][] toreturn = new int[0][0];
		if(e==1)
			toreturn = new int[max-s+1][0];
		for(int i=0;s<=max; s++, i++)
		{
			if(init)
			{
				prev = new int[1];
				prev[0] =i;
			}
			if(e==1)
				toreturn[i] = init?prev:append(prev, s);
			else 
			{
				int[] next = init?prev:append(prev, s);

				int[][] c = replist(nd, e-1, next);
				if(i ==0) toreturn = c;
				else toreturn = append(toreturn,c);
				
			}
		}
		return toreturn;
		
	}
	
	public static int[] append(int[] a, int b)
	{
		int[] n = new int[a.length+1];
		for(int i =0; i<n.length; i++)
			n[i] = i<n.length-1?a[i]:b;
		return n;
	}
	
	public static int[][] append(int[][] a, int[][] b)
	{
		int[][] n = new int[a.length + b.length][0];
		for(int i=0; i<n.length; i++)
		{
			n[i] = i<a.length?a[i]:b[i-a.length];
		}
		return n;
	}
	
	public static boolean isPrime(long n)
	{
		double rt = Math.sqrt(n);
		for(int i=2; i<=rt; i++)
			if(n%i==0)
				return false;
		return true;
	}
	
	public static void Print2d(int[][] a)
	{
		System.out.print("{ ");
		for(int i=0; i<a.length; i++)
		{
			System.out.print("{");
			for(int j =0; j<a[i].length; j++)
			{
				String s = j==a[i].length-1? ""+a[i][j]: a[i][j] +",";
				System.out.print(s);
			}
			System.out.print("} ");
		}
		System.out.println("}");
	}
	
}
