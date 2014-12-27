package src;

public class Problem308 {
	static long[] nums   ={17, 78, 19, 23, 29, 77, 95, 77,  1, 11, 13, 15, 1, 55};
	static long[] denoms ={91, 85, 51, 38, 33, 29, 23, 19, 17, 13, 11,  2, 7,  1}; 
	public static void main(String[] args)
	{
		
		System.out.println(getNext(425));
		
		
	}
	public static boolean powerOf(double n, double a) //tests if n is a power of a
	{
		while(n%a ==0 )
		{
			n = Math.floor(n/a);
			
		}
		return n ==1;
	}
	public static double getNext(double a)
	{
		for(int i = 0; i<nums.length; i++)
		{
			long n = nums[i];
			long d = denoms[i];
			if(((a%d)*(n%d))%d == 0)//means that a*n/d will be an integer
			{
				return a*n/d;
			}
		}
		return 0;
	}
	
}
