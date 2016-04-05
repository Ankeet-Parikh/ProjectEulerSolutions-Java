
public class Problem183 {
	public static void main(String[] args)
	{
		long sum = 0;
		for(int i=5; i <=10000; i++)
		{
			int m = fastparts(i);
			int g = gcd(i,m);
			int d = m/g;
			if(twofivepow(d))
			{
				sum -=i;
			}
			else
				sum+=i;
			//System.out.println(i+ ":  " + m + " ");
		}
		System.out.println(sum);
	}
	
	public static int maxProdParts(int n)
	{
		//returns the number of equal parts k that n should be split into
		//such that (n/k)^k is maximized
		double max =0;
		int maxk = 0;
		for(int i = 1; i<=0.5*n; i++)
		{
			double p = n/(double)i;
			double e = i * Math.log(p);
			if(e>max)
			{
				max = e;
				maxk=i;
			}
		}
		//System.out.println(max);
		return maxk;
	}
	public static int fastparts(int n)
	{
		/*
		 * The maximum of (N/k)^k is at k = n/e
		 * the integer that maximized this is the one
		 * closest to k, thus rounding k to the nearest integer will give the result.
		 * (Unfortunately, this may not work for higher values of n. For those,
		 * we must check ceil(n/e) and floor(n/e) and compare)
		 * 
		 * Proof:
		 * To find the maximum, set the derivative equal to zero:
		 * 
		 * d/dk (N/k)^k = (N/k)^k * (ln(N/k) - 1)
		 * ln(N/k) - 1  = 0
		 * ln(N/k)  = 1 
		 * e = N/k
		 * k = N/e
		 */
		return (int)Math.round(n/Math.E);
	}
	public static int gcd(int a, int b)
	{
		return b == 0 ? a: gcd(b, a%b);
	}
	
	public static boolean twofivepow(int n)
	{
		//returns true if n is of the form 2^i*5^j
		while(n%2==0)
		{
			n/=2;
		}
		while(n%5 ==0)
		{
			n/=5;
		}
		if(n == 1) return true;
		return false;
	}
}
