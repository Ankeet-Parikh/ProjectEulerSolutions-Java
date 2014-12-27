

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */

public class Problem7 {

	public static void main(String[] args) {
		
		int nth = 10001, counter =0, i =2, current =0;
		while(counter < nth)
		{
			if(isPrime(i))
			{
				counter++;
				current =i;
			}
			i = i!=2 ? i+2: i+1;
		}
		System.out.println(current);
	}
	
	
	public static boolean isPrime(int num)
	{
			
		
			for(int i = 2; i<= Math.pow(num, 0.5); i = i!=2? i+2 :i+1 )
			{
				if(num%i ==0) 
				return false;
			}
			
			return true;
	}

	

}
