import java.util.*;
public class Problem462 {
	public static void main(String[] args)
	{
		ArrayList<Long> ts = new ArrayList<Long>(0);
		long max = 1000000000000000000l;
		max = 6;
		long k = 1;
		while(k <= max && k > 0)
		{
			long c = k;
			while(c > 0 && c <= max)
			{
				ts.add(c);
				c*=3;
			}
			k*=2;
		}
		Collections.sort(ts);
		System.out.println(ts);
	}
}	
