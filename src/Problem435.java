/*
 * F_n(x) = Sum(f(i)x^i) from 0<=i<=n
 * where f(i) = f(i-1) +f(i-2) and f(0) = 0 and f(1) = 1
 * 
 * I derived the next step (it is not hard to do so):
 * F_n(x) - x*F_n(x) - x^2 * F_n(x) = x - f(n+1) * x^(n+1) - f(n)*x^(n+2)
 * Factoring out F_n(x) we get:
 * F_n(x) = (f(n)*x^(n+2) + f(n+1)*x^(n+1) - x)/(x^2+x-1)
 * 
 * We need to compute this fraction modulo 15!
 * So, knowing that a/b is an integer, what is (a/b) mod m?
 * There is a formula for this:
 * (a/b) mod m = ((a mod m) * (b^-1 mod m)) mod m
 */
import java.math.BigInteger;
public class Problem435 {
	static long mod = 1307674368000l;
	
	public static void main(String[] args)
	{

			
		long sum = 0;
		long n = 1000000000000000L;
		for(int i=0; i<=100; i++)
		{
			sum += F(n,i);
			sum%=mod;
		}
		System.out.println(sum%mod);
		
	}
	
	public static long F(long n, long x)
	{
		if(x == 0) return 0;
		long denom = x*x+x-1;
		long newmod = denom*mod;
		long f[] = FibMod(n+1, newmod);
		long f1 = f[0];
		long f2 = f[1];
		
		
		long x1 = modexp(x, n+2, newmod);
		long x2 = modexp(x, n+1, newmod);
		long num = (multiply(f1, x1, newmod) + multiply(f2, x2, newmod) - x +newmod) % newmod;
		return num/denom;
	}
	public static long modexp(long a, long b, long m) //returns a^b mod n. In this case n = 15!
	{
		if(b == 0) return 1;
		if(b == 1) return a;
		if(b%2 == 0) return modexp(multiply(a, a, m), b/2, m);
		//"else if oddd"
		return multiply(a , modexp(multiply(a, a, m), (b-1)/2, m), m);
	}
	/*
	 * Computation of fibonacci numbers modulo mod (defined above) in logarithmic time
	 * FibMod(n) returns [f(n-1), f(n)] where f(i) is the ith fibonacci number f(0) = 0, f(1) = 1
	 */
	public static long[] FibMod(long n, long m)
	{
		if(n == 1)
			return new long[]{0, 1};
		
			if(n%2 == 0)
			{
				long bf[] = FibMod(n/2, m);
				long c[] = new long[2];
				c[0] = (multiply(bf[0], bf[0], m) + multiply(bf[1], bf[1], m)) %m;
				c[1] = multiply(2*bf[0] + bf[1], bf[1], m);
				return c;
			}
			if(n%2 == 1)
			{
				long bf[] = FibMod((n+1)/2, m);
				long c[] = new long[2];
				c[0] = (multiply(bf[0], bf[0], m) + multiply(bf[1], bf[1], m)) %m;
				c[1] = multiply(2*bf[0] + bf[1], bf[1], m);
				//so far c is [f(n), f(n+1)]
				long tmp = c[1] - c[0];
				c[1] = c[0];
				c[0] = tmp;
				return c;
			}
			return null;
	}
	//returns a*b mod n
	public static long multiply(long a, long b, long m)
	{
		BigInteger i = new BigInteger(""+a);
		BigInteger j = new BigInteger(""+b);
		return i.multiply(j).mod(new BigInteger("" + m)).longValue();
	}
	
	
	public static long Brute(long n, long x, long m)
	{
		BigInteger bn = new BigInteger("" + n), bx = new BigInteger("" + x), bm = new BigInteger("" + m);
		BigInteger s = new BigInteger("0");
		long a = 0, b = 1;
		for(int i = 1; i<=n; i++)
		{
			BigInteger coeff = new BigInteger("" + b);
			BigInteger p = new BigInteger("" + x).pow(i);
			s = s.add(coeff.multiply(p));
			s = s.mod(bm);
			long tmp = a+b;
			a = b;
			b = tmp;
		}
		return s.mod(bm).longValue();
	}
}
