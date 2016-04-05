
import java.util.*;
public class Problem425{
	static int ct = 0;
	static int r = 10000000;
	static boolean[] pr = new boolean[r+1]; // i is prime iff pr[i] is true
	static boolean[] tr = new boolean[r+1]; // i is 2s relative iff tr[i] is true and pr[i] is true
	static int[] ma = new int[r+1]; //stores the maximum value in the chain sed to get to that number
									//ma[t] = t for a 2s relative. ma[t] > t for other primes
	public static void main(String[] args)
	{
		for(int i=2; i<pr.length; i++)
		{
				pr[i] = true;
				ma[i] = Integer.MAX_VALUE;
		}
		for(int i=2; i<pr.length; i++)
		{
			if(pr[i])
				for(int j = 2*i; j<pr.length; j+=i)
				{
					pr[j] = false;
				}
		}
		System.out.println("Done Sieving");
		int[][] ti = new int[r+1][];
		for(int i=2; i<pr.length; i++)
		{
			if(pr[i]) 
			{
				ArrayList<Integer> can = turnInto(i);
				ti[i] = new int[can.size()];
				for(int j =0; j<can.size(); j++)
					ti[i][j] = can.get(j);
				
			}
		}
		System.out.println("Done figuring out transformations.");
		System.out.println(ct);
	}
	
	public static ArrayList<Integer> turnInto(int n)
	{
		ArrayList<Integer> t = new ArrayList<Integer>();
		if(n > 10)
		{
			int a = in((""+n).substring(1));
			if(pr[a]) t.add(a);
		}
		if(10*n <=r)
		for(int i=1; i<=9; i++) //add to front
		{
			int a = in(i+""+n);
			if(pr[a]) t.add(a);
		}
		//replace
		char[] c = ("" + n).toCharArray();
		for(int l = 0; l<c.length; l++)
		{
			for(int i = 0; i<=9; i++)
			{
				if(l ==0 && i ==0) continue;
				char p = c[l];
				c[l] = (char)('0'+i);
				int a = in(new String(c));
				if(pr[a]) t.add(a);
				c[l] = p;
			}
		}
		Collections.sort(t);
		return t;
	}
	
	public static int in(String s)
	{
		return Integer.parseInt(s);
	}
}