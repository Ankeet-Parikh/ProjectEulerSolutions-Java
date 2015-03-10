import java.math.BigInteger;


public class Problem304 {
	public static void main(String[] args)
	{
		double s = System.currentTimeMillis();
		long mod = 1234567891011L;
		long[] a = {1, 1, 1,0 };
		
		long sum =0;
		for(long p =100000000000031L, i =0;i<100000; p+=2)
		{
			BigInteger curr = new BigInteger("" + p);
			if(curr.isProbablePrime(2))
			{
				sum += ModExp(a,p, mod)[2];
				sum%=mod;
				i++;
			}
		}
		System.out.println(sum%mod);
		System.out.println((System.currentTimeMillis()-s)/1000 + " seconds");
		
	}
	public static long[] MMultMod(long[] a, long[] b, long modulo)
	{
		/*
		 * a and b both consist of 4 elements
		 */
		BigInteger m = new BigInteger(String.valueOf(modulo));
		BigInteger a0 = new BigInteger("" + a[0]);
		BigInteger a1 = new BigInteger("" + a[1]);
		BigInteger a2 = new BigInteger("" + a[2]);
		BigInteger a3 = new BigInteger("" + a[3]);
		BigInteger b0 = new BigInteger("" + b[0]);
		BigInteger b1 = new BigInteger("" + b[1]);
		BigInteger b2 = new BigInteger("" + b[2]);
		BigInteger b3 = new BigInteger("" + b[3]);
		
		long[] p = new long[4];
		p[0] =(a0.multiply(b0).add(a1.multiply(b2))).mod(m).longValue();
		p[1] =(a0.multiply(b1).add(a1.multiply(b3))).mod(m).longValue();
		p[2] =(a2.multiply(b0).add(a3.multiply(b2))).mod(m).longValue();
		p[3] =(a2.multiply(b1).add(a3.multiply(b3))).mod(m).longValue();
		return p;
	}
	public static long[] ModExp(long[] A, long e, long mod)
	{
		if(e == 0)
		{
			long[] n = {1,0,0,1};
			return n;
		}
		if(e%2 == 1)
		{
			long[] n = MMultMod(A, ModExp(A, e-1, mod), mod);
			return n;
		}
		long[] D = ModExp(A, e/2, mod);
		return MMultMod(D,D, mod);
		
	}

	
}
