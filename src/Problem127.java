
public class Problem127 {
	public static void main(String[] args)
	{
		long s = 0;
		long r = 1000;
		for(int a = 1; 2*a+1<r ; a++)
		{
			for(int b = a+1; a+b < r; b++)
			{
				if(gcd(a,b) == 1)
				{
					int c = a+b;
					if(radProp(a*b*c, c))
					{
						s+=c;
						System.out.println(a +", " + b +", " + c);
					}
				}
			}
		}
		System.out.println(s);
	}
	
	public static int gcd(int a, int b)
	{
		return b==0? a: gcd(b, a%b);
	}
	
	public static boolean radProp(long num, int c)
	{
		long rad = 1;
		for(int i=2; i< c; i++)
		{
			if(num%i==0)
			{
				rad*=i;
				while(num%i==0) num/=i;
			}
		}
		if(num != 1) return false;
		return rad < c;
	}
}
