import java.util.HashMap;
import java.util.ArrayList;
public class Problem315 {
	static HashMap<Integer, Integer[]> trans = new HashMap<Integer, Integer[]>();
	
	public static void main(String[] args)
	{
		precompute();
		System.out.println("Precomputed");
		int l = (int)1e7, u = 2*l;
		long sum = 0;
		for(int i=l; i<u; i++)
		{	
			if(isPrime(i))
			{
				int[] drc = dr(i);
				sum+=Sam(drc)-Max(drc);
			}
		}
		System.out.println(sum);
		
	}
	
	public static int Sam(int[] a)
	{
		//parameters are a, and the sum of its digits b
		//returns the number of transitions from a to b using sam's clock
		int s = 0;
		for(int i =0; i<a.length; i++)
		{
			int m = a[i];
			while(m>0)
			{
				s+=seg(m%10).length;
				m/=10;
			}
		}
		return s*2;
	}
	
	public static int Max(int[] a)
	{
		//returns the number of transitions Max's clock will perform
		//on the digital root chain a
		//137 -> 11 ->2 will be 30 transitions
		int s =0;
		int m = a[0];
		while(m > 0)
		{	
				s+=seg(m%10).length;
				m/=10;
		}
		for(int i=0; i<a.length-1; i++)
		{
			int fir = a[i], sec = a[i+1];
			while(fir > 0)
			{
				if(sec == 0)
				{
					s+=seg(fir%10).length;
					fir/=10;
				}
				else
				{
					s+=trans.get(fir%10)[sec%10];
					fir/=10;
					sec/=10;
				}
			}
		}
		m = a[a.length-1];
		while(m > 0)
		{	
				s+=seg(m%10).length;
				m/=10;
		}
		return s;
	}
	
	public static void precompute()
	{
		for(int i=0; i<=9; i++)
		{
			Integer[] transitions = new Integer[10];
			for(int j = 0; j<=9; j++)
			{
				if(i == j) transitions[j] = 0;
				else
				{
					int[] si = seg(i), sj = seg(j);
					int numcom = 0;
					for(int k = 0; k<si.length; k++)
					{
						for(int l = 0; l<sj.length; l++)
						{
							if(sj[l] == si[k]) numcom++;
						}
					}
					transitions[j] = si.length+sj.length-2*numcom;
				}
			}
			trans.put(i, transitions);
		}
	}
	public static int[] dr(int n)
	{
		//returns the digital root chain for n
		//example: 137 -> 11 -> 2
		//99 -> 18 -> 9
		ArrayList<Integer> dc = new ArrayList<Integer>(0);
		dc.add(n);
		while(n >= 10)
		{
			n = sumd(n);
			dc.add(n);
		}
		//System.out.println(dc);
		int[] d = new int[dc.size()];
		for(int i=0; i<d.length; i++) d[i] = dc.get(i);
		return d;
	}
	
	public static int[] seg(int d)
	{
		//returns the segments needed to turn this digit on
		/*
		 * On the root clock:
		 * 3 horizontal: {top, middle, bottom} = {1, 2, 3}
		 * 4 vertical: {top left, top right, bottom left, bottom right}= {4,5,6,7}
		 *|---1---|
		 *|       |
		 *4       5 
		 *|       |
		 *|---2---|
		 *|       |
		 *6       7
		 *|       |
		 *|---3---|
		 *
		 */
	
		if(d == 0) return new int[]{1,3,4,5,6,7};
		if(d == 1) return new int[]{5,7};
		if(d == 2) return new int[]{1,2,3,5,6};
		if(d == 3) return new int[]{1,2,3,5,7};
		if(d == 4) return new int[]{2,4,5,7};
		if(d == 5) return new int[]{1,2,3,4,7};
		if(d == 6) return new int[]{1,2,3,4,6,7};
		if(d == 7) return new int[]{1,4,5,7};
		if(d == 8) return new int[]{1,2,3,4,5,6,7};
		if(d == 9) return new int[]{1,2,3,4,5,7};
		return new int[]{};	
		
	}
	public static int sumd(int k)
	{
		int s = 0;
		while(k > 0)
		{
			s+=k%10;
			k/=10;
		}
		return s;
	}
	public static boolean isPrime(int n)
	{
		if(n%2 == 0) return false;
		for(int i=3; i<=Math.sqrt(n); i+=2)
		{
			if(n%i==0) return false;
		}
		return true;
	}
}
