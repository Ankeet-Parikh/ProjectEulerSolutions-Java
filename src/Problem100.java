

public class Problem100 {
	public static void main(String[] args)
	{

		long blue =15, total=21;
		while(total < 1e12)
		{
			long b = blue;
			long t = total;
			
			blue  = 3*b + 2*t -2;
			total = 4*b + 3*t -3;
		}
		System.out.println(blue);
	
	}
}
