import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;


public class Problem401 {
	/*
	 * SIGMA2(n) = sum(i = 1...n of i^2 * Floor(n/i))
	 */
	static long mod = 1000000000L;
	static BigInteger modulo = new BigInteger(""+mod);
	static BigInteger s = new BigInteger("6");
	static BigInteger o = BigInteger.ONE;
	static BigInteger t = o.add(o);
	public static void main(String[] args)
	{
		long val = (long)1e4;
		//val = 29384798798L;
		System.out.println(SIGMA2(val));

		
	}
	
	public static long SIGMA2(long n)
	{
		long sum = 0;
		long sqrt = (long)Math.sqrt(n);
		for(long i =1; i<=sqrt; i++)
		{
			sum+=(((i*i)%mod)*(n/i))%mod;
		}
		System.out.println(sum);
		for(long i = 1; i<= sqrt; i++)
		{
			long u = n/i;
			long l = n/(i+1);
			l = l+1;
			if(l <= sqrt) l = sqrt+1;
			if(l>u) break;
			long add = ((n/u)*((SS(l-1, u))%mod))%mod;
			sum+= add;
			sum%=mod;
			//System.out.println(i + " " + l + " " + u + " " + add);
			if(l == sqrt +1) break;
			
		}
		return sum%mod;
	}
	public static long SS(long a, long b)
	{
		BigInteger res = SumSquares(b).subtract(SumSquares(a));
		return res.mod(modulo).longValue();
	}
	public static BigInteger SumSquares(long v)
	{
		//returns the sum of i^2 from 1 to n
		
		/*
		 * Formula:
		 * 1/6*m*(1+m)*(1+2*m)
		 */
		
		BigInteger m = new BigInteger("" +v);
		BigInteger k = m.add(o);
		k = m.multiply(k);
		BigInteger n = o.add(t.multiply(m));
		k = k.multiply(n);
		k = k.divide(s);
		return k;
	}
	
	
}
