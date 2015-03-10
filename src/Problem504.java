import java.math.BigInteger;


public class Problem504 {
	static long[] seq = {1,2,3,4,3,2};
	public static void main(String[] args)
	{
		long r = (long)31;
		System.out.println(S(r));
		System.out.println(Brute(r));
		
	}
	
	public static long S(long k)
	{
		
		long mod = 123454321;
		long sum = 0;
		int i = 0;
		long n =1;
		for(;n < 30; n++)
		{
			String s = "";
			do
			{
				s += seq[i % seq.length];
				i++;
			}while(sum(s) < n);
			
			sum+=Long.parseLong(s)%mod;
			sum%=mod;
			System.out.println(n + " " + n%15 + " " + i%6 +") " +s + " : " +sum);
			if(n ==k) return sum%mod;
		}
		sum%=mod;
		long rem = k - 30;
		long[] end = {0,1,2,3,4,0,3,5,3,0,4,3,2,1,0};
		long[] times = new long[15];
		System.out.println(rem + " mod 15 = " + rem%15 +"\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(int j=0; j < end.length; j++)
		{
			times[j]=rem/15;
			if(j <= rem%15)
				times[j]++;
			String e = eIn((int)end[j]);
			System.out.println(j +" "+times[j]+ " " +e);
			long curr = prodmod(times[j]%mod, Long.parseLong(e)%mod, mod);
			sum+=curr%mod;
			
			System.out.println(sum);
			
		}
		Print(times);
		return sum%mod;
		
	}
	public static long prodmod(long a, long b, long mod)
	{
		BigInteger za = new BigInteger("" +a);
		BigInteger zb = new BigInteger("" +b);
		BigInteger zm = new BigInteger("" +mod);
		za = za.mod(zm);
		zb = zb.mod(zm);
		return (za.multiply(zb)).mod(zm).longValue();
	}
	public static String eIn(int i)//index
	{
		/*
		 * returns the last 10 integers before this index
		 */
		i--;
		String s = "";
		for(int k =0; k<14;k++, i--)
		{
			int ind = i%seq.length;
			while(ind < 0) ind+=seq.length;
			s= seq[ind]+s;
		}
		return s;
	}
	public static long sum(String n)
	{
		long s =0;
		for(int i=0; i<n.length(); i++) 
			s+=Character.getNumericValue(n.charAt(i));
		return s;
	}
	public static void Print(long[] a)
	{
		System.out.println(" ");
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i] +" ");
		}
		System.out.println("");
	}
	
	
	public static long Brute(long k)
	{
		long mod = 123454321;
		long sum = 0;
		int i = 0;
		long n =1;
		for(;n <= k; n++)
		{
			String s = "";
			do
			{
				s += seq[i % seq.length];
				i++;
			}while(sum(s) < n);
			
			BigInteger m = new BigInteger(s).mod(new BigInteger(""+mod));
			sum+=m.longValue()%mod;
			sum%=mod;
			System.out.println( n+ ")  "+s+ ": " +sum);
			
		}
		return sum%=mod;
	}
}
