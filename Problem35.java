package problems_30_39;

public class Problem35 {

	
	public static void main(String[] args) {

		int counter =0;
		for(int i =1; i< 1000000; i++)
		{
			if(isCircularPrime(i))
			{
				
				counter++;
			}
		}
		System.out.println(counter);
		

	}
	public static boolean isCircularPrime(int num)
	{
		if(!isPrime(num)) return false;
		int iterations = String.valueOf(num).length();
		for(int i =0; i< iterations; i++)
		{
			num = (num%10)*(int)Math.pow(10,iterations-1) +num/10;
			if(!isPrime(num)) return false;
		}
		return true;
	}
	public static boolean isPrime(int num)
	{
		if(num == 1) return false;
		if(num ==2) return true;
		for(int i =2; i<= Math.pow(num, 0.5); i++)
		{
			if(num%i ==0) return false;
		}
		return true;
	}

}
