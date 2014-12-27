package problems_120_129;

public class Problem124 {
	public static void main(String[] args)
	{
		long[] r = radNValues(100000);
		long[] n = new long[r.length];
		for(int i =0; i<n.length; i++)
		{
			n[i] =i;
		}
		for(int i =0; i<r.length; i++)
		{
			for(int j =0; j<r.length-1; j++)
			{
				if(r[j] > r[j+1])
				{
					long temp = r[j];
					r[j] =r[j+1];
					r[j+1] =temp;
					
					temp = n[j];
					n[j] =n[j+1];
					n[j+1] =temp;
				}
				
			
			}
		}
		/*
		for(int i =0; i<r.length; i++)
		{
			System.out.println(n[i] +"  " +r[i]);
		}*/
		System.out.println(n[10000]);
	}
	public static void PrintArray(long[] arr)
	{
		for(int i =0; i< arr.length; i++)
		{
			System.out.print(arr[i] +" ");
		}
		System.out.println("");
	}
	public static long[] radNValues(int n)
	{
		boolean[] primes = new boolean[n+1];
		long[] rValues = new long[n+1];
		for(int i =0; i<rValues.length;i++)
		{
			rValues[i] =1;
			primes[i] =true;
		}
		rValues[0]=0;
		//Sieve of Eratosthenes
		
		for(int i =2; i<primes.length; i++)
		{
			if(primes[i]==true)
			{
				
				for(int j =i+i; j<primes.length; j+=i)
				{
					primes[j] = false;
				}
			}
		}
		//Determine the rad(n) values
		for(int i=2; i<primes.length; i++)
		{
			if(!primes[i])
				continue;
			else
			{
				for(int j =i; j<rValues.length; j+=i)
				{
					rValues[j]*=i;
				}
			}
		}
		return rValues;
		
	}
}
