


public class Problem485 {
	
	public static void main(String[] args)
	{
		
		int u = (int)1e8, k = (int)1e5;
		
		int[] d = new int[u+1];
		for(int i=1; i<d.length; i++)
			for(int j=i; j<d.length; j+=i)
				d[j]++;
		
		
		System.out.println(S(d, u, k));

	}
	
	public static long S(int[] d, int u, int k)//d will contain the number of divisors from 0 to u
	{
		long c=0;
		int n=1;
		int maxd=0, v =0;
		for(;n<=k;n++)
		{
			if(d[n]>maxd) 
			{
				maxd = d[n];
				v = n;
			}
		}
		c+=maxd;	
		for(;n<=u; n++)
		{
			if(n+1-k> v)//need to find the next maximum in the range
			{
				maxd =0; v=0;
				for(int i=n+1-k; i<=n ;i++ )
				{
					if(d[i]>maxd)
					{
						v =i;
						maxd = d[i];
					}
				}
			}
			else
			{
				if(d[n]> maxd)
				{
					v=n;
					maxd = d[n];
				}
			}
			c+=maxd;
		}
		return c;
	}	
}
