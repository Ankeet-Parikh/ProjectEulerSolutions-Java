
public class Problem505 {
	public static void main(String[] args)
	{

		System.out.println(A(1000000000000L));
	}
	public static long A(long n){return y(n, 1);}
	public static long y(long n, long k)
	{
		if(k >= n) return x(k);
		
		else
		{
			return ((long)Math.pow(2,60)) - 1 - max(y(n,2*k), y(n,2*k+1));
		}
	}
	
	public static long x(long k)
	{
		if(k == 0) return 0;
		if(k == 1) return 1;
		long mod = (long)Math.pow(2,60);
		if(k%2 == 0)
		{
			long s = 3*x(k/2);
			s%=mod;
			s+=2*x((long)Math.floor((k/2)/2));
			return s%mod;
		}
		else //(k%2 ==1)
		{
			long s = 2*x(k/2);
			s%=mod;
			s+=3*x((long)Math.floor((k/2)/2));
			return s%mod;
		}
	}
	public static long max(long m, long n)
	{
		return m > n? m : n;
	}
}
