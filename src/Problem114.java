/*
 * Let B[n] denote the number of ways to fill a row of length n.
 * B[7] = 17
 * Let A[n] denote the number of ways to fill a row of length n such that a black square occupies the last position.
 * 
 * Note that A[n] = B[n-1]
 * 
 * We know that B[0] = 1, B[1] = 1, B[2] = 1, and B[3] = 2.
 * 
 * How to think about this problem:
 * We can just add a black square to an n-1 length row to make an n length row
 * We can add a block of length 3 to a n-3 length row to make an n length row
 * We can add a block of length 4 to a n-4 length row to make an n length row
 * .
 * .
 * .
 * We can add a block of length n to a zero length row to make an n length row
 * 
 * Notice what I'm getting at?
 */
public class Problem114 {
	public static void main(String[] args)
	{
		int n = 50;
		long f[] = new long[n+1];
		f[0] = f[1] = f[2] = 1;
		f[3] = 2;
		for(int i = 4; i<=n; i++)
		{
			f[i] += 1+f[i-1];
			for(int j = 4; j<=i; j++)
			{
				f[i]+=f[i-j];
			}
		}
		System.out.println(f[6]);
		
	}
}
