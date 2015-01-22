
public class Problem78 {
	public static void main(String[] args)
	{
		/*
		 * Create the Partitions with a similar method to Problem 76.
		 * However, as the Partitions for higher numbers can get overwhelmingly 
		 * large, it becomes infeasible to deal with them. Fortunately, we only need
		 * the value n for which p(n) is divisible by 10^6. Thus, we can mod 10^6 for every operation,
		 * as doing this will still tell us whether the one million divides p(n).
		 */
		
		int ub = (int) 1e5, mod = 1000000; //ub is upper bound
		long[] part = new long[ub+1];
		part[0] =1;
		for(int i=1; i<part.length; i++)
		{
			setPart(part, i, mod);
			if(part[i] ==0) 
			{
				System.out.println(i);
				break;
			}
		}
		
		
	}
	public static void setPart(long[] part, int n, int mod)//using pentagonal number theorem
	{
		
		/*
		 * p(n) = p(n-1) + p(n-2) - p(n-5) -p(n-7) + ...
		 * The list of 1,2,5,7,12,15 are the generalized pentagonal numbers.
		 * There are many formulas to determine the kth generalized pentagonal number,
		 * But here is the simplest: 
		 * Start at k =1 and iterate up by one. Each value of k will generate the next
		 * two pentagonal numbers.
		 *  p1 = k*(3*k-1)/2
		 *  p2 = k*(3*k+1)/2 
		 *  For each value of k, both numbers will have the same sign in front: -1^(k+1)
		 *  Also note that p(0) = 1, and p(any negative number) = 0;
		 */
		long p =0;
		int k =1;
		while(true)
		{
			int a = k*(3*k-1)/2;
			int b = k*(3*k+1)/2;
			int neg = (int) Math.pow(-1, k+1);
			if(a > n) break;
			p += neg * part[n-a];
			if(b > n) break;
			p += neg * part[n-b];
			p%=mod;
			k++;
			
		}
		part[n] = p%mod;
	}
	
}












