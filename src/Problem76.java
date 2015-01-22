
public class Problem76 {
	public static void main(String[] args)
	{
		System.out.println(partitions(100));
	}
	
	public static long partitions(int n)
	{
		/*
		 * Explanation:
		 * I used dynamic programming to solve this problem.
		 * First, create a list of n+1 elements where list[n] contains the number of partitions n has.
		 * We will need to compute all the values of list[i] from 0<=i<=n;
		 * Since each number can be represented by itself, initialize all the values to 1.
		 * Now, we need to figure out how many ways we can give back n-i pennies for all i, 2<=i<=n;
		 * This is simple, as the number of ways to give back n-i pennies is just list[n-i]
		 * Subtract one at the end because we are only looking for summations, 
		 * In the beginning we counted one extra.
		 */
		long[] p = new long[n+1];
		for(int i=0; i<p.length; i++)
			p[i]=1;
		for(int i=2; i<=n; i++)
		{
			for(int j =i; j<=n; j++)
			{
				p[j]+=p[j-i];
			}
		}
		return p[n]-1; // Subtract one because one of the values will not be a sum.
	}
}
