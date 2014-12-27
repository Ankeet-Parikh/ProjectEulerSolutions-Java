package problems_40_49;

import java.util.Arrays;

public class Problem49 {
	public static void main(String[] args)
	{
		boolean primes[] = Sieve(9999);
		
		int s =0, m =0;
		boolean done=false;
		for(int i =1489; i<primes.length;i+=2)
		{
			if(primes[i])
			for(int j =i+2;j<primes.length;j+=2)
			{
				int k = i+2*(j-i);
				if(k>=primes.length)break;
				if(primes[j]&&primes[k]&&isPermutation(i,j)&&isPermutation(i,k))
				{
					done= true;
					s=i;
					m =j-i;
					break;
				}
			}
			if(done) break;
		}
		System.out.println(s +""+(s+m)+""+(s+2*m));
	}
	public static boolean isPermutation(long a1, long b1)
	{
		char[] a =(a1+"").toCharArray(); Arrays.sort(a);
		char[] b =(b1+"").toCharArray(); Arrays.sort(b);
		return (new String(a)).equals(new String(b));
		
	}

	public static boolean[] Sieve(int n)
	{
		boolean[] b = new boolean[n+1];
		for(int i=0;i<b.length;i++)
			b[i] =true;
		b[0]=false;b[1] =false;
		for(int i =2; i<b.length; i= i!=2 ? i+2:i+1)
		{
			if(b[i])
			{
				
				for(int j=i+i;j<b.length; j+=i)
					b[j] =false;
			}
		}
		return b;
	}
	
}
