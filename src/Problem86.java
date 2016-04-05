import java.util.Arrays;

public class Problem86 {
	static int r = 5000;
	static int[] sols = new int[r+1];

	public static void main(String[] args) 
	{
		rec(3, 4, 5);
		int t = 1000000;
		int s = 0;
		int  i = 0;
		for (i = 0; i < sols.length; i++) 
		{
			s += sols[i];
			if(s > t)
			{
				break;
			}
		}
		System.out.println(i);
	}

	public static void rec(int a, int b, int c)
	{

		if (a >= sols.length && b>=sols.length)
			return;
		int p = a, q = b;
		while (p < sols.length || q < sols.length)
		{
			// find the number of solutions for this triple
			if (p < sols.length) 
			{
				int ct = count(p, q);
				//System.out.println(p + " " + q + " " + ct + "~~~~~" );
				sols[p]+=ct;
			}
			if (q < sols.length)
			{
				int ct = count(q,p);
				//System.out.println(q + " " + p + " " + ct);
				sols[q]+=ct;

			}
			// increment the triple
			p += a;
			q += b;

		}

		rec(a - 2 * b + 2 * c, 2 * a - b + 2 * c, 2 * a - 2 * b + 3 * c);
		rec(a + 2 * b + 2 * c, 2 * a + b + 2 * c, 2 * a + 2 * b + 3 * c);
		rec(-a + 2 * b + 2 * c, -2 * a + b + 2 * c, -2 * a + 2 * b + 3 * c);
	}
	
	public static int count(int m, int n)
	{
		/* counts the number of distinct ways to add up to n without using
		 * any number exceeding m
		 * count(6,8) = 3
		 * 2+6
		 * 3+5
		 * 4+4
		 */
		if(m >= n-1) return n/2;
		if(m < n/2) return 0;
		else
		{
			return n/2 - (n-m-1);
		}
	}
}
