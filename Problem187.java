package src;
import java.util.ArrayList;
import java.util.BitSet;

public class Problem187{
	
	public static void main(String[] args)
	{
		double s = System.currentTimeMillis();
		int range =100000000;
		ArrayList<Integer> p = primeHalfSieve(range);
		int count=0;
		for(int i=0; i<p.size(); i++)
		{
			for(int j=i; j<p.size();j++ )
			{
				if((long)p.get(i)*p.get(j) > range)
					break;
				count++;
			}
		}
		System.out.println(count);
		double e = System.currentTimeMillis();
		System.out.println((e-s)/1000 + " seconds");
	}
	
	public static ArrayList<Integer> primeHalfSieve(int n)
	{
		
		n/=2; //only need half of them
		
		///use the sieve of Euler to find the primes, so we need to remove the evens
		BitSet p = new BitSet(n+1);
		
		p.clear();
		for(int i=2; i <p.size(); i++)
		{
			p.set(i,true);
		}
		ArrayList<Integer> h = new ArrayList<Integer>(0);
		
		for(int i=2; i<=n; i++)
		{
			for(int j = i+i; j<=n; j+=i)
			{
				p.set(j, false);
			}
		}
		for(int i =0; i<=n; i++)
		{
			if(p.get(i)) h.add(i);
		}
		return h;
		
	}
	
}