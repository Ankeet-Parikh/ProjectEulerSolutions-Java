import java.math.BigInteger;


public class Problem291 {
	static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	public static void main(String[] args){
		/*
		for(long y = 1; y<50000; y++)
		{
			for(long x= y+1; x<50*y;x++)
			{
				long n = x*x*x;
				long d = x*x-x*y+y*y;
				if(n%d == 0 && n > d)
				{
					long p = n/d - y;
					if(new BigInteger(""+p).isProbablePrime(4))
						System.out.println(x + " " + y+ " " + p);
					
				}
			}
		}*/
		/*
		for(long y = 1;y<500000 ;y++)
		{
			for(long c = 2;c<5000;c++)
			{
				long n = y * (c*c+1)*(c-1);
				long d = c*c-c+1;
				if(n%d == 0)
				{
					long p = n/d;
					if(new BigInteger(""+p).isProbablePrime(20))
						System.out.println(y + " " + c + " " +n/d);
				}
					
			}
		}*/
		double s = System.currentTimeMillis();
		long max = (long)5e15;
		//max = 500000;
		System.out.println(max);
		long c =0;
		for(long n = 1; ;n++)
		{
			long p = 2*n*(n+1)+1;
			
			if(p > max) break;
			
			if(isPrime(p))
			{
				//System.out.println(p);
				//System.out.println(n);
				c++;
			}
			
		}
		System.out.println(c);
		System.out.println((System.currentTimeMillis()-s)/1000 +" seconds");
	}
	
	public static boolean isPrime(long n)
	{
		
		for(int i=0; i<primes.length; i++)
		{
			
			if(n%primes[i] ==0  && n != primes[i])return false;
		}
		return new BigInteger(""+n).isProbablePrime(20);
		
	}
	public static long e(long x, long y)
	{
		//returns x^y
		return (long) Math.pow(x,y);
	}
	public static long p(long x, long y)
	{
		BigInteger a = new BigInteger(""+x);
		BigInteger b = new BigInteger(""+y);
		return ((a.pow(4).subtract(b.pow(4))).divide(a.pow(3).add(b.pow(3)))).longValue();
	}
}
