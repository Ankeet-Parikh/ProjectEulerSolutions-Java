import java.util.ArrayList;
import java.util.HashMap;


public class Problem347 {
	static int max = 10000000;
	public static void main(String[] args)
	{
		//max =1000;
		System.out.println(S(max));
	}
	public static long S(int n)
	{
		ArrayList<Integer> pr = new ArrayList<Integer>(0);
		boolean[] p = new boolean[n/2+20];
		for(int i=0; i<p.length; i++)p[i] =true;
		for(int i =2; i<p.length; i++)
		{
			if(p[i])
			{
				pr.add(i);
				for(int j=2*i; j<p.length; j+=i) p[j] =false; 
			}
		}
		
		long sum =0;
		for(int i=0; i<pr.size(); i++)
		{
			int a = pr.get(i);
			for(int j=i+1; j<pr.size(); j++)
			{
				int b = pr.get(j);
				if((long)a*b > n) break;
				int m = M(a,b,n);
				sum+=m;
			}
		}

		return sum;
	}
	public static int M(int p, int q, int n)
	{
		int max =0;
		int mmult = p*q;
		if(mmult > n) return 0;
		max = mmult;
		int maxpowp = (int)(Math.log(n)/Math.log(p));
		for(int i=1; i <= maxpowp; i++)
		{
			int rem = n / (int) Math.pow(p, i);
			int maxpowq = (int)(Math.log(rem)/Math.log(q));
			if(maxpowq <1) break;
			int val = (int)(Math.pow(p, i) * Math.pow(q, maxpowq));
			if(val > max) max = val;
		}
		return max;
	}
}
