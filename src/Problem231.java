import java.util.ArrayList;


public class Problem231 {
	public static void main(String[] args)
	{
		int n = 20000000;
		int r = 15000000;
		ArrayList<Integer> primes = Sieve(n);
		long sum =0;
		for(int i=0; i<primes.size(); i++)
		{
			int cp = primes.get(i);
			sum += cp * (apprange(cp, n) - apprange(cp,r) - apprange(cp, n-r));
		}
		System.out.println(sum);
	}
	
	public static long apprange(int p, int u)
	{
		/*
		 * Returns the number of times p appears in the prime
		 * factorizations of all the numbers from 2 through u.
		 * Example: apprange(2,10)
		 *	multiples of 2^1 appear 5 times <=10: {2,4,6,8,10}
		 *	multiples of 2^2 appear 2 times <=10: {4,8}
		 *	multiples of 2^3 appear 1 times <=10: {8}
		 * 5+2+1 = 8 
		 * thus 2 will appear 8 times in the prime factorization of 10!
		 */
		long c =0;
		long m =p;
		while(m <= u)
		{
			c += u/m; //number of multiples of m that are  <= u
			m*=p;
		}
		return c;
	}
	
	public static ArrayList<Integer> Sieve(int n)
	{
		//returns a list of primes from 0 to n inclusive
		ArrayList<Integer> primes = new ArrayList<Integer>(0);
		boolean[] p = new boolean[n+1];
		for(int i=0; i<p.length; i++) p[i] =true;
		p[0] =false; p[1] = false;
		for(int i=2; i<p.length; i++)
		{
			if(p[i]) 
			{	
				primes.add(i);
				for(int j =2*i; j<p.length; j+=i)
				{
					p[j] =false;
				}
			}
			else continue;
		}
		return primes;
	}
	
}
