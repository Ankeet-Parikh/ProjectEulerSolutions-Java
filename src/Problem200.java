import java.util.*;
import java.math.BigInteger;
public class Problem200 {
	static ArrayList<Long> sq = new ArrayList<Long>(0);
	public static void main(String[] args)
	{
		ArrayList<Long> pr = new ArrayList<Long>(0);
		
		boolean[] p = new boolean[353553392];
		
		for(int i =2; i< p.length; i++) p[i] = true;
		for(int i =2; i<p.length; i++)
		{
			if(p[i] == true)
			{
				for(int j = 2*i; j< p.length; j+=i)
					p[j] = false;
				pr.add((long)i);
			}
		}
		
		for(int i =0; i< pr.size()-1 ; i++)
		{
			for(int j = i+1; j<pr.size(); j++)
			{
				int a =squbes(pr.get(i), pr.get(j));
				if(a == -1) break;
			}
		}
		Collections.sort(sq);
		System.out.println(sq.size());		
		int ct = 0;
		for(int i =0; i< sq.size(); i++)
		{
			long curr = sq.get(i);
			if(PrimeProof(curr))
			{
				ct++;
			}
			if(ct == 200)
			{
				System.out.println(curr);
				break;
			}
		}
	}
	public static int squbes(long a, long b)
	{
		BigInteger max = new BigInteger(""+Long.MAX_VALUE);
		BigInteger s = new BigInteger(""+a);
		BigInteger q = new BigInteger(""+b);
		
		for(int i=1; i<=2; i++)
		{
			BigInteger sqube = s.pow(2).multiply(q.pow(3));
			if(sqube.compareTo(max) <= 0)
			{
				if(sqube.toString().contains("200"))
				{
					sq.add(sqube.longValue());
				}
			}
			else
			{
				//System.out.println("something");
				return -1;
			}
			BigInteger temp = s;
			s = q;
			q = temp;	
		}
		return 0;
	}
	public static boolean PrimeProof(long n)
	{
		String v = ""+n;
		int l = v.length();
		char[] dig = v.toCharArray();
		for(int r = 0; r <l; r++)
		{
			//r is the index of the character to replace
			
			char orig = dig[r];
			BigInteger m = new BigInteger("0");
			for(int i = 0; i<=9; i++)
			{
				dig[r] = (char)('0'+i);
				String k = new String(dig);
				m = new BigInteger(k);
				if(m.isProbablePrime(20))
				{
					return false;
				}
			}
			dig[r] = orig;
		}
		
		return true;
	}
}
