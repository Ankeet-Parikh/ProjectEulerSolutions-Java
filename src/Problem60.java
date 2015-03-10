

public class Problem60 {
	public static void main(String[] args)
	{
		System.out.println(Double.MAX_VALUE);
	}
	
	public static boolean isPrime(long n)
	{
		if(n == 2) return true;
		if(n%2 ==0) return false;
		for(int i=3; i<=Math.sqrt(n); i+=2)
		{
			if(n%i==0) return false;
		}
		return true;
	}
	
}
