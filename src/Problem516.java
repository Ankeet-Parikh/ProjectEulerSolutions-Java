import java.util.ArrayList;
import java.util.Collections;
import java.math.BigInteger;

public class Problem516 {
	static ArrayList<Long> ph = new ArrayList<Long>(0);
	static long sum = 0;
	static long max = (long)1e12;
	static long mod = (long)Math.pow(2,32);
	public static void main(String[] args)
	{
		/*
		 * We need all the primes p less than max such that p-1 is a hamming number
		 * Lets call this set PH
		 * To satisfy the property that totient(n) is a hamming number, n must contain 2, 3, 5 as may times
		 * each, and any other p in PH at most once.
		 * To do this, iterate over the powers of 2, 3 and 5, generate all the hamming numbers, add one and test if prime.
		 */
		ph.add(2L);
		//ph.add(3L);
		//ph.add(5L);
		
		for(int i=1; Math.pow(2,i)<=max ;i++) //we only generate even hamming numbers, then add one to make it odd
		{
			long a = (long)Math.pow(2,i);
			for(int j =0; Math.pow(3, j) <=max ;j++)
			{
				long b = (long)Math.pow(3, j);
				for(int k=0; Math.pow(5, k)<=max ;k++)
				{
					long c = (long)Math.pow(5, k);
					long prod = a*b*c;
					if(prod >= max) break;
					long pr = prod+1;
					if(new BigInteger(""+pr).isProbablePrime(30))
					{
						ph.add(pr);
					}
				}
			}
		}
		Collections.sort(ph);
		//System.out.println(ph);
		//System.out.println(ph.size());
		FindProp(0, 1);
		//System.out.println(sum);
	
		System.out.println(sum%mod);
		
	}
	
	public static void FindProp(int index, long currprod)
	{
		long curr = ph.get(index);
		long rem = max/currprod;
		int u = 1; //upper exponent 
		if(rem < curr)
		{	
			sum+=currprod;
			return;
		}
		if(curr == 2 || curr == 3 || curr == 5)
		{
			u = (int)(Math.log(rem)/Math.log(curr));
		}
		
		for(int i =0; i<=u; i++)
		{
			long nprod = currprod*(long)(Math.pow(curr, i));
			if(index == ph.size()-1)
			{
				if(nprod <=max)
				{
					sum+=nprod;
					//System.out.println(nprod);
				}
			}
			else
			{
				FindProp(index+1, nprod);
			}
		}
	}
}
