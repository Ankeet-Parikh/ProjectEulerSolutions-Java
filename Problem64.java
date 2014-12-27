package problems_60_69;

public class Problem64 {
	public static void main(String[] args)
	{
		
		long count=0;
		for(long i=2;i<10000;i++)
		{
			if(periodLength(i)%2==1)
				count++;
		}
		System.out.println(count);
		
	}
	public static long periodLength(long n)
	{
		
		long m=0;
		long d=1;
		long a_0=(long)(Math.floor(Math.sqrt(n)));
		
		if(a_0*a_0 == n) return 0;
		
		long count=0;
		long a=a_0;
		while(a != 2*a_0)
		{
			m = d*a-m;
			d =(n-m*m)/d;
			a=(long)Math.floor((a_0+m)/(double)d);
			
			count++;
		}
		return count;
	}

}
