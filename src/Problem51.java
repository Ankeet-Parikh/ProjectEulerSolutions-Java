import java.util.ArrayList;


public class Problem51 {
	static int[] primes = new int[0]; //size is arbitrary, will be changed
	public static void main(String [] args)
	{
		int range = (int)1e2; //the upper bound is just a guess
		primeSieve(range);
		//for each prime, we will determine
		
		
		
		
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
	
	public static void primeSieve(int n) //generates a list of primes up until n and stores them in primes
	{
		boolean[] p = new boolean[n+1];
		for(int i=0; i<p.length; i++)p[i] =true;
		p[0] = false;
		p[1] = false;
		for(int i=2; i<p.length; i++)
		{
			for(int j = i*2; j<p.length; j+=i)
			{
				p[j] = false;
			}
		}
		ArrayList<Integer> pr = new ArrayList<Integer>(0); //will store the primes, but we don't know how many there are
		for(int i=0; i<p.length; i++)
			if(p[i])
				pr.add(i);
		primes = new int[pr.size()];
		for(int i=0; i<primes.length; i++)
			primes[i] = pr.get(i);
		
		
	}
	public static boolean isPrime(long n)
	{
		/*
		 * Here, we optimize trial division by using the list of primes.
		 * This only works if the number does not exceed the maximum value in primes
		 */
		for(int i= 0; i<primes.length; i++)
		{
			int p = primes[i];
			if(p>Math.sqrt(n))
				return true;
			if(n%p == 0)
				return false;
		}
		return true;
		
	}
	public static void Print1d(int[] a)
	{
		System.out.print("{");
		for(int i=0; i<a.length; i++)
		{
			if(i<a.length - 1) System.out.print(a[i] +",");
			else System.out.print(a[i]);
		}
		System.out.print("}");
		
	}
	public static void Print2d(int[][] a)
	{
		System.out.print("{");
		for(int i=0; i<a.length; i++)
		{
			Print1d(a[i]);
			if(i<a.length-1) System.out.print(",");
		}
		System.out.println("}");
	}
	
}
