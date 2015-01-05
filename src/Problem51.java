import java.util.ArrayList;


public class Problem51 {
	static int[] primes = new int[0]; //size is arbitrary, will be changed
	public static void main(String [] args)
	{
		int range = (int)1e6; //the upper bound is just a guess
		primeSieve(range);
		/*
		 * To solve this problem, we will go through each prime, do each possible replacement, and
		 * see which primes are in the prime family. If the prime family list is equal to 8, then 
		 * we print the smallest prime, otherwise continue.
		 */
		int tfs = 8; //tgf: "target family size"
		int result =0;
		boolean found =false;
		int[][] replacements = new int[0][0];//the size will be changed as necessary
		
		for(int i=0; i<primes.length; i++)
		{
			int p = primes[i]; //current prime
			int plength = (int)(Math.log10(p) +1);
			if(plength != replacements.length) //if p has one more digit than the p before it
			{
				for(int j=1; j<=plength; j++) //generates all the replacements for a plength-digit number
				{
					replacements = j==1?replist(plength, j, null): append(replacements,replist(plength, j, null));
				}
			}
			
			for(int j=0; j<replacements.length; j++)//go through each possible replacement
			{
				int[] family = new int[0];
				for(int k =0; k<=9; k++)//go through the integers 1-9
				{
					int val = replace(p,k, replacements[j]);
					if(((int)Math.log10(val) == (int)Math.log10(p)) && isPrime(val))
					{
						if(family.length ==0) 
						{
							family = new int[1];
							family[0] =val;
						}
						else family = append(family, val);
					}
				}
				found = family.length == tfs;
				if(found) 
				{
					Print1d(family);
					System.out.println("");
					result = family[0];
					break;
				}
			}
			if(found) break;
		}
		System.out.println(result);
		
		
		
		
	}
	
	public static int replace(int n, int d,  int[] ind)
	{
		char[] a = String.valueOf(n).toCharArray();
		for(int i=0;i<ind.length; i++)
			a[ind[i]] =(char)(d+48); //48 corresponds to zero, 49 to 1, 50 to 2 
		return Integer.parseInt(new String(a));
		
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
			if(p> Math.sqrt(n))
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
