package problems_20_29;

public class Problem27 {

	
	public static void main(String[] args) {
		int numConsecPrimes =0, product =0;
		
		for(int a = -999; a < 1000; a++)
		{
			for(int b = -999; b< 1000; b++)
			{
				for(int n =0; ;n++)
				{
					
					if(!isPrime(function(a,b,n)))
					{
						
						if(n-1 > numConsecPrimes)
						{
							numConsecPrimes=n-1;
							product =a*b;
							//System.out.println("a: " +a +" b: " +b );
						}
						break;
					}
				}
			}
		}
		System.out.println(product );
		

	}
	
	public static int function(int a, int b, int n)
	{
		return n*n + a*n + b;
	}
	
	public static boolean isPrime(int num)
	{
		if(num ==1 ||num ==0) return false;
		for(int i =2; i< Math.pow(Math.abs(num), 0.5); i++)
		{
			if(num%i==0)
				return false;
		}
		return true;
	}

}
