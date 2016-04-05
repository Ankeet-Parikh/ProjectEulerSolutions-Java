
public class Problem286 {
	public static void main(String[] args)
	{
		// dp[i][j] = probability that you
		int i = 0;
		double l = 50.1, u = 55, t = 0.02;
		double mid = (l+u)/2;
		while(i < 5000)
		{
			mid = (l+u)/2;
			double p = prob(mid);
			//bisection on reals
			if(p > t)
			{
				l = mid;
			}
			else // p < t
			{
				u = mid;
			}
			i++;
		}
		System.out.printf("%.10f\n", mid);
	}
	
	public static double prob(double q)
	{
		//returns the probability that 20 points were made
		
		// dp[i][j] = after taking the first i shots,
		// you make j of them
		// only defined when 0<=j<=i
		double dp[][] = new double[51][51];
		dp[1][0] = 1.0/q;   //chance that you miss the shot
		dp[1][1] = 1-1.0/q; //chance that you make the shot
		for(int i = 2; i<=50; i++)
		{
			for(int j=0; j<=i; j++)
			{
				if(j == 0)
				{
					
					dp[i][j] = dp[i-1][j] * i/q;
				}
				else
				{
					dp[i][j] = dp[i-1][j] * (i/q) +  dp[i-1][j-1] *(1-i/q);
				}
			}
		}

		return dp[50][20];
	}
}
