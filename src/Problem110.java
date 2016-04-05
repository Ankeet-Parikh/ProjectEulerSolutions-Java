import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem110 {
	static int max = 2*4000000;
	static long minval = Long.MAX_VALUE;
	static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
			67, 71, 73, 79, 83, 89, 97};
	static int[] odds = {3,5,7,9,11};
	static int[] apps = new int[odds.length];
	public static void main(String[] args)
	{
		/*
		 * Similar to 108 in that 1/x+1/y = 1/n has (a+1)/2 distinct solutions 
		 * where a is the number of divisors of n^2
		 * 
		 * Therefore for this problem, (a+1)/2 > 4*10^6 and a+1 > 8*10^6
		 * 
		 * Let us look at the prime factorization of n:
		 * n = p1^a1 * p2^a2 *p3^a3 *...
		 * the number of divisors a is then:
		 * a = (a1+1)*(a2+1)*(a3+1) * ...
		 * 
		 * Similarly for n^2
		 * n^2 = p1^(2a1) * p2^(2a2) * p3^(2a3) * ...
		 * so the value of a for n^2 is just:
		 * a = (2a1+1) * (2a2+1) * (2a3+1) * ...
		 * 
		 * Notice how all of the exponents are odd numbers: 1,3,5,7,9,11,13
		 * Wild assumption: none of the exponents will be higher than 21
		 * If we sort all of the exponents in descending order, then we can obtain the same
		 * number of solutions while minimizing the product.
		 * 
		 * We can write the set of exponents in the following way:
		 * exponent:    3  5  7  9  11  13  15  17  19  21
		 * apperances:  a  b  c  d  e   f    g   h   i   j
		 * do dfs on the appearances to see how many times each of them appears 
		 */
	
	dfs(0,1);
	System.out.println(minval);
	}
	
	public static void dfs(int index, int prod) //index of current odd #, product of primes so far
	{
		int o = odds[index];
		apps[index] = 0;
		int cp = prod;
		for(int i=0; ;i++)
		{
			cp = prod * (int)(Math.pow(o,i));
			apps[index]=i;
			if(cp > max || index == odds.length-1)
			{
				eval();
				if(cp > max) break;
			}
			else
			{
				dfs(index+1, cp);
			}
		}
		apps[index] = 0;
		
	}
	public static void eval()
	{
		ArrayList<Integer> exps = new ArrayList<Integer>(0);
		for(int i = 0; i<apps.length; i++)
			for(int j =0; j<apps[i]; j++)
				exps.add(odds[i]);
		numProd(exps);
	}
	public static void numProd(ArrayList<Integer> exp)
	{
		Collections.sort(exp);
		long res =1;
		long p =1;
		for(int i=0; i<exp.size(); i++)
		{
			int val = exp.get(exp.size()-1-i);
			p*=val;
			long add = (long)Math.pow(primes[i], (val-1)/2);
			res *= add;
		}
		//System.out.println(p);
		//System.out.println(res);
		if(res < minval && p > max && res > 0)
		{
			//System.out.println(Arrays.toString(apps));
			minval = res;
		}
	}
	
	
}
