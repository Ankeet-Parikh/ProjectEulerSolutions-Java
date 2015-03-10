import java.util.ArrayList;
import java.util.Arrays;


public class Problem77 {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> primes = new ArrayList<Integer>(0);
		int ub = 100; //estimate an upper bound
		//Do a prime Sieve
		boolean[] p =new boolean[ub+1];
		for(int i=0; i<p.length; i++) p[i] =true;
		p[0] = false;
		p[1] = false;
		for(int i=2; i<p.length; i++)
		{
			if(p[i]) primes.add(i);
			for(int j = 2*i; j<p.length; j+=i)
			{
				p[j] = false;
			}
		}
		
		//generate a list, which will contain the number of ways i can be written as a sum of primes
		int[] psum = new int[ub+1];
		for(int i=0; i<primes.size(); i++)
		{
			int currp = primes.get(i);
			psum[currp]++;
			for(int j=currp+1; j<psum.length; j++)
			{
				psum[j]+= psum[j-currp];
			}
		}
		//subtract one from each of the primes
		for(int i=0; i<primes.size(); i++) psum[primes.get(i)]--;
		for(int i=0; i<psum.length; i++)
		{
			if(psum[i] > 5000)
			{
				System.out.println(i);
				break;
			}
		}
	}
	
	
}
