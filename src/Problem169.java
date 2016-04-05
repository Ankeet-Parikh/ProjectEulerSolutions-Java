import java.math.BigInteger;
public class Problem169 {
	static BigInteger two = new BigInteger("2");
	public static void main(String[] args)
	{
		System.out.println(a(new BigInteger("10000000000000000000000001"))[0]);
	}
	//returns {a(n), and a(n+1)}
	public static long[] a(long n)
	{
		if(n == 0) return new long[]{0, 1};
		if(n%2 == 0)
		{
			long[] p = a(n/2);
			return new long[]{p[0], p[0]+p[1]};
		}
		else
		{
			long[] p = a((n-1)/2);
			return new long[]{p[0]+p[1], p[1]};
		}
	}
	
	public static BigInteger[] a(BigInteger n)
	{
		if(n.compareTo(BigInteger.ZERO) == 0)
		{
			BigInteger[] r = {BigInteger.ZERO, BigInteger.ONE};
			return r;
		}
		if(n.mod(two).compareTo(BigInteger.ZERO) == 0)
		{
			BigInteger[] p = a(n.divide(two));
			BigInteger[] r = {p[0], p[0].add(p[1])};
			return r;
		}
		else
		{
			BigInteger[] p = a((n.subtract(BigInteger.ONE)).divide(two));
			BigInteger[] r = {p[0].add(p[1]), p[1]};
			return r;
		}
	}
}
