import java.math.BigInteger;


public class Problem149 {
	static int mod = 1000000;
	public static void main(String[] args)
	{
		long[][] arr ={{-2,5,3,2},{9,-6,5,1},{3,2,7,3},{-1,8,-4,8}};
		arr = generate();
		//compute horizontal and vertial maxima
		System.out.println(horzvertmax(arr));
		

	}
	public static long horzvertmax(long[][] a)
	{
		long[][] h = new long[a.length][a[0].length];
		long[][] v = new long[a.length][a[0].length];
		for(int i=0; i<h.length; i++)
		{
			for(int j=0; j<h[i].length; j++)
			{
				if(j == 0)
					h[i][j] = a[i][j];
				else
				{
					h[i][j] = h[i][j-1]+a[i][j] > a[i][j]? h[i][j-1]+a[i][j] : a[i][j]; 
				}
				if(i == 0)
					v[i][j] = a[i][j];
				else
				{
					v[i][j] = v[i-1][j]+a[i][j] >a[i][j]?v[i-1][j] +a[i][j]: a[i][j]; 
				}
			}
		}
		long hm = max(h), vm = max(v);
		return hm > vm ? hm: vm;
	}
	
	public static long diag1max(long[][] a)
	{
		return 0;
	}
	public static long diag2max(long[][] a)
	{
		return 0;
	}
	public static long max(long[][] a)
	{
		long m =0;
		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<a[i].length; j++)
			{
				if(a[i][j] > m)
					m = a[i][j];
			}
		}
		return m;
	}
	
	public static long[][] generate()
	{
		long[][] a = new long[2000][2000];
		long[] s = new long[4000000];
		for(int i=1; i<=4000000; i++)
		{
			long sk =0;
			if(i <=55)
				sk = S(i);
			else
			{
				sk = (s[i-25] + s[i-56] +mod)%mod -500000;
			}
			s[i-1] =sk;
		}
		for(int n=0; n<4000000; n++)
		{
			a[n/2000][n%2000] = s[n];
		}
		return a;
	}
	
	public static long S(int kval)
	{
		//For 1 ≤ k ≤ 55, sk = [100003 − 200003k + 300007k^3] (modulo 1000000) − 500000
		BigInteger k = new BigInteger(""+kval), m = new BigInteger(""+mod);
		BigInteger a = new BigInteger("100003"), b = new BigInteger("200003"), c= new BigInteger("300007"),
				sub = new BigInteger("500000");
		a = a.subtract(b.multiply(k)).add(c.multiply(k.pow(3)));
		a = a.mod(m).subtract(sub);
		return a.longValue();
	}
	
}
