import java.util.ArrayList;


public class Problem211 {
	public static void main(String [] args)
	{
		
		int r = (int)64e6;
		long[] d = new long[r];
		long sum=0;
		for(long i=1; i<d.length; i++)
		{
			for(long j=i;j<d.length;j+=i)
				d[(int) j]+=i*i;
			long n = d[(int) i];
			double rt = (long)Math.sqrt(n);
			if(rt*rt == n) sum+=i;
		}

		System.out.format("%d\n",sum);
		
	}

}

