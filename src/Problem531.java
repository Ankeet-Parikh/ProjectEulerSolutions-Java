//chinese remainder theorem
public class Problem531 {
	public static void main(String[] args)
	{
		
		int l = 1000000;
		int u = 1005000;
		int[] tot = tots(u);
		long c = 0;
		for(int n = l; n<u; n++)
		{
			for(int m = n+1; m<u; m++)
			{
				int a = tot[n];
				int b = tot[m];
				int g = gcd(n, m);
				if((a%g) == (b%g))
				{
					c+=crt(a, n, b, m);
				}
			}
		}
		System.out.println(c);
	}
	
	public static long crt(int a, int n, int b, int m)
	{
		//solves x = a mod n
		// x = b mod m
		int[]e = eed(n, m);
		//System.out.println(e[0] + " " + e[1] + " " + e[2]);
		int mult = (b-a)/e[0];
		long k = (long)e[1]*mult;
		long res = n*k+a;
		long lcm = ((long)n * m )/e[0];
		res%=lcm;
		while(res < 0)
		{
			res +=lcm;
		}
		return res;
		
	}
	
	static int[] eed(int a, int b) {
		if(b == 0) return new int[]{a, 1, 0};
		int[] vals = eed(b, a%b);
		int d = vals[0];
		int s = vals[2];
		int t = vals[1] - (a/b)*vals[2];
		return new int[]{d,s,t};
	  }
	public static int[] tots(int u)
	{
		int[] tot = new int[u+1];
		for(int i=1; i<tot.length; i++) tot[i] = i;
		for(int i =2; i< tot.length; i++)
		{
			if(tot[i] == i)
			{
				for(int j = i;j<tot.length; j+=i)
				{
					tot[j] = tot[j] / i * (i-1);
				}
			}
		}
		return tot;
	}
	public static int gcd(int a, int b)
	{
		return b ==0 ? a: gcd(b, a%b);
	}
}
