
public class Problem301 {
	public static void main(String[] args)
	{
		int c =0;
		for(int n =1; n<= (Math.pow(2,30)); n++)
		{
			if((n^(2*n)^(3*n)) ==0) 
			{
				c++;
			}
		}
		System.out.println(c);
	}
}
