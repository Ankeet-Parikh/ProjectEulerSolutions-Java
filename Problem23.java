package problems_20_29;

import java.util.ArrayList;

public class Problem23 {

	
	public static void main(String[] args) {
		int sum =0;
		ArrayList<Integer> abundants = new ArrayList<Integer>();
		for(int i= 1; i<  28123; i++)
		{
			if(sumDivisors(i) > i)
				abundants.add(i);
		}
		
		for(int i =1; i< 28123; i++)
		{
			if(!canBeWrittenAs(i, abundants))
				sum+=i;
				
		}
		System.out.println(sum);

	}
	public static boolean canBeWrittenAs(int num, ArrayList arr) //can be written as the sum of two abundant numbers
	{
		for(int i =0; i< arr.size(); i++)
		{
			for(int j =0; j< arr.size(); j++)
			{
				int a =(Integer) arr.get(i);
				int b = (Integer)arr.get(j);
				if(a > num && b > num)
					return false;
				if(a+b == num)
					return true;
			}
		}
		return false;
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
