/*
 * First, find out how many divisors dT(n) has:
 * T(n) = n*(n+1)/2
 */
public class Problem378 {
	static short[] d = new short[0];
	public static void main(String[] args)
	{
		int r = 60000000;
		//r=60000;
		//d[i] will store the number of divisors of i
		d = new short[r+2];
		for(int i=1; i<d.length; i++) d[i] = 1;
		for(int i=2; i<d.length; i++)
		{
			for(int j = i;j < d.length;j+=i)
			{
				d[j]++;
			}
		}
		
		//dt[i] will store the number of divisors of T(i) where T(i) is the ith triangle number
		int dt[] = new int[r+1];
		for(int i=2; i<d.length-1; i++)
		{
			if(i%2 == 0) dt[i] = d[i/2] * d[i+1];
			if(i%2 == 1) dt[i] = d[i] * d[(i+1)/2];
		}
		System.out.println(dt[100000]);
		
	}
	
}
