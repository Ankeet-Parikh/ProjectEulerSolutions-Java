

import java.math.BigInteger;


public class Problem20 {

	
	public static void main(String[] args) {
		int range =100;
		BigInteger total = new BigInteger(String.valueOf(range));
		
		for(int i = range-1; i>= 1; i--)
		{
			total = total.multiply(new BigInteger(String.valueOf(i)));
		}
			
		System.out.println(sumDigits(total));	

	}
	public static int sumDigits(BigInteger b)
	{
		int sum =0;
		String value = b.toString();
		
		for(int i =0; i< value.length();i++)
		{
			sum+= Integer.parseInt(value.substring(i,i+1));
		}
		return sum;
	}
}
