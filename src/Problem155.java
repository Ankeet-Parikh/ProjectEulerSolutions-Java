import java.util.*;
public class Problem155 {
	public static void main(String[] args)
	{
		int max = 18;
		long ct = 0;
		
		Fraction[][] list = new Fraction[max+1][17000000];
		int[] size = new int[max+1];
		Fraction init = new Fraction(1, 1);
		list[1][0] = init;
		size[1] = 1;
		
		Fraction[] all = new Fraction[10000000];
		all[0] = init;
		int allsize = 1;
		
		
		for(int i=2; i<=max; i++)
		{
			
			for(int j=1; j<=i/2; j++)
			{
				for(int k=0; k < size[j]; k++)
				{
					Fraction a = list[j][k];
					if(a == null) continue;
					long a1 = a.n;
					long a2 = a.d;
					
					for(int l=0; l< size[i-j];l++)
					{
						
						Fraction b = list[i-j][l];
						if(b == null) continue;
						long b1 = b.n;
						long b2 = b.d;
						list[i][size[i]] = new Fraction( a1*b2+b1*a2, a2*b2);
						size[i]++;
						list[i][size[i]] = new Fraction( a1*b1, a1*b2 + b1*a2);
						size[i]++;
					}
				}
			}
			Arrays.sort(list[i], 0, size[i]);
			for(int j=0; j < size[i]-1; j++)
			{
				if(Fraction.isequal(list[i][j], list[i][j+1]))
				{
					list[i][j] = null;
				}
				
			}
			int added = 0;
			for(int j=0; j < size[i]; j++)
			{
				if(list[i][j] != null)
				{
					all[allsize] = list[i][j];
					allsize++;
					added++;
				}
			}
			//System.out.println(i + " " + added);
		}
		Arrays.sort(all, 0, allsize);
		for(int i=0; i<allsize-1; i++)
		{
			if(Fraction.isequal(all[i], all[i+1]))
			{
				all[i] = null;
			}
		}
		for(int i=0; i<allsize; i++)
		{
			if(all[i] != null)
			{
				ct++;
			}
		}
		System.out.println(ct);
	}
	
	
	
	static class Fraction implements Comparable{
		public long n = 0, d = 1;
		public Fraction(long num, long denom)
		{
			n = num;
			d = denom;
			reduce();
		}
		
		public static boolean isequal(Fraction a, Fraction b)
		{
			return a.n == b.n && a.d == b.d;
		}
		
		public int compareTo(Object o)
		{
			Fraction b = (Fraction)o;
			long ans = this.n*b.d-this.d*b.n;
			if(ans > 0) return 1;
			if(ans < 0) return -1;
			return 1;
		}
		
		private void reduce()
		{
			long g = gcd(this.n, this.d);
			this.n/=g;
			this.d/=g;
		}
		
		private static long gcd(long a, long b)
		{
			return b == 0? a : gcd(b, a%b);
		}
		
		public String toString()
		{
			String res = this.n + "/" + this.d;
			return res;
		}

		

		
	}
}
