import java.math.BigInteger;
public class Problem216 {
	public static void main(String[] args)
	{
		double s = System.currentTimeMillis();
		int[] p = {2,3,5,7,11,13,17, 19,23, 29, 31};
		int a = 0;
		for(int i = 2; i <=50000000; i++)
		{
			boolean pr = true;
			long n = 2*(long)i * i -1;
			/*
			for(int j =0; j<p.length; j++)
			{
				if(n%p[j] == 0 && n != p[j])
				{
					pr = false;
					break;
				}
			}*/
			if(pr && new BigInteger("" + n).isProbablePrime(4)) a++;
		}
		System.out.println(a);
		double e = System.currentTimeMillis();
		System.out.println((e-s)/1000 + " seconds");
	}
}
