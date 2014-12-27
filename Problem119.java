package problems_110_119;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class Problem119 {
	public static void main(String[] args)
	{
		int n = 30;
		ArrayList<Double> values = new ArrayList<Double>(0);
		for(double b =1; b<500; b++ )
		{
			for(double exp = 1; exp<90; exp++)
			{
				double p = Math.pow(b,exp);
				if(p<10) continue;
				if(sumDigits(p) == b)
				{
					values.add(p);
				}
			}
		}
		Collections.sort(values);
		
		//we must remove the duplicates
		for(int i =0; i<values.size()-1;)
		{
			
			if(values.get(i) == values.get(i+1))
			{
				values.remove(i);
			}
			else 
			{
				i++;
			}
		}
		System.out.println((long)(double)values.get(n-1));
		
	}
	
	public static int sumDigits(double n)
	{
		int count=0;
		while(n!=0)
		{
			count+=n%10;
			n = Math.floor(n/10);
		}
		return count;
	}

}
