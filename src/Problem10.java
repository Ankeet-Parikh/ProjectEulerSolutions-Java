

import java.util.ArrayList;
import java.util.Arrays;


/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
Answer: 142913828922
 */
public class Problem10 {

	
	public static void main(String[] args) {
		int range = 2000000;

		System.out.println(Sievesum(range));

	}
	
	/*
	 * Sieve of Euler
	 */
	public static long Sievesum(int range)
	{
		long sum =0;
		boolean notPrime = false; //indication that the value is not prime
		boolean [] nums = new boolean[range+1];
		
		//set them all to true
		for(int i =0; i< nums.length; i++)
		{
			nums[i]  =true;
		}
		
		//the actual sieving part 
		//the summing part is in the loop
		for(int i =2; i*i<=range  ; i++)
		{
			for(int j =i; i*j <= range ;j++)
			{
				
				nums[i*j]=notPrime;
			}
			
		}
		
		//sum all of it up
		for(int i =2; i< nums.length; i++) 
		{
			if(nums[i])
			{
				sum+=i;
				//System.out.print(i+ " ");
			}
		}
		
		return sum;
	}
	
}
