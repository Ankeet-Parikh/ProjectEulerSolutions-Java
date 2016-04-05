/*
 * Dynamic programming problem
 * Property: No 3 consecutive digits have a sum greater than 9.
 * Suppose that abc is a 3-digit sequence where a+b+c <= 9. We want to find the number of integers
 * of length n that end in abc. Consider all the three digit sequences that end in .ab where . is any
 * integer and that . + a + b <=9. If we append c to any one of them, we get a number ending in abc.
 * So, for every string abc, we need to find all the previous strings .ab
 */
import java.util.HashMap;
import java.util.ArrayList;
public class Problem164 {
	public static void main(String[] args)
	{	
		
		System.out.println(count(20));
		
	}
	
	public static boolean prop(long n)
	{
		String s = ""+n;
		for(int i=0; i<s.length()-2; i++)
		{
			int a = (int)(s.charAt(i)-'0');
			int b = (int)(s.charAt(i+1)-'0');
			int c = (int)(s.charAt(i+2)-'0');
			if(a + b + c > 9) return false;
		}
		return true;
	}
	
	public static long count(int days)
	{
		
		long[][] ends = new long[1000][days+1];
		HashMap<Integer, ArrayList<Integer>> prev = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0; i<1000; i++)
		{
			if(!validseq(i)) continue;
			String c = get3(i);
			ArrayList<Integer> pi = new ArrayList<Integer>(0);
			//find all the previous members of c
			for(int k = 0; k<10; k++)
			{
				int val = Integer.parseInt("" + k + c.substring(0, 2));
				if(validseq(val)) pi.add(val);
			}
			prev.put(i, pi);
		}
		for(int i=0; i<1000; i++)
		{
			if(validseq(i) && i >= 100) ends[i][3] = 1;
		}
		for(int d = 2;d<=days;d++)
		{
			for(int i=0; i<1000; i++)
			{
				if(!validseq(i)) continue;
				for(int j=0; j<prev.get(i).size(); j++)
				{
					ends[i][d]+=ends[prev.get(i).get(j)][d-1];
				}
			}
		}
		long c = 0;
		for(int i = 0;i<1000;i++)
		{
			if(validseq(i)) c+=ends[i][days];
		}
		return c;
	}
	
	public static boolean validseq(int a) //if it is a valid 3 digit sequence
	{
		int s = 0;
		while(a > 0)
		{
			s+=a%10;
			a/=10;
		}
		return s <= 9;
	}
	
	public static String get3(int n)
	{
		//returns the integer in 3 digits ex: 1 -> "001" 50 -> "050" 984 -> "984"
		String c = "" + n;
		while(c.length() < 3) c = "0" + c;
		return c;
	}

}
