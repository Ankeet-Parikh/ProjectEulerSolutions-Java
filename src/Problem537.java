import java.util.*;
import java.math.*;
public class Problem537 {
	static int mod = 1004535809;
	public static void main(String[] args)
	{
		//Pi(224742) = 20000 while Pi(224743) == 20001
		int n = 2000; 
		int k = 2000;
		
		int r = 0;
		for(int i=2; ;i++)
		{
			if(new BigInteger("" + i).isProbablePrime(20)) r++;
			if(r == n+1)
			{
				r = i-1;
				break;
			}
		}
		
		//listp[i] is true iff i is prime
		boolean listp[] = new boolean[r+1];
		for(int i=2; i<listp.length; i++) listp[i] = true;
		for(int i=2; i<listp.length; i++)
		{
			if(listp[i])
			{
				for(int j = 2*i; j<listp.length; j+=i)
				{
					listp[j] = false;
				}
			}
		}
		System.out.println("Done Sieving");
		
		// pi[i] = # of primes less than or equal to i
		int pi[] = new int[r+1];
		pi[1] = 0;
		for(int i=2; i<pi.length; i++) pi[i] = listp[i]? pi[i-1] + 1: pi[i-1];
		//ipi[i] =  the number of positive integers x such that pi[x] = i
		int[] ipi = new int[n+1];
		for(int i=0, j = 1; i < ipi.length; i++)
		{
			while(j < pi.length && pi[j] == i)
			{
				ipi[i]++;
				j++;
			}
		}
		
		//System.out.println(Arrays.toString(ipi));
		
		// m[i][j] = number of tuples of length i such that 
		// pi(x_1)+pi(x_2) + ... + pi(x_j) = j
		// first, note that m[1][j] = ipi[j]
		// m[i] = the convolution of m[i-1] and m[1]
		int[][] m = new int[k+1][n+1];
		for(int j=0; j<=n; j++) m[1][j] = ipi[j];
		for(int i=2; i<=k; i++)
		{
			m[i] = convolve(m[i-1], m[1]);
		}
		System.out.println(m[k][n]);
		
	
	}
	
	public static int[] convolve(int[] a, int[] b)
	{
		// returns the convolution of a and b of length n
		// let a = (a_0, a_1, ..., a_{n-1})
		//     b = (b_0, b_1, ..., b_{n-1})
		// Then the convolution c is 
		//	   c_i = a_0*b_i + a_1*b_{i-1} + a_2 * b_{i-2} + ... + a_i*b_0
		// 	   c = (c_0, c_1, ..., c_{n-1}
		int n = a.length;
		int[] c = new int[n];
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<=i; j++)
			{
				c[i] += (((long)a[j]%mod) * (b[i-j]%mod)) % mod;
				c[i]%=mod;
			}
		}
		return c;
		
	}
}
