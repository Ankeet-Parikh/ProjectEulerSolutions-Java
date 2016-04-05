
/*
 * F(n) for n < 0 = 0
 * F(0) = 1;
 * F(n) = F(n-1) + F(n-2) + F(n-3) + f(n-4)
 */
public class Problem117 {
	public static void main(String[] args)
	{
		int n = 50;
		long f[] = new long[n+1];
		f[0] = 1;
		f[1] = 1;
		for(int i=2; i<=n ;i++)
		{
			f[i]+=f[i-1];
			if(i >= 2) f[i] +=f[i-2];
			if(i >= 3) f[i] +=f[i-3];
			if(i >= 4) f[i] +=f[i-4];
		}
		System.out.println(f[50]);
	}
	
}
