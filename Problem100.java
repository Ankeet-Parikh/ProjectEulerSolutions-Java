package problems_100_109;

public class Problem100 {
	public static void main(String[] args)
	{
		long limit =(long)(Math.pow(10,12));
		long blue =15, total=21;
		while(total <limit)
		{
			long b = blue;
			long t = total;
			
			blue  =3*b + 2*t -2;
			total =4*b + 3*t -3;
		}
		System.out.println(blue);
	
	}
}
