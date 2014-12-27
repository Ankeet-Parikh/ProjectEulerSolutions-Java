package problems_30_39;

public class Problem33 {

	
	public static void main(String[] args) {
		int num =1, denom =1;
		for(int d =10; d <=99; d++ )
		{
			for(int n = 10; n<d; n++)
			{
				if(isCurious(n,d))
				{
					//System.out.println(n + "/" +d);
					num*=n;
					denom*=d;
				}
			}
		}
		System.out.println(denom/=GCD(num,denom));
	}
	public static int GCD(int a, int b)
	{
		if(b == 0) return a;
		return GCD(b, a%b);
	}
	
	public static boolean isCurious(int n, int d)
	{
		if(n/10 == d%10)
		{
			if((double)(n)/(double)d == (double)(n%10)/(double)(d/10))
				return true;
		}
		if(n%10 == d/10)
		{
			
			if((double)(n)/(double)(d) == (double)(n/10)/(double)(d%10))
				return true;
		}
		return false;
	}

}
