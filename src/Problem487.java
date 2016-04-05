public class Problem487{
	public static long exp(long a, long b, long m)
	{
		if(b == 0) return 1;
		if(b == 1) return a%m;
		long c = exp(a, b/2, m);
		c = c * c % m;
		if(b%2 == 1) c = c * a % m;
		return c % m;
	}
	public static void main(String[] args)
	{
		// want to compute sum of i^10000 for all i from 1 to 10^12
		
	}
}