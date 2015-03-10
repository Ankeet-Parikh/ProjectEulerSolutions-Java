import java.util.*;

public class Problem346 {
	public static void main(String[] args)
	{
		
		long s = System.currentTimeMillis();
		long sum =1;
		long range =(long)1e12;
		HashMap<Long, Integer> h = new HashMap<Long, Integer>(0);
		
		for(long p=2;p <= Math.log(range)/Math.log(2);p++) // highest p such that 2^p <= range
		{
			for(long i =2; i <= Math.pow(range, 1.0/p); i++) //highest i such that i^p <= range
			{

				long k=0;
				for(long j = 0; j<=p; j++)
					k+=(long)Math.pow(i,j);
				if(k >= range)break;
				if(!h.containsKey(k))
				{
					sum+=k;
					h.put(k, 0);
				}
			}
		}
		System.out.println(sum);
		long e =System.currentTimeMillis();
		System.out.println((e-s)/1000.0 +" seconds");
	}
	
	
}
