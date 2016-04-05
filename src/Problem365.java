/*
 * For each prime p, compute (m choose n) modulo p using Lucas' theorem
 * Then, for each triple of primes, combine the modular congruences
 * using the chinese remainder theorem.
 */

import java.math.*;
import java.util.Arrays;
public class Problem365 {
	
	public static long exp(long a, long b, long m)
	{
		//returns a^b mod m
		if(b == 0) return 1 % m;
		if(b == 1) return a % m;
		long c = exp(a, b/2, m);
		c = (c*c)%m;
		if(b%2 == 1) c = (c*a) %m;
		return c;
	}
	
	public static void main(String[] args)
	{
		long n = 1000000000l;
		long m = n*n;

		double s = System.currentTimeMillis();
		//binmod[i] holds (m choose n) modulo i
		//defined for prime i
		
		long binmod[] = new long[5001];
		for(int i=1000; i<=5000; i++)
		{
			if(new BigInteger(""+i).isProbablePrime(20))
			{
				//System.out.println(i);
				binmod[i] = binmod(m,n,i);
			}
			else
			{
				binmod[i] = -1;
			}
		}
		
		long sum = 0;
		for(int p = 1000; p<4998 ;p++)
		{
			if(binmod[p] == -1) continue;
			for(int q = p+1; q<4999 ;q++)
			{
				if(binmod[q] == -1) continue;
				for(int r = q+1; r<5000;r++)
				{
					if(binmod[r] == -1) continue;
					
					long[] a = {binmod[p], binmod[q], binmod[r]};
					long[] b = {p,q,r};
					long add =crt(a,b);
					sum+=add;
					//System.out.println( p + " " + q + " " + r + " " + add);
				}
			}
		}
		System.out.println(sum);
		
	}
	public static long[][] convto(long m, long n, long p)
	{
		//converts to base p
		int i = 0;
		long k  = p;
		while(k<=m)
			{
				k*=p;
				i++;
			}
		int  j = 0;
		k = p;
		while(k<=n)
		{
			k*=p;
			j++;
		}
		long[][] rep = new long[2][0];
		rep[0] = new long[i+1];
		rep[1] = new long[j+1];
		while(i>=0)
		{
			rep[0][i] = m%p;
			m/=p;
			i--;
		}
		while(j>=0)
		{
			rep[1][j] = n%p;
			n/=p;
			j--;
		}
		return rep;
	}
	
	public static long binmod(long m, long n, long p)
	{
		long prod = 1;
		long[][] rep = convto(m,n,p);
		if(rep[1].length > rep[0].length) //this should never happen
		{
			return 0;
		}
		else
		{
			for(int i=0; i<rep[1].length; i++)
			{
				//compute m_i choose n_i modulo p
				long mi = rep[0][rep[0].length-1-i];
				long ni = rep[1][rep[1].length-1-i];
				if(mi < ni) return 0;
				long[] fac = new long[(int)mi+1];
				fac[0]=1;
				for(int j = 1; j<=mi; j++)
					fac[j] = ((j%p)*fac[j-1])%p;
				long k = fac[(int)mi]*exp((fac[(int)ni]*fac[(int)(mi-ni)])%p, p-2, p);
				k%=p;
				prod*=k;
				prod%=p;
			}
		}
		
		return prod % p;
	}
	
	public static long crt(long[] a , long[] m)
	{
		//returns the value x that satisfies
		// x = a[0] mod m[0]
		// x = a[1] mod m[1]
		// x = a[2] mod m[2]
		// Note that m[0], m[1], m[2] are all distinct primes
		long prod = m[0]*m[1]*m[2];
		long x = (((a[0]*(prod/m[0]))%prod)*(exp(m[1]*m[2], m[0]-2, m[0])))%prod;
		long y = (((a[1]*(prod/m[1]))%prod)*(exp(m[0]*m[2], m[1]-2, m[1])))%prod;
		long z = (((a[2]*(prod/m[2]))%prod)*(exp(m[0]*m[1], m[2]-2, m[2])))%prod;
		return (x+y+z) % prod;
		
		
	}
	
}
