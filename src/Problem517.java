
public class Problem517 {
	public static void main(String[] args)
	{
		for(int i=1; i<=15; i++)
		{
			System.out.println(i + ") " + G(i));
		}
	}
	public static long G(long n)
	{
		return g(Math.sqrt(n), n);
	}
	
	public static long g(double a, double x)
	{
		if(x < a) return 1;
		return g(a, x-1)+g(a, x-a);
	}
	public static boolean[] getPrimes()
	{
		int l = 10000000;
		int u = 10010000;
		boolean p[] = new boolean[u-l+1];
		for(int i=0; i<p.length; i++) p[i] = true;
		for(int i=2; i<= Math.sqrt(u); i++)
		{
			int m = (l/i)*i;
			while(m<=u)
			{
				if(m>=l)
					p[m-l] = false;
				m+=i;
			}
		}
		return p;
	}
}
