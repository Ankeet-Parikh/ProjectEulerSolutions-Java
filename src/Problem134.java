


import java.util.BitSet;

public class Problem134 {
	public static void main(String[] args)
	{
		
		int range=1000000;
		BitSet primes = Sieve(range+10);
		
		int p1 = 5, p2 =7;
		
		long sum =0;
		while(p1 <=range)
		{
			long min = S(p1,p2);
			sum +=min;
			p1 = p2;
			p2 = primes.nextSetBit(p2+1);
		}
		
		System.out.println(sum);
		
	}
	
	public static long S(long p1, long p2)
	{
		//last digits are formed by p1 and divisible by p2
		long mult =0;
		int p1length = ("" +p1).length();
		
		for(int i =1; i <=p1length; i++)
		{
			long mod = (long)Math.round(Math.pow(10,i));
			long target = p1%mod;
			for(int j =0; j<10;j++)
			{
				long multiplier = (long) (j*(Math.pow(10,i-1))+mult);
				if((p2*multiplier)%mod == target)
				{
					mult = multiplier;
					break;
				}
			}
			
		}
		return mult*p2;
		
	}
	
	public static BitSet Sieve(int n)
	{
		BitSet b = new BitSet(n+1);
		b.set(0,n,true);//set all the values to true
		b.set(0,false);
		b.set(1,false);
		for(int i =2;i*i<=n;i++)
		{
			for(int j =i;i*j<=n;j++)
			{
				b.set(i*j,false);
			}
		}
		return b;
	}
}
