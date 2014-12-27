package problems_60_69;

public class Problem63 {
	public static void main(String[] args)
	{
		int total =0;
		for(double exp =1;;exp++)
		{
			int lower=(int)Math.ceil(Math.pow(10, (exp-1.0)/exp));
			if(lower == 10) break;
			int upper = 9;//9^exp is the exponentiation with the power exp and length exp.
			
			total+=upper-lower+1; //10^n is one more than the upper bound
			
			
		}
		System.out.println(total);
	}

}
