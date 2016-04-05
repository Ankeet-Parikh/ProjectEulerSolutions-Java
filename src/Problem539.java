
public class Problem539 {
	static long mod = 987654321;
	public static void main(String[] args)
	{
		long n = 1000000000000000000l;
		System.out.println(S(n));
		//System.out.println(S2(n));
	}
	
	public static long P(long n)
	{
		if(n == 1) return 1;
		if(n%2 == 1) return n - 2*P(n/2) + 1;
		//now n is the highest even number less than n
		return n - 2*P(n/2) + 2;
	}
	
	public static long S(long n)
	{
		//returns answer mod 987654321
		if(n == 1) return 1;
		
		//long sum = -1 + n*(n+1)/2 + n + n/2;
		long sum = -1;
		sum += n%mod;
		sum += (n/2)%mod;
		if(n%2 == 0)
		{
			sum += (((n/2)%mod) * ((n+1) % mod))%mod ;
		}
		else
		{
			sum += (((n)%mod) * (((n+1)/2) % mod))%mod ;
		}
		sum-= (4*S(n/2))%mod;
		if(n%2 == 0)
		{
			sum+= (2 * (P(n/2)%mod))%mod;
		}
		sum%=mod;
		while(sum<0) sum+=mod;
		return sum%mod;
	}
	public static long S2(long n)
	{
		//returns answer mod 987654321
		long mod = 987654321;
		mod = 1000000000000000000l;
		long sum = -1 + n*(n+1)/2 + n + n/2;
		for(int i=2; i<=n; i++)
			sum-=2*P(i/2);
		return sum;
	}
}
