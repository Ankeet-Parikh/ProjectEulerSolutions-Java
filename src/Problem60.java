import java.util.ArrayList;
import java.util.HashMap;

/*
 * Not a fast solution, takes ≈ 35 seconds.
 * The general idea is very specific which I am not sure how to simplify.
 * Idea:
 * Generate a list of primes up to a certain limit (I chose 20,000).
 * For each prime p, generate a list of primes k such that every k_i can be concatenated in 
 * front and behind p to produce another prime.
 * Recursion part:
 * if the size of the family is zero:
 * 		For each prime p with respective list k:
 * 			add one to the family size, p to the family sum, and recurse with k	
 * Otherwise 
 * 		if the family size is one less than the target:
 * 			add the first element of the current usable array to the family sum
 * 			if the family sum is less than the minimum, set the minimum to the family size
 * 			return
 * 		For each prime p with respective list k:
 * 			For each k_i in k:
 * 				let c be the concatenatable list for k_i
 * 				determine the intersection of c with k, call this s
 * 				if s is empty, return
 * 				if s is not empty, add k_i to the sum of the family, add one to the size of the family,  and recurse with s
 * 
 * 		
 */

public class Problem60 {
	static int min =Integer.MAX_VALUE;
	static int target = 5;
	static HashMap<Integer, ArrayList<Integer>> ww = new HashMap<Integer, ArrayList<Integer>>();
	public static void main(String[] args)
	{
		double s = System.currentTimeMillis();
		int max = 20000;
		boolean[] l = new boolean[max+1];
		for(int i=0; i<l.length; i++) l[i] =true;
		l[0] =false; l[1] = false; 
		l[2] = false; //not mathematically correct, but two will never be a part of a prime pair set
		ArrayList<Integer> p = new ArrayList<Integer>(0);
		for(int i=2; i<l.length; i++)
		{
			for(int j = i+i; j<l.length; j+=i)
				l[j] = false;
			if(l[i]) p.add(i);
		}
		//System.out.println(p);
		
		for(int i=0; i<p.size(); i++)
		{
			int x = p.get(i);
			ww.put(x, new ArrayList<Integer>(0));
			for(int j=i+1; j<p.size(); j++)
			{
				int y = p.get(j);
				if(isPrime(Long.parseLong(x +"" +y )) && isPrime(Long.parseLong(y +"" +x)))
					ww.get(x).add(y);
			}
		}
		
		RecurseFind(0,0,null);
		System.out.println(min);
		double e = System.currentTimeMillis();
		System.out.println((e-s)/1000 +" seconds");
		
	}
	public static void RecurseFind(int fsize, int fsum, ArrayList<Integer> use)
	{
		//use is the family, fsum is the current sum of the family
		if(fsize == 0)
		{
			for(Integer key : ww.keySet())
			{
				int k = key;
				RecurseFind(fsize+1,k, ww.get(key));
			}
		}
		else
		{
			if(fsize == target -1)
			{
				//stipulation that use not be empty
				int csum = fsum + use.get(0); //all other elements of use will be greater so they need not be checked
				if(csum < min) min = csum;
				return;
			}
			else
			{
				for(int i=0; i < use.size(); i++)
				{
					ArrayList<Integer> sect = intersect(ww.get(use.get(i)), use);
					//System.out.println(sect);
					if(!sect.isEmpty())
						RecurseFind(fsize+1, fsum+(int)use.get(i), sect);
				}
			}
		}
		
	}
	public static boolean isPrime(long n)
	{
		if(n == 2) return true;
		if(n%2 ==0 || n == 1 || n==0) return false;
		for(long i=3; i<=Math.sqrt(n); i+=2)
		{
			if(n%i==0) return false;
		}
		return true;
	}
	
	public static ArrayList<Integer> intersect(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		//Intersection of two sorted ArrayLists
		ArrayList<Integer> i = new ArrayList<Integer>(0);
		int m =0, n =0;
		while(m < a.size() && n < b.size())
		{
			int am = a.get(m);
			int bn = b.get(n);
			if(am == bn)
			{
				i.add(a.get(m));
				m++; 
				n++;
				
			}
			else if(am > bn)
			{
				n++;
				
			}
			else if(am < bn)
			{
				m++;
				
			}
			
		}
		return i;
	}

}
