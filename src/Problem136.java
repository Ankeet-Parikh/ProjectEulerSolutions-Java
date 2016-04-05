/*
 * x, y, z are terms of an arithmetic progression
 * find how many values of n below 50 million
 * have only one solution for
 * x^2-y^2-z^2 = n
 * 
 * Solution:
 * z = x
 * y = x+r
 * x = x+2r
 * x^2-y^2-z^2 = (x+2r)^2-(x+r)^2-x^2 = (3r-x) * (x+r)
 * 
 * We need to find all values of n such that n is of the form (3r-x) * (x+r).
 * We know that 3r > x because otherwise the product would not be positive
 */
public class Problem136 {
	public static void main(String[] args)
	{
		int m = 50000000;
		short[] sol = new short[m];
		for(int r = 1; r< m/2; r++)
		{
			int l = 1; 
			int u = 3*r;
			if(4*(long)r*r > m)
			{
				l = (int)Math.floor(r  + Math.sqrt(4*(long)r*r-m));
			}
			for(int x = l; x < u; x++)
			{
				long f = func(x,r);
				if(f < m) sol[(int)f]++;
			}
		}
		int c = 0;
		for(int i=1; i<m; i++)
			if(sol[i] == 1)
				c++;
		System.out.println(c);
	}
	public static long func(int x, int r)
	{
		long a = 3*r-x;
		long b = x+r;
		return a*b;
	}
}
