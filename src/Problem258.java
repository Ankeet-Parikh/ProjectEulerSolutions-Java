import java.math.BigInteger;


public class Problem258 {
	public static void main(String[] args)
	{
		long[] g = new long[(int)1e7], f = new long[(int)1e7];
		long mod = 20092010;
		g[0] =1;
		int i=0;
		for(; i<=1999; i++)g[i] =1;
		for(; i<g.length; i++) g[i] = (g[i-2000] + g[i-1999])%mod;
		for(int j = 3999999; j<4000015; j++)
		{
			System.out.println(j+") " + g[j]);
		}
		
	}
	
	public static boolean comp(long[] a, long[] b)
	{
		if(a.length != b.length) return false;
		for(int i=0; i<a.length; i++)
		{
			if(a[i] != b[i]) return false;
		}
		return true;
	}
	
}
