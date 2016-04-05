
public class Problem527 {
	public static void main(String[] args)
	{
		long n = 10000000000l;
		System.out.println(B(n));
	}
	
	public static double B(long n)
	{
		long k = (long)((Math.log(n))/(Math.log(2)));
		k+=1;
		return (1 + (n+1)*k - (Math.pow(2, k)) )/n;
	}
	
	public static double R(long n)
	{
		double s = 0;
		return s/n;
	}
}
