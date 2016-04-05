

public class Problem401{
	static long m = 1000000000;
	public static void main(String[] args)
	{
		
		long N = (long)1e15;
		System.out.println(S2(N));
		
	
		
	}
	
	public static long brute(long n, long stop)
	{
		long s = 0;
		for(long i = 1; i<=stop; i++)
		{
			s+= ((i*i)*(n/i))%m;
		}
		return s%m;
	}
	
	public static long S(long n)
	{
		long split = (long)Math.sqrt(n);
		//System.out.println(split);
		
		long sum = brute(n,split);
		//for(int i =1; i<=n; i++)System.out.println(i + " "+i*i + "  " + n/i);
		//System.out.println("Brute sum:" +sum);
		long l = split+1;
		for(long app = n/l; app>0; app--)
		{
			
			long u = n/app;
			long add = (SSR(l,u) * (app%m))%m;
			//System.out.println(add);
			sum+=add;
			sum%=m;
			l = u+1;
		}
		return sum%m;
	}
	public static long S2(long end)
	{
		long sum =0;
		long i =1;
		while(i <=end)
		{
			long mult = end/i;
			long next = end/mult +1;
			
			sum += ((SSR(i, next-1)) * (mult%m))%m;
			sum%=m;
			i = next;
		}
		return sum%m;
	}
	public static long SSR(long a, long b)
	{
		//sum of squares in range
		//returns sum from i = a to b of i*i
		//returns the value mod mod though
		long res = SS(b)-SS(a-1);
		if(res < 0) res+=m;
		//System.out.println(res);
		return res;
		
	}
	public static long SS(long val)
	{
		//sum of i^2 from i = 1 to val
		/*
		 * Formula: 
		 * val * (val+1)* (2*val+1)/6
		 */
		long a = val;
		long b = val+1;
		long c = 2*val + 1;
		if(a % 2 == 0) a/=2;
		else b/=2;
		if(a % 3 == 0) a/=3;
		else if(b % 3 == 0) b/=3;
		else c/=3;
		long p = (a%m)*(b%m);
		p%=m;
		p*= (c%m);
		return p%m;
	}
}