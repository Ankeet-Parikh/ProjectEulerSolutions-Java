
public class Problem521 {
	public static void main(String[] args)
	{
		long N = (long)1e12;
		System.out.println(S(N));
		long s = 0;
		for(int i =2; i<=1000000; i++) s+=smpf(i);
		System.out.println(s);
	}
	
	public static long S(long n)
	{
		boolean[] p = new boolean[(int)Math.sqrt(n)+1];
		for(int i=2; i<p.length; i++) p[i] = true;
		for(int i=2; i<p.length; i++)
		{
			if(p[i])
			{
				for(int j = i+i; j<p.length; j+=i)
					p[j] = false;
			}
		}
		return 0;
	}
	
	public static long smpf(long n)
	{
		for(long i=2; i<=Math.sqrt(n);i++)
		{
			if(n%i == 0)
				return i;
		}
		return n;
	}
}
