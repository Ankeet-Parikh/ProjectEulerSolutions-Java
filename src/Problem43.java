

import java.math.BigInteger;
import java.util.Arrays;

public class Problem43 {

	
	public static void main(String[] args) {
		BigInteger sum = new BigInteger("0");
		int[] primes = {2,3,5,7,11,13,17};
		int[] pandigital = {1,0,2,3,4,5,6,7,8,9};
		while(pandigital.length > 0)
		{
	
				boolean hasProperty = true;
				String num = "";
				for(int i =0 ; i< pandigital.length; i++) num+=String.valueOf(pandigital[i]);
				
				for(int j =1; j<num.length()-2;j++ )
				{
					
					if(Integer.parseInt(num.substring(j,j+3))%primes[j-1]!=0)
					{
						
						hasProperty = false;
						break;
					}
					
				}
				if(hasProperty)
				{
					sum =sum.add(new BigInteger(num));
					
				}
			pandigital = nextPerm(pandigital);
			
		}
		System.out.println(sum);
	}
	
	public static int[] nextPerm(int [] arrange){
		int k =-1;
		for(int x = arrange.length-2; x>= 0; x-- )//step 1
		{
			if(arrange[x] < arrange[x+1])
			{
				k=x;
				break;
			}
		}
		if(k == -1) return new int[0];
		int l =-1;
		for(int x =arrange.length-1; x > k; x--)//step 2
		{
			if(arrange[k] < arrange[x])
			{
				l=x;
				break;
			}
		}
		
			int temp = arrange[k]; //step 3
			arrange[k] = arrange[l];
			arrange[l] =temp;
			
			for(int c = k+1, j = arrange.length-1; c<j; c++, j--)
			{
				int temp2 = arrange[c];
				arrange[c] = arrange[j];
				arrange[j] =temp2;
			}
			return arrange;
	}

}
