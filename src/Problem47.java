
import java.util.ArrayList;

public class Problem47 {

	
	public static void main(String[] args) {
		
		long counter =0, first =0, i=1;
		while(counter < 4)
		{
			if(numFactors(i) == 4) 
				counter++;
			else 
				counter = 0;
			if(counter == 1)
				first =i;
			i++;
		}
		System.out.println(first);

	}
	public static long numFactors(double num)
	{
		long counter =0;
		for(int i = 2; i<=num; i++ )
		{
			if(num%i ==0) 
			{
				while(num%i==0)num/=i;
				counter++;
			}
		}
		return counter;
	}

}
