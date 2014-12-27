

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;

public class Problem104 {

	
	public static void main(String[] args) 
	{
		long a =1, b =1, c=a+b, i=3;
		long mod =1000000000L;
		for(;;)
		{
			a=b;
			b=c;
			c=(a+b)%mod;
			i++;
			if(isPandigital(""+c))
				break;
			
		}
		System.out.println(i);
	}
	/*
	public static BigInteger F(int k)
	{
		BigDecimal one = new BigDecimal("1");;
		BigDecimal gr = new BigDecimal("1.6180339887498948482045868343656381177203091798");
		BigDecimal r5 = new BigDecimal("2.23606797749");
		BigDecimal numerator = gr.pow(k).subtract(one.subtract(gr).pow(k));
		BigInteger fib = numerator.divide(r5, 2, RoundingMode.HALF_UP).toBigInteger();
		return fib;
	}*/
	
	public static boolean isPandigital(String n)
	{
		char[] digits = n.toCharArray();
		if(digits.length != 9) return false;
		Arrays.sort(digits);
		for(int i =0; i<digits.length; i++)
		{
			if(digits[i] != '1' + i)
				return false;
		}
		return true;
	}
}
