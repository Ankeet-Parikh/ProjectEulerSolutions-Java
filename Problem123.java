package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Problem123 {

	
	public static void main(String[] args) {
		double range = Math.pow(10, 10);
		
		int[] list = Sieve((int)Math.round(Math.sqrt(range*100)));
		
		long ans =0;
		for(int i =0; i< list.length; i++)
		{
			if(list[i]*list[i] < range)
				continue;
			
			if(((long)Math.pow(list[i]-1,i)+(long)Math.pow(list[i]+1, i))%(list[i]*list[i]) > range)
				{
					ans = i;
					break;
				}
			
		}
		System.out.println(ans);

	}
	
	public static int[] Sieve(int n) //returns only primes from 2<=i<=n
	{
		boolean[] primality = new boolean[n+1];
		primality[0] = false; primality[1] =false;
		for(int i =2; i< primality.length; i++)
		{
			primality[i] = true;
		}
		for(int i =2; i*i<=n  ; i++)
		{
			for(int j =i; i*j <= n ;j++)
			{
				
				primality[i*j]=false;
			}
		}
		int count =0;
		for(int i = 0; i< primality.length; i++)
		{
			if(primality[i]) count++;
		}
		int[] primes = new int[count];
		for(int i =0, j=0; i< primality.length; i++)
		{
			if(primality[i])
			{
				primes[j] = i;
				j++;
			}
		}
		return primes;
		
		
	}

}
