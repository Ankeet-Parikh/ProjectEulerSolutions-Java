import java.math.BigInteger;


public class Problem123 {
	public static void main(String[] args)
	{
		long rem = (long)1e10;
		int range = (int)Math.pow(10, Math.log10(rem)/2 +1);
		boolean[] p = new boolean[range];
		for(int i=2; i<p.length; i++) p[i] = true;
		
		int n = 0;
		for(int i=2; i<p.length; i++)
		{
			if(p[i])
			{
				n++;

				if(n%2 == 1)
				{
					long r = remainder(i,n);
					if(r > rem)
					break;
				}
				for(int j = 2*i; j<p.length; j+=i)
				{
					p[j] = false;
				}
			}
		}
		System.out.println(n);
		
	}
	
	public static long remainder(long p, long n)
	{
		//returns ((p-1)^n + (p+1)^n) % p*p
		BigInteger a = new BigInteger(""+(p-1));
		BigInteger b = new BigInteger(""+(p+1));
		BigInteger mod = new BigInteger(""+p*p);
		BigInteger exp = new BigInteger(""+n);
		a = a.modPow(exp, mod);
		b = b.modPow(exp, mod);
		a = a.add(b);
		a = a.mod(mod);
		return a.longValue();
	}
}
