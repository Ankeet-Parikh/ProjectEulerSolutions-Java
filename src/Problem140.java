import java.util.ArrayList;
import java.util.Collections;
public class Problem140 {
	static ArrayList<Long> gn = new ArrayList<Long>(0);
	public static void main(String[] args)
	{
		/*
		 * AG(x) = (x+3x*x)/(1-x-x*x)
		 * Considering the times when AG(x) is integral, solve for x
		 * Let A = AG(x)
		 * x = (-(A+1) +/- Sqrt(5A^2+14A+1))/(2*(3+A))
		 * 
		 * Thus, 5A^2+14A +1 must be a perfect square
		 * Solve the diophantine: 5A^2+14A+1 = k^2
		 * (First 30 positive solutions)
		 */
		/*
		int i =0;
		
		for(long A =1; A<100000000; A++)
		{
			long c = 5*A*A +14*A + 1;
			long rt = (long)Math.sqrt(c);
			if(rt*rt == c)
			{
				i++;
				System.out.println(i+ ")" +A + " " + rt);
			}
		}*/
		gen(0,-1);
		gen(0,1);
		gen(-3,-2);
		gen(-3,2);
		gen(-4,-5);
		gen(-4,5);
		gen(2,-7);
		gen(2,7);
		Collections.sort(gn);
		//System.out.println(gn);
		long sum=0;
		for(int j=0; j<30; j++)sum+=gn.get(j);
		System.out.println(sum);
	}
	public static void gen(long x0, long y0)
	{
		long x = x0, y = y0;
		int p = -9, q =-4, k =-14, r =-20 ,s = -9, l =-28;
		for(int i=0; i<10; i++)
		{
			long xn = p*x+q*y+k;
			long yn = r*x+s*y+l;
			x = xn; y = yn;
			if(xn > 0 && !gn.contains(xn)) gn.add(xn);
			//System.out.println(xn +" " + yn);
		}
	}
	public static double AF(double x)
	{
		//Closed form of Af(x), not necessary but somewhat useful
		return (x+3*x*x)/(1-x-x*x);
	}
}
