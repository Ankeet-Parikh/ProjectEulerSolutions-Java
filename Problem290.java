package src;

public class Problem290 {

	
	public static void main(String[] args) {
		long count =0;
		for(long i =0; i<Math.pow(10,3); i+=9)
		{
			if(SameSumDigits(i, 137*i))
			{
				count++;
				System.out.println(i);
			}
			
		}
		System.out.println(count);
	}
	
	public static boolean SameSumDigits(long a, long b)
	{
		long sumA =0, sumB =0;
		while(a != 0 || b !=0)
		{
			if(a!=0)
			{
				sumA +=a%10;
				a/=10;
			}
			if(b!=0)
			{
				sumB+=b%10;
				b/=10;
			}
		}
		return sumA == sumB;
	}

}
