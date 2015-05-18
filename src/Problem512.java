import java.math.BigInteger;


public class Problem512 {	
	public static void main(String[] args)
	{
		/*
		 * f(n) = Totient[n] when n is odd
		 * f(n) = 0 when n is even
		 */
		double s = System.currentTimeMillis();
		int size = (int)5e8;
		int[] f = new int[size+1];
		for(int i =0; i<f.length; i++) f[i] = i;
		long sum =1;
		for(int i = 2; i < f.length; i++)
		{
			if(f[i] == i)
			{
				for(int j = i; j<f.length; j+=i)
				{
					f[j] = f[j] / i * (i-1);
				}
			}
			if(i%2 == 1)
				sum+=f[i];
		}
		
		System.out.println(sum);
		System.out.println((System.currentTimeMillis() - s)/1000 + " seconds");
	}
	
	
}
