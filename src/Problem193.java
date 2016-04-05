import java.math.BigInteger;


public class Problem193 {
	/*
	 * Need to find the number of squarefree numbers below 2^50
	 * There are 8 squarefree numbers below 12: 1,2,3,5,6,7,10,11
	 * 
	 * Solution: (consider the upper bound inclusive, it is easier that way)
	 * How many numbers up to 40 are divisible by 2^2:
	 * 40/2^2 = 10
	 * How many numbers up to 40 are divisible by 3^2:
	 * 40/3^2 = 4 (integer division)
	 * How many numbers up to 40 are divisible by 5^2:
	 * 40/5^2 = 1
	 * 
	 * Notice that 36 was double counted, it is divisible by both 2^2 and 3^2.
	 * To account for this, we need to break out the inclusion/exclusion principle.
	 * Let us consider 12, which is greater than 2^2 and 3^2:
	 * 
	 * non squarefree up to 12: 12/2^2 + 12/3^2 - 12/(2^2*3^2)
	 * Notice the form is n*(1/p1^2 + 1/p2^2 - 1/(p1^2*p2^2))
	 * Upto 40, the number of non squarefree are:
	 * 40*(1/2^2 + 1/3^2 + 1/5^2 - 1/(2^2*3^2) - 1/(2^2*5^2) - 1/(3^2*5^2) + 1/(2^2*3^2*5^2))
	 * 
	 * Generally speaking, the fractions of the form
	 * 1/p1^2 have a coefficient of 1
	 * 1/(p1^2*p2^2) have a coefficient of -1
	 * 1/(p1^2*p2^2*p3^2) have a coefficient of 1
	 * and -1,1,-1, and so on.
	 * 
	 */
	static long u = (long)Math.pow(2,50)-1;
	static long s = 0;
	static int pl[] = new int[0]; //will store a list of primes
	public static void main(String[] args)
	{
	
		int r = (int)Math.sqrt(u);
		
		boolean[] p = new boolean[r+1];
		for(int i=2; i<p.length; i++)
		{
			p[i] = true;
		}
		
		//prime sieve
		int pp = 0;
		for(int i=2; i<p.length; i++)
		{
			if(p[i])
			{
				pp++;
				for(int j= 2*i; j<p.length; j+=i)
				{
					p[j] = false;
				}
			}
		}
		pl = new int[pp];
		for(int i=0, j = 0; i<p.length; i++)
		{
			if(p[i])
			{
				pl[j] = i;
				j++;
			}
		}
		//i<n, n indicates the number of prime squares being multiplied together
		for(int i=0; i<10; i++) 
		{
			dfs(1,i+1,0, i+1);
		}
		System.out.println(u-s);
		
		
	}
	
	
	public static void dfs(long prod, int tot, int start, int rem)
	{
		for(int i=start; i<pl.length-rem+1; i++)
		{
			long next = prod*pl[i]*pl[i];
			if(prod*pl[i] > u) break;
			if((double)prod * pl[i] *pl[i] > u)  break;
			if(rem == 1)
			{
				s =  s + (long)(Math.pow(-1, tot+1)) * (u/next);
			}
			else
			{
				dfs(next, tot, i+1, rem-1);
			}
		}
	}

}
