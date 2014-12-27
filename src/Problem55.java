

import java.math.BigInteger;

public class Problem55 {

	
	public static void main(String[] args) {
		
		int numLychrels = 0;
		for(int i =1 ; i< 10000; i++)
		{
			boolean isLychrel = true;
			BigInteger sum = new BigInteger(String.valueOf(i));
			for(int j = 1; j< 50; j++)
			{
				sum = sum.add(getReverse(sum));
				if(isPalindrome(sum)) 
				{
					isLychrel =false;
					break;
				}
				
			}
			if(isLychrel) numLychrels++;
		}
		System.out.println(numLychrels);

	}
	public static BigInteger getReverse(BigInteger b)
	{
		String reverse ="";
		for(int i = b.toString().length()-1; i>=0 ;i--)
			reverse+=b.toString().substring(i,i+1);
		return new BigInteger(reverse);
	}
	public static boolean isPalindrome(BigInteger b)
	{
		String reverse ="";
		String n = b.toString();
		for(int i = n.length()-1; i>=0 ;i--)
			reverse+=n.substring(i,i+1);
		return n.equals(reverse);
	}

}
