import java.math.BigInteger;
public class Problem113 {
	public static void main(String[] args)
	{
		/*
		 * number of increasing numbers less than 10^n: (10+n-1 choose n) -1
		 * number of decreasing numbers less than 10^n: (10+n choose n) -n - 1
		 * number of elements in both sets: 9*n
		 * final answer is number of increasing+number of decreasing - 9*n
		 */
		int n = 100;
		BigInteger inc = choose(10+n-1,n).subtract(BigInteger.ONE);
		BigInteger dec = choose(10+n, n).subtract(new BigInteger("" + (n+1)));
		System.out.println(inc.longValue()+dec.longValue()-9*n);
	}
	public static BigInteger choose(long n, long k)
	{
		BigInteger c = factorial(n);
		c = c.divide(factorial(k));
		c = c.divide(factorial(n-k));
		return c;
	}
	public static BigInteger factorial(long n)
	{
		if(n <= 1) return new BigInteger("1");
		return new BigInteger(""+n).multiply(factorial(n-1));
	}
	public static boolean nb(int n)
	{
		//preliminary testing
		if(n <=0 ) return false;
		if(n < 10) return true; 
		return increasing(n) || decreasing(n);
	}
	public static boolean increasing(int n)
	{
		int prev = n%10;
		n/=10;
		while(n > 0)
		{
			int m = n%10;
			if(m > prev) return false;
			prev = m;
			n/=10;
		}
		return true;
	}
	public static boolean decreasing(int n)
	{
		int prev = n%10;
		n/=10;
		while(n > 0)
		{
			int m = n%10;
			if(m < prev) return false;
			prev = m;
			n/=10;
		}
		return true;
	}
}
