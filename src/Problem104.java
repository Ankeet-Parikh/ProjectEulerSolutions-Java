
import java.util.Arrays;

public class Problem104 {

	
	public static void main(String[] args) 
	{
		/*
		 * The last 9 digits are easy, just mod 10^9 each time.
		 * To generate the first 9 digits, use the closed form:
		 * F(n) = (golden ratio)^n / Square root of 5.
		 * Precompute golden ratio and the square root of 5 to enough decimal places
		 * We only want the first nine digits, so we take the log10 of both sides:
		 * log10(F) = n*log10(golden ratio) - log10(square root of 5)
		 * The value on the right will have a whole number part and a fractional part.
		 * Since the whole number part only shifts the number down, we only need to consider 
		 * the fractional part. Then, raise 10 to this fractional part, and the first 9
		 * significant digits are the first nine digits of the nth Fibonacci number.
		 */
		
		long a =1, b =2, c=a+b, i=4;
		long mod =(long)1e9;
		double r5 = Math.sqrt(5);
		double gr = (1+r5)/2;
		while(true)
		{
			
			if(isPandigital(""+c))
			{
				//test if first nine are pandigital
				double logf = i*Math.log10(gr) - 0.5*Math.log10(5);
				logf = logf - Math.floor(logf);
				double first9 = Math.pow(10, logf);
				long f9 = (long) (first9 * 1e8);
				if(isPandigital("" +f9))
				break;
			}
			a=b;
			b=c;
			c=(a+b)%mod;
			i++;
		}
		System.out.println(i);
	}
	
	
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
