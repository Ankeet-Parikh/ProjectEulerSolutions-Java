import java.util.*;


public class Problem297 {
	/*
	 * Fn       Sum of z(i) from 0<i<Fn where z(n) is the number of terms in the zeckendorf representation
	 * 1		1
	 * 2		2
	 * 3		3
	 * 5		3 + 1*1 + 1 = 5
	 * 8		5 + 2*1 + 2+1 = 10
	 * 13		10 + 4*1 + 5 + 1= 20
	 * 21 		20 + 7*1 + 10 + 1 = 38
	 * 34		38 + 12*1 + 20+ 1 = 71
	 */
	public static void main(String[] args)
	{
		HashMap<Long, Long> h = new HashMap<Long, Long>();
		long a = 1, b=2, c =3;
		long range = (long)1e17;
		h.put(a, a);
		h.put(b, b);
		h.put(c, c);
		a = b; b=c; c = a+b;
		
		while(c <= range)
		{
			long s1 =h.get(b);
			long s2 =a-1;
			long s3 =h.get(a);
			if(c == 5) s3 =0;
			if(c == 8) s3 = 2;
			long s4 =1;
			h.put(c, s1+s2+s3+s4);
			a = b;
			b = c;
			if(a+b>range) break;
			c = a+b;
		}
		long total = h.get(c); //add one because h.get(c) only gets all the z(i) values up untill c-1, z(c) is one, so add it
		//System.out.println("Z(n) to "+c+ ": " +total);
		long remaining = range - c -1; // only want up untill range -1
		//System.out.println(remaining);
		long u =1;
		while(remaining > 0)
		{
			//get highest fibonacci number less than or equal to remaining
			long min = Long.MAX_VALUE, highest =0;
			for(long k : h.keySet())
			{
				long diff = remaining - k;
				if(diff >=0 && diff < min)
				{
					min = diff;
					highest = k;
				}
			}
			
			total += highest*u + h.get(highest) +1;
			u++;
			remaining -= highest;
		}
		System.out.println(total);
	}
	
	
}
