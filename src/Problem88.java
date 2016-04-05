import java.util.*;
public class Problem88 {
	public static void main(String[] args)
	{
		/*
		 * Observation:
		 * lower bound for minimal product sum number for k tuple is k
		 * for all k>=2 the tuple (1,1,..., 2, k)
		 * will work, 
		 * Product = 2*k
		 * Sum = (k-2) + 2 + k = 2*k
		 * However, this is not minimal, just an upper bound.
		 * Lower bound is k 
		 * (technically k will not be a product sum number for a k tuple, but it is a better lower bound than 0)
		 * 
		 * For a number n, we need to find all k for which n is a product sum number for a k tuple.
		 * First, find the prime factorization of n
		 * 
		 */
		int r = 12000;
		int[] mps = new int[r+1];
		for(int i=2; i<mps.length; i++)
		{
			mps[i] = 2*i;
		}
		for(int i =4;i<=2*r; i++)
		{
			factor(i);
		}
	}
	
	public static ArrayList<Integer> factor(int n)
	{
		ArrayList<Integer> f = new ArrayList<Integer>(0);
		for(int i=2; i<=n; i++)
		{
			while(n%i == 0)
			{
				f.add(i);
				n/=i;
			}
		}
		return f;
	}
}
