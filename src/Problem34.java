

public class Problem34 {

	
	public static void main(String[] args) {
		int sum =0;
		//boundary condition is 9999999, or Math.pow(10,8)-1 because the sum of the factorials of 
		//the digits in 9999999
		//is 2540160. Since 2540160 is less than 9999999, no number higher than 9999999 can be written as
		//the sum of the factorials of its digits
		double s = System.currentTimeMillis();
		for(int i =3; i<Math.pow(10, 8)-1; i++) 
		{
			if(sumFactorials(i) ==i)
				sum+=i;
		}
		System.out.println(sum);
		double e = System.currentTimeMillis();
		System.out.println((e-s)/1000 +" seconds");
		
	}
	public static int sumFactorials(int num)
	{
		int sum =0;
		while(num !=0)
		{
			sum+= Factorial(num%10);
			num/=10;
		}
		return sum ;
	}
	public static int Factorial(int num)
	{
		
		if(num == 1 || num ==0) return 1;
		else
			return num *Factorial(num-1);
	}

}
