package problems_90_99;

public class Problem92 {

	
	public static void main(String[] args) {
		int total =0;
		for(int i =1; i< 10000000; i++)
		{
			int current =i;
			for(;;)
			{
				if(current == 89)
					total++;
				if(current == 1 || current ==89)
					break;
				current = nextVal(current);
			}
			
		}
		System.out.println(total);
	}
	public static int nextVal(int num)
	{
		int sum =0;
		while(num != 0)
		{
			int x = num%10;
			sum+= x*x;
			num/=10;
		}
		return sum;
	}

}
