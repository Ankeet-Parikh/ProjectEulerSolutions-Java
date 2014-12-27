

import java.util.ArrayList;


public class Problem125 {
	public static void main(String args[])
	{
		
		
		long range =(long)Math.pow(10,8);
		long maxtest = (long) Math.floor(Math.sqrt(range));
		ArrayList<Long> hasprop = new ArrayList<Long>(0);
		for(int i =1; i<maxtest; i++)
		{
			for(int j =i+1; j<=maxtest; j++)
			{
				long diff = sumSquares(j) - sumSquares(i-1); //sum of the squares from i to j
				if(diff > range)
					break;
				if(isPalindrome(diff+"") && !hasprop.contains(diff))
				{
					hasprop.add(diff);
					
				}
			}
		}
		System.out.println(Sum(hasprop));
		
	
	}
	
	public static long Sum(ArrayList<Long> arr)
	{
		long sum =0;
		for(int i=0; i<arr.size(); i++)
		{
			sum+=arr.get(i);
		}
		return sum;
	}
	public static long sumSquares(long m) //sum 1<=j<=n n^2
	{
		return m*(m+1)*(2*m+1)/6;
	}
	
	public static boolean isPalindrome(String n) //checks if n is the same as the reverse of n
	{
		String reverse = "", num =String.valueOf(n);
		for(int j =num.length()-1; j>=0; j-- )
		{
			reverse+= num.substring(j,j+1);
		}
		return (num).equals(reverse);
	}
}
