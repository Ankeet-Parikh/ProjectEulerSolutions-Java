import java.text.DecimalFormat;
public class Problem235 {
	static double t = -1*(long)6e11, N = 5000;
	public static void main(String[] args)
	{
		/*
		 * Apply binary search with the starting points:
		 * 1.000, 1.003
		 */
		double v = BS(1.0001, 1.003);
		System.out.printf("%.12f",v );
		
	}
	public static double BS(double l, double u)//lower < upper
	{
		/*
		 * The idea is that the correct r value lies between l and u.
		 * However, we do not know whether the function is increasing
		 * or decreasing, so 
		 * 
		 */
		
		double m = 0;
		double mv = 0;
		for(int i=0; i<50; i++)
		{
			m = (l+u)/2.0;
			mv = s(m, N) -t;
			double lv = s(l, N)-t, uv = s(u, N)-t;
			if((mv > 0 && lv > 0 ) || (mv < 0 && lv < 0))
			{
				l = m;
			}
			else
			{
				u = m;
			}
		}
		return m;
	}
	public static double s(double r, double N)
	{
		/*
		 * closed form formula for s(n)
		 */
		double p1 = 897.0*(1.0-Math.pow(r,N))/(1.0-r);
		double p2 = 3.0*(r-N*Math.pow(r,N)-Math.pow(r, N+1.0)+N*Math.pow(r,N+1))/(r-1)/(r-1);
		return p1-p2;
	}
	
	public static double SCheck(double r, double N)
	{
		double s =0;
		for(double k=1; k<=N; k++)
		{
			s+= (900-3*k)*Math.pow(r,k-1);
		}
		return s;
	}
}
