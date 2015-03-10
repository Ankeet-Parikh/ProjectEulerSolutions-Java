
public class Problem173 {
	public static void main(String[] args)
	{
		
		/*
		 * The inner hole will have an area of x^2 and the outer 
		 * square will have an area of (x+2*d)^2 where d is a
		 * positive integer. Subtracting these
		 * two values, we get the number of blocks used:
		 * f(x,d) = (x+2*d)^2 - x^2
		 * Since the value of f(x,d) must be less than or equal to the 
		 * number of blocks available, we need to solve
		 * f(x,d) <= N 
		 * (x+2*d)^2 - x^2 <=N
		 * 
		 * for d.
		 * Using the quadratic formula, we obtain a value of d as:
		 * (sqrt(x*x+N)-x)/2
		 * Iterating upon all the x values and then summing up the corresponding
		 * d values will give the total number of square laminae.
		 */
		long sum =0, N = 1000000;
		for(long x =1;x < N; x++)
		{
			long d = (long)((Math.sqrt(x*x+N) -x)/2.0);
			sum+=d;
		}
		System.out.println(sum);
	}
	

}
