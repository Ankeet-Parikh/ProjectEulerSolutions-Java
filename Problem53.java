package problems_50_59;

import java.math.BigInteger;

public class Problem53 {

	
	public static void main(String[] args) {
		int total =0;
		BigInteger million = new BigInteger("1000000");
		BigInteger[] factorials = new BigInteger[101];
		for(int i =0;i<factorials.length;i++)
		{
			factorials[i] = i ==0?new BigInteger("1"):factorials[i-1].multiply(new BigInteger(""+i));
			for(int j =0; j<=i; j++)
			{
				BigInteger ncr = factorials[i].divide(factorials[j].multiply(factorials[i-j]));
				if(ncr.compareTo(million) ==1)
					total++;
			}
			
		}
		System.out.println(total);
	}
	
	
	

}
