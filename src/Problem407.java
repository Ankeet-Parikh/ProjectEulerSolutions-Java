
public class Problem407 {
	public static void main(String[] args)
	{
		for(int i=2; i<100;i++)
		{
			int m = M(i);
			
			if(m != 1)
			System.out.println(i+") " +M(i));
		}
		
	}
	
	public static int M(int n)
	{
		int k = 0;
		for(int a=1; a<n; a++)
		{
			if((a*a)%n == a%n)
				k =a;
		}
		return k;
	}
}
