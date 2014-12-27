package problems_30_39;

public class Problem37 {

	
	public static void main(String[] args) {
		int sum =0;
		
		
		for(int i= 10, counter =0; counter < 11; i++ )
		{
			if(isTruncatablePrime(i)) 
			{
				
				sum+=i;
				counter++;
				
			}
		}
		System.out.println(sum);

	}
	public static boolean isTruncatablePrime(int num)
	{
		
				//ex: num= 3797
		int right =num%10, // 7, 97, 797, 3797  add the elements to the front
				left =num;// 3797, 379, 37, 3 remove from the end
		
		while(left !=0)
		{
			
			if(!isPrime(right) || !isPrime(left))
				return false;
			left/=10;
			num/=10;
			right = Integer.parseInt(String.valueOf(num%10) + String.valueOf(right));
			
		}
		return true;
		
	}
	public static boolean isPrime(int num)
	{
		if(num == 1 || num ==0) return false;
		for(int i =2; i<= Math.pow(num, 0.5); i++)
		{
			if(num%i==0)return false;
		}
		return true;
	}

}
