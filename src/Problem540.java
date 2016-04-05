import java.util.Arrays;

public class Problem540 {
	
	static long ct = 0;
	static long r = 3141592653589793l;
	public static void main(String[] args)
	{
		r = 50;
		System.out.println(Pbrute(50));
		int rt = (int) Math.sqrt(r);
		/*
		 * iterate on m and n
		 * m^2 + n^2 <= r
		 * m and n are coprime
		 * m-n is odd
		 */
		int[] msns = new int[rt+1]; //m^2 + n^2
		int[] mmn = new int[rt+1]; //m-n is odd
		int[] cop = new int[rt+1]; 
		int[] num = new int[rt+1];
		int[] den = new int[rt+1];
		for(int m=2; m<msns.length ;m++)
		{
			msns[m] = (int) Math.min(m-1, Math.sqrt(r-m*m));//account for m^2+n^2 <=r
			if(m%2 == 1)
			{
				mmn[m] = msns[m]/2;
			}
			else
			{
				if(m%2 == msns[m]%2) //both even
				{
					mmn[m] = msns[m]/2;
				}
				else //even and odd
				{
					mmn[m] = msns[m]/2 + 1;
				}
			}
		}
		boolean[] p = new boolean[rt+1];
		for(int i=2; i<p.length; i++)
			{
				p[i] = true;
				num[i] = 1;
				den[i] = 1;
			}
		for(int i=2; i<p.length; i++)
		{
			if(p[i])
			{
				for(int j= 2*i; j<p.length; j+=i)
				{
					p[j] = false;
				}
			}
		}
		for(int i=3; i<p.length; i++)
		{
			if(p[i])
			{
				for(int j= i; j<p.length; j+=i)
				{
					num[j]*=(i-1);
					den[j]*=i;
				}
			}
		}
		System.out.println(Arrays.toString(msns));
		System.out.println(Arrays.toString(mmn));
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(den));
		long sum = 0;
		for(int i=2; i<=rt; i++)
		{
			/*if(mmn[i] == 1)
			{
				sum+=1;
			}
			else*/
			{
				sum+= (mmn[i]* (long) num[i])/ den[i];
			}
		}
		System.out.println(sum);
	}
	
	public static long gcd(long a, long b)
	{
		return b ==0?  a: gcd(b, a%b);
	}
	
	public static int Pbrute(int n)
	{
		int ct = 0;
		for(int a = 1; a+2 <=n; a++)
		{
			for(int b = a+1; b+1 <=n ;b++)
			{
				long c = (long) Math.sqrt(a*a+b*b);
				if(c <=n && c*c == a*a + b*b)
				{
					if(gcd(a, gcd(b,c)) == 1)
					{
						System.out.println(a + " " + b + " " + c);
						ct++;
					}
				}
			}
		}
		return ct;
	}

}
