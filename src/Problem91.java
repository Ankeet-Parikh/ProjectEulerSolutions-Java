
public class Problem91 {
	/*
	 * Number of Lattice points on the line between (a,b) and (c,d):
	 * gcd(c-a, d-b) +1
	 * http://math.stackexchange.com/questions/628117/how-to-count-lattice-points-on-a-line
	 * Compute GCD using euclidean agorithm
	 */
	public static void main(String[] args)
	{
		int a = 0, b =0, c = 8, d = 10;
		System.out.println(gcd(c-a,d-b)+1);
	}
	public static long gcd(long a, long b)
	{
		return b==0? a: gcd(b, a%b);
	}
}
