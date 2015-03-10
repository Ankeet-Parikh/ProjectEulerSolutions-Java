import java.util.ArrayList;


public class Problem95 {
	public static void main(String[] args)
	{
		int[] div = new int[(int)1e6+1];
		for(int i=1; i<div.length; i++)
			for(int j = 2*i; j<div.length; j+=i)
				div[j] +=i;
		
		int minval =0, minc =0;
		for(int i=0; i<div.length; i++)
		{
			int c = AmChainLen(div, i);
			//System.out.println(i + ":"  + c);
			if(c > minc)
			{
				minc = c;
				minval =i;
			}
		}
		System.out.println(minval);
		
	}
	
	public static int AmChainLen(int[] d, int m) //length of chain, if not in chain then -1
	{
		/*
		 * Most numbers end up going down to zero. For example 100
		 * 100 -> 117 -> 65 -> 19 -> 1 -> 0
		 * This is not an amicable chain so we return -1;
		 * Some numbers have interesting properties:
		 * 562 -> 284 -> 220 -> 284 -> 220 -> ...
		 * 25 -> 6 -> 6 -> 6 -> ...
		 * To account for these, we will create an ArrayList storing all the elements
		 * of the chain. If an element that is not the starting number were to come
		 * up twice, we would know that it does not create an amicable chain
		 */
		int s =m;
		int c =0;
		ArrayList<Long> ch = new ArrayList<Long>(0);
		while(s > 0 && s<d.length)
		{
			
			s = d[s];
			c++;
			if(s == m) return c;
			if(ch.contains((long)s)) break;
			ch.add((long)s);
		}
		return -1;
		
	}
}
