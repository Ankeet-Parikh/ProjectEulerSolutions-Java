import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Problem273 {
	static HashMap<Integer, Integer[]> hp = new HashMap<Integer, Integer[]>(); //stores (5, {1,2}) and (13, {2,3}) for example
	public static void main(String[] args)
	{
		/*
		 * a^2 + b^2 = N
		 * c^2 + d^2 = M
		 * We can write the product NM in terms of a,b,c,d:
		 * NM = (a^2 + b^2)(c^2 + d^2)
		 * NM = a^2c^2 + a^2d^2 + b^2c^2 + b^2d^2
		 * NM = (a^2d^2 + 2abcd + b^2c^2) + (a^2c^2 - 2abcd + b^2d^2)
		 * NM = (ad+bc)^2 + (ac-bd)^2
		 * we can also write NM as:
		 * NM = (ac+bd)^2 + (ad-bc)^2
		 * 
		 * For Example:
		 * N = 5 = 1^2 + 2^2
		 * M = 13 =2^2 + 3^2
		 * NM = 65 = 7^2 + 4^2 = 8^2 + 1^2
		 */
		double s = System.currentTimeMillis();
		ArrayList<Integer> p = SpecSieve(150);
		for(int i=0; i<p.size(); i++) 
		{
			
			//System.out.print(p.get(i) + " ");
			SP(p.get(i));
		}
		//System.out.println("");
		long sum =0;
		for(int i = 1; i<=p.size(); i++)
		{
			int[][] ind = replist(16,i,null);
			for(int j = 0; j<ind.length; j++)
			{
				int[] primes = new int[ind[j].length];
				for(int k = 0; k < ind[j].length; k++)
				{
					primes[k] = p.get(ind[j][k]);
				}
				sum+=SumA(primes);
			}
		}
		System.out.println(sum);
		System.out.println((System.currentTimeMillis()-s)/1000+" seconds");
		
	}
	public static long SumA(int[] primes)
	{
		
		if(primes.length == 1) return hp.get(primes[0])[0];
		else
		{
			Integer[] tuple = hp.get(primes[0]);
			long[][] t = new long[1][2];
			for(int i =0; i<t[0].length; i++) t[0][i] = tuple[i];
			
			for(int i = 1; i<primes.length; i++)
			{
				Integer[] ptuple = hp.get(primes[i]);
				int c = ptuple[0];
				int d = ptuple[1];
				long[][] next = new long[2*t.length][2];
				for(int e = 0; e<t.length; e++)
				{
					/*
					 * a = t[e][0] b = t[e][1]
					 * (ad+bc) (bd-ac)
					 * (ac+bd) (ad-bc)
					 */
					long a = t[e][0], b = t[e][1];
					next[2*e][0] = a*d+b*c;
					next[2*e][1] = pos(b*d-a*c);
					next[2*e+1][0] =a*c+b*d;
					next[2*e+1][1] = pos(a*d-b*c);
				}
				t = next;
			}
			//Print2d(t);
			long res = 0;
			for(int i=0; i<t.length; i++)
				{	
					Arrays.sort(t[i]);
					res+=t[i][0];
				}
			return res;
		}
		
	}
	public static int SP(int n)
	{
		Integer[] ab = new Integer[2];
		int sa = 0;
		for(int a = 1; a<=Math.sqrt(n/2.0); a++)
		{
			int m = a*a;
			int b = (int)Math.sqrt(n-m);
			if(m + b*b ==n)
			{
				ab[0] = a; ab[1] = b;
				sa+=a;
			}
		}
		hp.put(n, ab);
		return sa;
	}
	public static int[][] replist(int nd, int e, int[] prev)
	{
		/*
		 * Used in Problem51
		 * Generates all e element subsets from a list of {1, ... ,nd}
		 * For example calling replist(3,2,null) will return:
		 * {{0,1}, {0,2}, {1,2}}
		 */
		
		boolean init = prev == null;
		int s = init? 0 : prev[prev.length-1]+1;
		int max = nd-e;
		int[][] toreturn = new int[0][0];
		if(e == 1)
			toreturn = new int[max-s+1][0];
		for(int i =0; s<=max; s++, i++)
		{
			if(init)
			{
				prev = new int[1];
				prev[0] = i;
			}
			if(e == 1) toreturn[i] = init?prev:append(prev, s);
			else
			{
				int[] next = init?prev:append(prev, s);
				int[][] c = replist(nd, e-1, next);
				if(i == 0) toreturn =c;
				else toreturn = append(toreturn, c);
			}
		}
		return toreturn;
		
	}
	public static ArrayList<Integer> SpecSieve(int ub)
	{
		//Sieves all primes of 4K+1 up to ub
		ArrayList<Integer> primes =new ArrayList<Integer>(0);
		int r = ub;
		boolean[] p = new boolean[r+1];
		for(int i = 2; i<p.length; i++) p[i] = true;
		for(int i = 2; i<p.length; i++)
		{
			if(p[i])
			{
				if((i-1)%4 == 0) 
					{
						//System.out.print(i + "*");
						primes.add(i);
					}
				for(int j = 2*i; j<p.length; j+=i)
				{
					p[j] = false;
				}
			}
		}
		return primes;
	}
	public static long pos(long a)
	{
		return a<0?-a:a;
	}
	public static int[] append(int[] a, int b)
	{
		int[] j = new int[a.length+1];
		for(int i=0; i<j.length; i++)
		{
			j[i] = i<a.length?a[i]:b;
		}
		return j;
	}
	public static int[][] append(int[][] a, int[][] b)
	{
		int[][] c = new int[a.length+b.length][0];
		for(int i = 0; i<c.length; i++)
		{
			c[i] = i <a.length?a[i]:b[i-a.length];
		}
		return c;
	}
	public static void Print1d(Integer[] a)
	{
		System.out.print("{");
		for(int i =0; i<a.length; i++)
		{
			System.out.print(a[i]);
			if(i <a.length-1) System.out.print(", ");
		}
		System.out.print("}");
	}
	public static void Print1d(int[] a)
	{
		System.out.print("{");
		for(int i =0; i<a.length; i++)
		{
			System.out.print(a[i]);
			if(i <a.length-1) System.out.print(", ");
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
