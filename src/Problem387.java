import java.math.BigInteger;


public class Problem387 {
	static long max = (long)1e14;
	public static void main(String[] args)
	{
		System.out.println(F(0,0));
	}
	
	public static long F(long prev, long sd)
	{
		long sum =0;
		int i =0;
		if(prev == 0) i++;
		for(;i<=9;i++)
		{
			long curr = Long.parseLong("" + prev +"" +i);
			if(curr >= max)return sum;
			if(isPrime(curr))
			{
			
				if( curr > 10 && isPrime(prev/sd))
				{
					sum+=curr;
					//System.out.println(curr);
				}
			}
			if(curr % (sd+i) == 0)
			{
				sum+=F(curr, sd+i);
			}
			
		}
		return sum;
	}
	
	public static boolean isPrime(long n)
	{
		/*
		 * Fastest way to test for primality with large numbers
		 */
		return new BigInteger(""+n).isProbablePrime(10);
	}
	
}
