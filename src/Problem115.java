
public class Problem115 {
	public static void main(String[] args)
	{
		int m = 50;
		for(int n =5;; n++)
		{
			if(F(m, n) > 1000000)
			{
				System.out.println(n);
				break;
			}
		}
		
	}
	
	public static long F(int m, int n)
	{
		long w[] = new long[n+1];
		w[0] = 1;
		w[1] = 1;
		w[2] = 1;
		for(int i=3; i<=n; i++)
		{
			w[i] += w[i-1];
			if(i >=m) w[i]+=1;
			for(int j = m+1; j<=i; j++)
			{
				if(i>=j) w[i] +=w[i-j];
			}
		}
		return w[n];
	}
}
