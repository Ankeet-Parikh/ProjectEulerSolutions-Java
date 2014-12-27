package src;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;


public class Problem266 {

	
	public static void main(String[] args) {
		BigInteger productPrimes = new BigInteger("5397346292805549782720214077673687806275517530364350655459511599582614290");
		System.out.println(PSR(productPrimes).mod(new BigInteger("10000000000000000")));
	}
	
	public static BigInteger PSR(BigInteger n)
	{
		BigInteger count = squareRoot(n); 
		
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		for(;count.compareTo(one) > 0; count = count.subtract(one))
		{
			if(n.mod(count).compareTo(zero) == 0)
				return count;
		}
		return one;
	}
	
	public static BigInteger squareRoot(BigInteger n) //this is a good approximation
	{
		BigDecimal half = new BigDecimal("0.5");
		BigDecimal num = new BigDecimal(n);
		BigDecimal x = new BigDecimal("1");
		
		/*
		 * formula:  x = 1/2(x+n/x)
		 */
		for(int i =0; i< 20; i++) //that shoud be enough iterations
		{
			x = half.multiply(x.add(num.divide(x, 50, RoundingMode.HALF_UP)));
		}
		
		return x.toBigInteger();
	}
}
