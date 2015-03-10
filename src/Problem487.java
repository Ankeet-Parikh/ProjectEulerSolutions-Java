import java.util.ArrayList;


public class Problem487 {
	public static void main(String[] args)
	{
		System.out.println(S(4,100));
		
	}
	public static long S(long k, long n)
	{
		long a =0;
		for(int i = 1; i<=n; i++)
		{
			a+=  (n-i+1) * (long)Math.pow(i, k) ;
		}
		return a;
	}
	public static ArrayList<Long> primesBetween(long l, long u)//lists all primes from l to u
	{
		ArrayList<Long> p = new ArrayList<Long>(0);
		//trial division
		for(long i = l; i<=u; i++)
		{
			if(i ==2) 
			{
				p.add(i);
				continue;
			}
			if(i%2==0 || i ==1 || i ==0) continue;
			else
			{
				boolean prime = true;
				for(int j = 3; j<=Math.sqrt(i); j+=2)
				{
					if(i%j == 0)
					{
						prime = false;
						break;
					}
				}
				if(prime) p.add(i);
			}
		}
		return p;
	}
}
