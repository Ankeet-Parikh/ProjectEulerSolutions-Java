
public class Problem549 {
	public static void main(String[] args)
	{
		int r = 100000000;
		r=100;
		long ans = 0;
		boolean[] p = new boolean[r+1];
		int[] val = new int[r+1];
		for(int i = 2; i<=r; i++)
			{
				p[i] = true;
				val[i] = 1<<30;
			}
		for(int i =2; i<=r; i++)
		{
			if(p[i])
			{
				val[i] = i;
				for(int j =2*i; j<=r; j+=i)
				{
					p[j] = false;
					int k = j, l = 0;
					while(k%i == 1) 
					{
						k/=i;
						l++;
					}
					val[i] = min(val[i], func(i, l));
				}
			}
		}
		for(int i=1; i<=r; i++) ans+=val[i];
		System.out.println(val[10]);
		System.out.println(ans);	
	}
	public static int min(int a, int b)
	{
		return a < b ? a : b;
	}
	public static int func(int p, int n)
	{
		//returns the smallest number N such that p^n divides N!
		int N = p*n;
		while(func2(N, p) > n) N-=p;
		int ans = func2(N, p);
		return ans < n? N+1: N;
	}
	
	public static int func2(int n, int p)
	{
		//returns the number of times p occurs in the prime factorization of n!
		int ct = 0;
		int c = p;
		while(c <= n)
		{
			ct+=n/c;
			c*=p;
		}
		return ct;
	}
}
