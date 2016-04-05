import java.util.ArrayList;


public class Problem278 {
	public static void main(String[] args)
	{
		int range = 5000;
		boolean[] pr = new boolean[range+1];
		ArrayList<Integer> plist = new ArrayList<Integer>(0);
		for(int i=2; i< pr.length; i++) pr[i] = true;
		for(int i=2; i<pr.length; i++)
		{
			if(pr[i])
			{
				for(int j = 2*i; j<pr.length; j+=i)
					pr[j] =false;
				plist.add(i);
			}
		}
		//System.out.println(plist);
		int a =3, b = 5, c =7;
		long sum =0;
		for(int i = 0; i<plist.size()-2; i++)
		{
			int p = plist.get(i);
			for(int j = i+1; j<plist.size()-1; j++)
			{
				int q = plist.get(j);
				for(int k = j+1; k<plist.size(); k++)
				{
					int r = plist.get(k);
					//long c1 =f(new int[]{p*q, p*r, q*r});
					long curr = other(p,q,r);
					//if(c1 != c2)
						//System.out.println("wrong");
					sum+=curr;
				}
			}
		}
		System.out.println(sum);
	}
	
	//implementation of Round robin algorithm
	//http://www.cebitec.uni-bielefeld.de/~zsuzsa/papers/money_changing.pdf
	public static int f(int[] a)
	{
		int Infinity = Integer.MAX_VALUE;
		if(a.length < 2) return -1;
		int[] ni = new int[a[0]];
		ni[0] = 0;
		for(int i=1; i<ni.length; i++) ni[i] =Integer.MAX_VALUE;
		for(int i = 1; i< a.length; i++)
		{
			int d = gcd(a[0], a[i]);
			for(int r = 0; r<=d-1;r++)
			{
				int n =Infinity;
				for(int q = r; q < a[0]; q+=d)
				{
					n = ni[q] < n ? ni[q]:n; 
				}
				if(n < Infinity)
				{
					for(int k = 0; k < a[0]/d; k++)
					{
						n = n + a[i];
						int p = n % a[0];
						n = n < ni[p] ? n:ni[p];
						ni[p] = n;
					}
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < ni.length; i++)
		{
			if(ni[i] > max && ni[i] < Infinity)
			{
				max = ni[i];
			}
		}
		
		return  max == Infinity ? -1 : max - a[0];
	}
	public static long other(long p, long q,  long r)
	{
		
			return 2*p*q*r-p*q-p*r-q*r;
	}
	public static int gcd(int a, int b)
	{
		return b == 0? a: gcd(b, a%b);
	}

}
