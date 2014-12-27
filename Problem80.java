package problems_80_89;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem80 {

	
	public static void main(String[] args) {
		int sum =0;
		for(int i =1; i<= 100; i++)
		{
			sum+=rootDigitSum(i,100);
		}
		System.out.println(sum);
	}
	
	public static int rootDigitSum(int num, int range)
	{
		if(Math.pow(num,0.5)%1.0==0.0) return 0;
		
		BigDecimal root = new BigDecimal(String.valueOf(num));
		BigDecimal n = new BigDecimal(String.valueOf(num));
		for(int i =1; i < 50; i++)
		{
			BigDecimal half = new BigDecimal("0.5");
			int precision =250;
			root = root.add(n.divide(root,precision,RoundingMode.HALF_UP));
			root = half.multiply(root);
			
			
		}
		//System.out.println(root);
		int sum =0;
		String integerRootValue = root.toPlainString().split("\\.")[0];
		String decimalRootValue = root.toPlainString().split("\\.")[1];
		for(int i =0 ;i < range; i++)
		{
			sum+= Integer.parseInt((integerRootValue+decimalRootValue).substring(i,i+1));
		}
		return sum;
		
	}

}
