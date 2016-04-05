

public class Problem504 {
	static int m = 100;
	static int[][] cache = new int[m+1][m+1];
	public static void main(String[] args)
	{
		double s = System.currentTimeMillis();
		int count =0;
		int m = 100;
		for(int a =1; a <=m; a++)
		{
			int al = a > 1?a-1:0;
			for(int b =1; b<=m;b++)
			{
				int bl = b>1?b-1:0;
				int ab = Q(a,b);
				for(int c =1; c<=m; c++)
				{
					int cl = c>1?c-1:0;
					int bc = Q(b,c);
					for(int d=1; d<=m; d++)
					{
						int dl = d>1?d-1:0;
						int ad = Q(a,d);
						int cd = Q(c,d);
						int p = al+bl+cl+dl+ab+bc+cd+ad + 1;//plus one for origin
						double rt = Math.sqrt(p);
						if(rt == (int)rt) count++;
					}
				}
			}
		}
		System.out.println(count);
		System.out.println((System.currentTimeMillis() -s)/1000.0 +" seconds");
	}
	
	public static int Q(int x, int y)
	{
		/*
		 * This method computes the number of lattice points strictly inside 
		 * a triangle with coordinates (0,0),(a,0),(0,b).
		 * Picks Theorem: A = b/2 + i -1
		 * i = A+1 - b/2
		 * b is number of border points, i is number of interior points
		 * A = x*y/2
		 * i = (x*y-b)/2+1
		 */
		int b = gcd(x,y)+1;
		b+= 1 + (x-1) + (y-1); 
		return (x*y-b)/2+1;
	}
	public static int gcd(int a, int b)
	{
		return b ==0 ?a : gcd(b, a%b);
	}
}
