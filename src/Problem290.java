
public class Problem290 {
	public static void main(String[] args)
	{
		long c = 0;
		for(int i = 0; i<100000; i++)
		{
			int sd1 = sd(i);
			int sd2 = sd(137*i);
			if(sd1 == sd2)
			{
				System.out.println(i  + " " + i%9);
				c++;
			}
		}
		System.out.println(c);
	}
	
	public static int sd(long n)
	{
		int s = 0;
		while(n > 0)
		{
			s += n%10;
			n/=10;
		} 
		return s;
	}
}
