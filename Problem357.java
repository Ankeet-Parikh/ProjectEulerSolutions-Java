package problems_350_359;



//Solved  Ans:1739023853137  

import java.util.BitSet;



public class Problem357 {

	
	public static void main(String[] args) {
		
		int range = 100000000;
		long sum =1; 
		BitSet b = Sieve(range);
		for(int i =2; i< range; i+=2)
		{
			if(hasProperty(i , b))
			{
				sum+=i;
				
			}
		}
		System.out.println(sum);

	}

	public static boolean hasProperty(int n, BitSet primes)
	{
		for(int i = 1; i<= Math.pow(n, 0.5); i++ )
		{
			if(n%i ==0 && !primes.get(i+n/i))
				return false;
		}
		return true;
	}
	public static BitSet Sieve(int n)//returns primality from 0<=i<=n
	{
		BitSet b = new BitSet();
		//set them all to true;
		for(int i =0; i < n; i++)
		{
			b.set(i, true);
		}
		b.clear(0);
		b.clear(1);
		
		for(int i =2; i*i<=n  ; i++)
		{
			for(int j =i; i*j <= n ;j++)
			{
				
				b.clear(i*j);
			}
		}
		
		return b;
	}

}
