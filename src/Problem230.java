/*
 * The sequence is:
 * A, B, AB, BAB, ABBAB, BABABBAB,...
 * Notice how the length of each term in the sequence corresponds to the fibonacci sequence:
 * 1, 1, 2, 3, 5, 8
 * 
 * Term n will have F(n-2) A's and F(n-1) B's
 * Ex) term 8 has 5 A's and 8 B's for a total of 13.
 * 
 * Look at the sequence in a different way A = 1 and B = 0
 * f(n) = fn-1 + fn-2 (concatenation)
 * f(1) = 1
 * f(2) = 0
 * f(3) = 01
 * f(4) = 010
 * f(5) = 01001
 * f(6) = 01001010
 * 
 * If we substituted A and B into these binary digits, we would get the backwards of the sequence A, B, AB, BAB,...
 * Notice how the first part of the sequence is unchanging.
 * The closed form of the nth digit of the word is 
 * 2 + floor(n*g) - floor((n+1)*g)
 * 
 * Ans: 850481152593119296
 */
import java.math.*;
public class Problem230 {
	static long F[] = new long[0]; //will store the fibonacci numbers
	static String A = "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
	static String B = "8214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196";
	public static void main(String[] args)
	{
		//A = "1415926535";
		//B = "8979323846";
		int r = 92; //stores up untill Fib(r)
		F = new long[r+1];
		F[1] = F[2] = 1;
		for(int i=3; i<F.length; i++)
		{
			F[i] = F[i-1] + F[i-2];
		}
		long sum = 0;
		for(int i=0; i<=17; i++)
		{
			long t = (long)Math.pow(10, i);
			sum+=t*DAB(form(i));
		}
		System.out.println(sum);
		
	}
	public static long form(long n)
	{
		return (127+19*n)*(long)(Math.pow(7,n));
	}
	public static long DAB(long n)
	{
		int i = 1;
		//assume A and B are of equal length
		while(F[i]*A.length() < n)
		{
			i++;
		}
		//now i is the index of the fib word
		//figure out which term in the word you want (not A or B)
		long loc = (n-1)/A.length();
		loc++;
		long exact = n%A.length()-1;
		if(exact == -1) exact+=A.length();
		long d = dig2(loc, i);
		if(d == 1)
		{
			return A.charAt((int)exact) - '0';
		}
		else
		{
			return B.charAt((int)exact) - '0';
		}
	}
	public static long dig(long n)
	{
		//returns 2 + Floor(n*gr) -Floor((n+1)*gr)
		//closed form solution
		BigDecimal g = new BigDecimal("1.61803398874989484820458683436563811772030917980576286213544862270526046281890");
		BigDecimal two = new BigDecimal(""+2);
		BigDecimal v = new BigDecimal(""+n);
		BigDecimal t2 = (v.multiply(g)).setScale(0, RoundingMode.FLOOR);
		BigDecimal t3 = ((v.add(BigDecimal.ONE)).multiply(g)).setScale(0, RoundingMode.FLOOR);
		return (two.add(t2).subtract(t3)).longValue();
		
	}
	
	public static long dig2(long n, int i)
	{
		/*
		 * returns the nth digit in the ith term of the concatenation sequence 1, 0, 10, 010, 10010, 01010010, ..
		 * thus dig(4,5) would return 1 as the fourth digit in the fifth term is 1.
		 * This is done by breaking the terms up into parts. Let F(n) be the nth term in the concatenation sequence
		 * F(n) = F(n-2) + F(n-1) where + is the concatenation operator.
		 * lets say we want to find the kth digit in F(n)
		 * we need to determine whether the kth digit will fall in the F(n-2) part or the F(n-1) part.
		 * Once we know that, we can recurse all the way down to F(1) or F(2), which will give us the desired result.
		 */
		if(i < 3)
		{
			if(i == 1) return 1;
			return 0;
		}
		else
		{
			long a = F[i-2];
			long b = F[i-1];
			if(n > a)
			{
				return dig2(n-a, i-1);
			}
			else
			{
				return dig2(n, i-2);
			}
		}
	}
	
}
