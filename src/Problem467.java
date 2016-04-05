/*
 * We are attempting to find the shortest common supersquence
 * 1) Find the longest common subsequence
 * 2)
 */
import java.math.BigInteger;
public class Problem467 {
	public static void main(String[] args)
	{
		int n = 10000;
		
		boolean p[] = Sieve(15*n);
		String pd = "", cd = "";
		for(int i=2; i<p.length; i++)
		{
			if(p[i] && pd.length() < n)
			{
				pd = pd + (i - 9*((i-1)/9));
			}
			else if(cd.length() < n)
			{
				cd = cd + (i - 9*((i-1)/9));
			}
		}
		System.out.println(SCS("2357248152","4689135679"));
		/*
		String s = SCS(pd, cd);
		BigInteger b = new BigInteger(s);
		int mod = 1000000007;
		System.out.println(b.mod(new BigInteger(""+mod)));
		*/
	}
	public static String SCS(String a, String b)
	{
		int[][] L = new int[a.length()+1][b.length()+1];
		for(int i=0;i<=a.length();i++)
		{
			for(int j = 0; j<=b.length(); j++)
			{
				if(i == 0)
					L[i][j] = j;
				else if(j == 0)
					L[i][j] = i;
				else if(a.charAt(i-1) == b.charAt(j-1))
				{
					L[i][j] = 1 + L[i-1][j-1];
				}
				else
				{
					L[i][j] = 1 + (int)Math.min(L[i-1][j], L[i][j-1]); 
				}
			}
		}
		char[] lcs = new char[L[a.length()][b.length()]];
		System.out.println(lcs.length);
		int ind = lcs.length;
		int i = a.length(), j = b.length();
		while(i>=0 && j >=0)
		{
			if(a.charAt(i-1) == b.charAt(j-1))
			{
				lcs[ind-1] = a.charAt(i-1);
				ind--;
				i--; j--;
			}
			else if(L[i-1][j] < L[i][j-1])
			{
				lcs[ind-1] = a.charAt(i-1);
				ind--;
				i--;
			}
			else
			{
				lcs[ind-1] = b.charAt(j-1);
				ind--;
				j--;
			}
		}
		return new String(lcs);
	}
	public static boolean[] Sieve(int n)
	{
		
		boolean[] p = new boolean[n+1];
		for(int i=2; i<p.length; i++)
			p[i] = true;
		for(int i =2; i<p.length; i++)
		{
			if(p[i])
			{
				for(int j=2*i; j<p.length; j+=i)
					p[j] = false;
			}
		}
		return p;
	}
}
