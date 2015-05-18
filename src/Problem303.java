
public class Problem303 {
	public static void main(String[] args)
	{
		System.out.println(fnn(9));
	}
	
	public static long fnn(long n)
	{
		long m = 1;
		while(!prop(m*n))
		{
			m++;
		}
		return m;
	}
	
	public static boolean prop(long n)
	{
		while(n != 0)
		{
			long c = n%10;
			if(!(c == 0 || c== 2 || c== 1)) return false;
			n/=10;
		}
		return true;
	}
}
