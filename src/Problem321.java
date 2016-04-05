import java.util.ArrayList;
import java.util.Collections;


public class Problem321 {
	/*
	 * M(1) = 3 // solved by hand
	 * M(2) = 8 //solved by hand
	 * M(3) = 15
	 * Using oeis, we can see that M(n) = n  * (n+2)
	 * M(n) = T(m) where T(m) is the mth triangular number
	 * n*(n+2) = 1/2 * m * (m+1)
	 * 2n*n+4n -m*m -m = 0
	 * 
	 */
	public static void main(String[] args)
	{
		ArrayList<Long> sols = new ArrayList<Long>(0);
		sols.add(1L);
		sols.add(3L);
		long x1n = 1, y1n = 2, x2n = 3, y2n = 5;
		for(int i=0; i<23; i++)
		{
			long xn = 3 * x1n + 2*y1n + 3;
			long yn = 4 * x1n + 3*y1n + 5;
			x1n = xn;
			y1n = yn;
			xn = 3*x2n+2*y2n+3;
			yn = 4*x2n+3*y2n+5;
			x2n = xn;
			y2n = yn;
			sols.add(x1n);
			sols.add(x2n);
		}
		Collections.sort(sols);
		System.out.println(sols);
		long s = 0;
		for(int i=0; i<40; i++)s+=sols.get(i);
		System.out.println(s);
	}
}
