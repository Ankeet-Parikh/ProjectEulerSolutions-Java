
public class Problem135 {
	static long range = 1000000L;
	static int[] sols = new int[(int) range];
	public static void main(String[] args)
	{		
		for(int x =1; x<range ;x++)
		{
			genAll(x);
		}
		int c =0;
		for(int i=0; i<sols.length; i++)
		{
			if(sols[i] == 10) 
			{
				c++;
			}
		}
		System.out.println(c);
	}
	
	public static void genAll(long x)
	{
		
		/* we can rewrite x^2 - y^2 -z^2 = N into the form
		 * (x+2d)^2 - (x+d)^2 -x^2 = N
		 * x is given, so for every value of d, compute the above formula, and
		 * increment the counter of the calculated value.
		 * y is equal to x/3 because the smallest positive integer y that 
		 * satisfies (3*y - x)*(x+y) > 0
		 */
		long y =x/3;
		long init = (3*y-x)*(x+y);
		while(init  < range)
		{
			if(init > 0)
				sols[(int)init]++;
			y++;
			init = (3*y-x)*(x+y);
		}
		
	}
}