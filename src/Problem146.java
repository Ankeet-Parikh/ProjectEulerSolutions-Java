import java.util.Arrays;
public class Problem146 {
	/*
	 * n must be even (if n was odd, then n^2+1 would be even and thus, not prime)
	 * if n ends in 8, n^2 will end in 4, so n^2+1 will end in 5, not prime
	 * if n ends in 2, n^2 will also end in 4, so n^2+1 will end in 5, not prime (start iterating up at 10)
	 * if n ends in 6 or 4, n^2 will end in 6, n^2 + 9 will end in 5, not prime
	 * 
	 * n must end in 0, that is, n must be a multiple of 10
	 * let n = 10 * x
	 * x cannot be a multiple of 3, 7, or 13
	 * 
	 */
	public static void main(String[] args)
	{
		int r = 150;
		boolean[] p = new boolean[r+1];
		for(int i=1; i<p.length; i++) p[i] = true; //set all to true, sieve afterwards
		int c = 0;
		for(int i=1; i<p.length; i++)
		{
			if(i %3 ==0 || i%7 ==0 || i%13 == 0)
				p[i] = false;
			else
			{
					c++;
					System.out.println(10*i);
			}
		}
		System.out.println(c);
	}
	
	
	
}
