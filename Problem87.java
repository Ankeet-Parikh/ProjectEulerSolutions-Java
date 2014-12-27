package problems_80_89;

import java.util.*;


public class Problem87 {

	
	public static void main(String[] args) 
	{
		int range = 50000000;
		int[] primes = new int[7800];
		for(int i =0, p =2; i< primes.length; i++) 
		{
				primes[i] =p;
				p++;
				while(!isPrime(p))
				{
					p++;
				}
		}
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int a=0; a< primes.length;a++)
		{
			if(Math.pow(primes[a],2) >range) break;
			for(int b =0; b< primes.length;b++)
			{
				if(Math.pow(primes[a],2)+Math.pow(primes[b],3) > range) break;
				for(int c =0; ;c++)
				{
					if(Math.pow(primes[a],2)+Math.pow(primes[b],3)+Math.pow(primes[c],4) <range)
						nums.add((int) (Math.pow(primes[a],2)+Math.pow(primes[b],3)+Math.pow(primes[c],4)));
					else break;	
				}
			}
		}
		
		System.out.println(countOneOfEach(nums));
		
	}
	public static int countOneOfEach(ArrayList<Integer> arr)
	{
		Collections.sort(arr);
		int total =1;
		for( int i =1, last = arr.get(0); i< arr.size() ;i++)
		{
			
			if(arr.get(i) !=last)
			{
				total++;
				last = arr.get(i);
			}
		}
		return total;
	}
	public static boolean isPrime(int num)
	{
		if(num ==0 || num ==1) return false;
		for(int i =2; i<=Math.pow(num, 0.5); i++)
		{
			if(num%i==0)return false;
		}
		return true;
	}

}
