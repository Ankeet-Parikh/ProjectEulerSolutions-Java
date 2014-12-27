

public class Problem30 {

	
	public static void main(String[] args) {
		int power =5;
		int sum =0;
		for(int i =2; i< power*Math.pow(9, power);i++)
		{
			if(digitPowerSum(i,power))
				sum+=i;
		}
		System.out.println(sum);
	}
	public static boolean digitPowerSum(int num, int exponent)
	{
		int sum = 0;
		int x= num;
		while(num!=0)
		{
			sum+=Math.pow((num%10), exponent);
			num/=10;
		}
		return sum == x;
	}

}
