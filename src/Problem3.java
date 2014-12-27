

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */
import java.util.ArrayList;
public class Problem3 {

	
	public static void main(String[] args) {
		double num = 600851475143.0 ;
		ArrayList<Integer> factors =  new ArrayList<Integer>();
		for(int i = 2; i<=num; i++ )
		{
			while(num%i ==0) 
			{
				num/=i;
				factors.add(i);
			}
		}
	
		System.out.println(factors.get(factors.size()-1));
		
	}

}
