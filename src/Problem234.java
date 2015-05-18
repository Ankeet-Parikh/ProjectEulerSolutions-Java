import java.math.BigInteger;
import java.util.ArrayList;


public class Problem234 {
	public static void main(String[] args)
	{
		long max = 999966663333L;
		ArrayList<Long> primes = Sieve((int)Math.sqrt(max) +50);
		long sum =0;
		for(int i=0; i<primes.size(); i++)
		{
			long l = primes.get(i);
			long u = primes.get(i+1);
			if(l*l > max) break;
			else
			{
				long lr = l*l + 1;
				long ur = u*u - 1;
				if(ur >= max) ur = max;
				long ps =  sumMults(l,lr, ur)+sumMults(u, lr, ur) - 2*sumMults(l*u, lr, ur);
				sum+=ps;
			}
		}
		System.out.println(sum);
	}
	public static long sumMults(long p, long l, long u)
	{
		/*
		 * Sum of all multiples of p from l to u incluive
		 */
		long lm = (long)Math.ceil((double)l/p);
		long um = u/p;
		return p * (sumTo(lm, um));
	}
	public static long sumTo(long ln, long un)
	{
		//returns the sum of the integers from u to l inclusive
		//use BigInteger to avoid overflow issues
		BigInteger u = new BigInteger(""+ un);
		BigInteger l = new BigInteger(""+ ln);
		BigInteger one = new BigInteger("1");
		BigInteger two = one.add(one);
		u = u.multiply(u.add(one)).divide(two);
		l = l.multiply(l.subtract(one)).divide(two);
		return u.subtract(l).longValue();
	}
	public static ArrayList<Long> Sieve(int n)
	{
		/*
		 * List primality from 0 to n inclusive
		 */
		boolean[] p = new boolean[n+1];
		for(int i=0; i<p.length; i++)p[i] =true;
		p[0] = false; p[1] =false;
		ArrayList<Long> primes = new ArrayList<Long>(0);
		for(int i =2; i< p.length; i++)
		{
			if(p[i])
			{
				primes.add((long)i);
				for(int j = 2*i; j<p.length; j+=i)
					p[j] =false;
			}
		}
		return primes;
	}
}
