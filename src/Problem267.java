import java.util.Arrays;

public class Problem267 {
	public static void main(String[] args)
	{
		double a = 1;
		int flips = 1000;
		double target = 1000000000;
		
		int min = 1000;
		for(double f = 0.1;f<.3;f+=0.01)
		{
			int cur =  getminval(flips, f, target);
			min = cur < min ?  cur : min;
		}
		//System.out.println(min);
		double num = getnum(flips, min);
		double denom = Math.pow(2, flips);
		System.out.printf("%.12f", num/denom);
	}
	public static int getminval(int flips, double f, double target)
	{
		/*
		 * After n flips of the coin, there are n+1 distinct possibilities as to how
		 * much capital you have left. We can see this by looking at the binary tree
		 * created by the flips. After 1 flip you can either have 1+2f or 1-f. After
		 * 2 flips you can have (1+2f)^2, (1+2f)(1-f), or (1-f)^2. After n flips you
		 * can have (1+2f)^n, (1+2f)^(n-1) * (1-f)^1, ..., (1+2f)^1 * (1-f)^(n-1),
		 * (1-f)^n. This method will return the minimum value of k such that 
		 * (1+2f)^k * (1-f)^(n-k) > target
		 * 
		 * 
		 * Here is the math
		 * (1+2f)^k * (1-f)^(n-k) > target
		 * log10((1+2f)^k * (1-f)^(n-k)) > log10(target)
		 * log10((1+2f)^k) + log10((1-f)^(n-k)) > log10(target)
		 * k*log10(1+2f) + n*log10(1-f) - k*log10(1-f) > log10(target)
		 * k*log10(1+2f) - k*log10(1-f) > log10(target) - n*log10(1-f)
		 * k > (log10(target) - n*log10(1-f))/(log10(1-2f) + log10(1-f)) 
		 * 
		 */
		
		int n=0;
		while(n<=flips)
		{
			if( Math.pow(1+2*f, n) * Math.pow(1-f, 1000-n) > target) break;
			n++;
		}
		return n;
		
	}
	public static double getnum(int r, int start)
	{
		//let p[r] be the  rth row of pascal's triangle
		//this method returns sum (i = start to r) p[i]
		//row is 1 based
		double[] row = {1,1};
		for(int i=2; i<=r; i++)
		{
			double[] next = new double[i+1];
			for(int j=0; j<next.length; j++)
			{
				if(j == 0 || j == i) next[j] = 1;
				else next[j] = row[j-1] + row[j];
			}
			row = next;
		}
		//System.out.println(Arrays.toString(row));
		double sum = 0;
		for(int i=start; i<=r; i++)
			sum+= row[i];
		return sum;
	}
}
