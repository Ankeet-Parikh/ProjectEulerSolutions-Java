package problems_90_99;

import java.math.BigInteger;



public class Problem97 {

	
	public static void main(String[] args) {
	
		long c =2;
		long mod = 10000000000L;
		for(int i =1; i < 7830457; i++)
		{
			c = c*2;
			c%= mod;
		}
		c=(c*28433+1)%mod;
		
		System.out.println(c);
		
		
		  
	}

}
