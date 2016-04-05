import java.math.BigInteger;
public class Problem171 {
	public static void main(String[] args)
	{
		int exp = 20;
		long[] ways = new long[81*exp+1];
		ways[0] = 1;
		for(int i=1; i <= 9; i++)
		{
			for(int j = i*i;j<ways.length; j++)
			{
				ways[j] += ways[j - i*i];
			}
		}
		System.out.println(ways[16]);

		
	}
	
	public static boolean pf(long n)
	{
		long s = 0;
		while(n > 0)
		{
			s+=((n%10) * (n%10));
			n/=10;
		}
		
		long r = (long)Math.sqrt(s);
		return r*r == s;
	}
	public static char[] nextPerm(char[] a)
	{
		int k = a.length-1;
		while(k>0 && a[k-1] >= a[k])
		{
			k--;
		}
		if(k <= 0) return null;
		int l = a.length-1;
		while(a[l] <= a[k-1])
		{
			l--;
		}
		char temp = a[k-1];
		a[k-1] = a[l];
		a[l] = temp;
		
		int j = a.length-1;
		while(k < j)
		{
			temp = a[k];
			a[k] = a[j];
			a[j] = temp;
			k++;
			j--;
		}
		return a;
	}
	
	public static BigInteger form(char[] a)
	{
		//returns the sum of all permutations of a
		//formula:
		//let l equal the length of a
		//s be the sum of elements in a
		//(l-1)! * s * (10^l-1)/9
		BigInteger l = new BigInteger(""+a.length);
		BigInteger s = new BigInteger(""+0);
		BigInteger t = new BigInteger("" + 10);
		BigInteger n = new BigInteger("" + 9);
		for(int i=0; i<a.length; i++)
			s = s.add(new BigInteger("" + (int)(a[i]- '0')));
		BigInteger res = factorial(a.length-1).multiply(s);
		res = res.multiply((t.pow(a.length).subtract(BigInteger.ONE)).divide(n));
		//divide res by the multiplicities
		int[] occ = new int[10];
		for(int i=0; i<a.length; i++)
			occ[(int)(a[i]-'0')]++;
		for(int i=0; i<occ.length; i++)
			res = res.divide(factorial(occ[i]));
		return res;
		
	}
	
	public static BigInteger factorial(long n)
	{
		if(n <=1) return BigInteger.ONE;
		return new BigInteger(""+n).multiply(factorial(n-1));
	}
}	
