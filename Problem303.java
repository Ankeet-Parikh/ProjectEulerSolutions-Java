package src;

public class Problem303 {
	public static void main(String[] args)
	{
		System.out.println(digitsLess(1200120100120102D,2));
		long mult =0;
		System.out.println(minmultf(42, mult));
	}
	
	//returns least n such that all the digits
	// in n*m is less than or equal to 2
	public static long minmultf(long m, long mult)
	{
		ArrayList<Long> multipliers = new ArrayList<Long>(0);
		for(int i=1; i<=9; i++)
		{
			long by = Long.parseLong(i+mult);
		}
		
	}
	//returns true if all the digits of m are less than or equal to cutoff
	public static boolean digitsLess(double n, long  cutoff)
	{
		while(n != 0)
		{
			if(n%10 > cutoff) return false; 
			n = Math.floor(n/10.0);
		}
		return true;
	}

}
