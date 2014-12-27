

import java.math.BigInteger;

public class Problem57 {

	
	public static void main(String[] args) {
		long numDigits =0;
		for(int i =1; i<=1000; i++)
		{
			BigInteger numerator = new BigInteger("1"), denominator =new BigInteger("2");
			for(int j =i; j>0; j--)
			{
				if(j == 1) 
				{
					numerator= numerator.add(denominator);
				}
				else
				{
					numerator=numerator.add(denominator.multiply(new BigInteger("2")));
					BigInteger temp = numerator;
					numerator = denominator;
					denominator = temp;
				}
			}
		
			if(numDigits(numerator)>numDigits(denominator))numDigits++;
		}
		System.out.println(numDigits);		

	}
	public static int numDigits(BigInteger num)
	{
		int digits =0;
		while(num.compareTo(new BigInteger("0")) >0)
		{
			num = num.divide(new BigInteger("10"));
			digits++;
		}
		return digits;
	}

}
