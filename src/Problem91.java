
public class Problem91 {
	/*
	 * Number of Lattice points on the line between (a,b) and (c,d):
	 * gcd(c-a, d-b) +1
	 * http://math.stackexchange.com/questions/628117/how-to-count-lattice-points-on-a-line
	 * Compute GCD using euclidean agorithm
	 */
	public static void main(String[] args)
	{
		int n = 50;
		int c = n*n;
		
		for(int x =0; x <=n ;x++)
		{
			for(int y = 1; y <=n; y++)
			{
				c+=2*count(x,y,n);
			}
		}
		System.out.println(c);
	}
	public static int count(int x, int y, int n)
	{
		//right angle is at (x,y)
		if(x == 0)
		{
			if(y ==0) return 0;
			return n;
		}
		else
		{
			int g =gcd(x,y);
			int pdx = y/g;
			int pdy = x/g;
			int xlat =(n-x)/pdx;
			int ylat =y/pdy;
			return min(xlat, ylat);
		}
	}
	
	
	public static int gcd(int a, int b)
	{
		return b == 0 ? a : gcd(b, a%b);
	}
	public static int min(int a, int b)
	{
		return a > b? b : a;
	}
	
}