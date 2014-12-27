package problems_20_29;

public class Problem21 {

	
	public static void main(String[] args) {
		int sum =0;
		for(int i =1; i<= 10000; i++)
		{
			int amic = sumDivisors(i);
			if(i == sumDivisors(amic) && i!=amic) 
				sum+=i;
		}
		System.out.println(sum);

	}
	public static int sumDivisors(int num)
	{
		int sum =0;
		for(int i =1; i<= num/2; i++)
		{
			if(num%i ==0)
				sum+=i;
		}
		return sum;
	}

}
