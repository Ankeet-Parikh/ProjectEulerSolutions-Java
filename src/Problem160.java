
public class Problem160 {
	public static void main(String[] args)
	{
		long mod = 100000;
		long rep[] = new long[(int)mod+1];
		long N =10000000000l;
		//N=10000000;
		long each = N/mod, p1 = N%mod;
		for(int i=1; i<=mod; i++)
		{
			rep[i] = each;
			if(i <= p1) rep[i]++;
		}
		long rem = 0; //number of 2s that we need to remove
	
		for(int i= (int)mod; i>=1; i--)
		{
			if(rep[i] != 0 && i%5 == 0)
			{
				rem+=rep[i];
				rep[i/5]+=rep[i];
				rep[i] = 0;
			}
		}
		System.out.println(rem);
		System.out.println(fives(N));
		
	}
	public static long fives(long N)
	{
		long ct = 0, f = 5;
		while(f <= N)
		{
			ct+=N/f;
			f*=5;
		}
		return ct;
	}
	public static long pow(long a, long b)
	{
		//returns a^b mod 1000000
		long mod = 1000000;
		if(b == 0) return 1 % mod;
		long y = pow (a,b/2);
		y = (y*y)%mod;
		if(b%2 == 1) y = (y*(a%mod))%mod;
		return y;
	}
}
