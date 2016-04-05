/*
 * According to A046079,
 * if n is the cathetus and 
 * n = (2^a0)(p1^a1)(p2^a2)...(pk^ak)
 * then the number of right triangles with n as a cathetus is
 * [(2*a0-1)(2*a1+1)(2*a2+1)...(2*ak+1) - 1]/2
 * 
 * For example
 * 12 = 2^2 * 3
 * thus the number of triangles with 12 as a cathetus is
 * [(2*2-1)(2*1+1) - 1]/2 = 4
 * 
 * for this problem we have
 * [(2*a0-1)(2*a1+1)(2*a2+1)...(2*ak+1) - 1]/2 = 47547
 * 
 * (2*a0-1)(2*a1+1)(2*a2+1)...(2*ak+1) = 47547*2 + 1 = 95095
 * 
 * Factoring 95095 gives:
 * 95095 = 5*7*11*13*19
 */
public class Problem176 {
	public static void main(String[] args)
	{
		int count = 47547;
		count = count*2 + 1;
		long k = pow(2, 10)*pow(3, 6)*pow(5, 5)*pow(7, 3)*pow(11, 2);
		System.out.println(k);
	}
	static long pow(long a, long b)
	{
		long p = 1;
		for(int i =1; i<=b; i++) p*=a;
		return p;
	}
}
