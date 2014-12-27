package problems_210_219;

public class Problem216 {
	public static void main(String [] args)
	{
		long s = 7;
		long t = 10;
		for(int i=2; i<100; i++)
		{
			if(isPrime(s))
				System.out.println(i +") "+ s);
			s+=t;
			t+=4;
		}
	}
	
	public static boolean isPrime(long n)
	{
		for(int i =2; i<=Math.sqrt(n); i = i ==2?i+1:i+2)
		{
			if(n%i ==0)return false;
		}
		return true;
	}
}
