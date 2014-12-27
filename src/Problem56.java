
import java.math.BigInteger;

public class Problem56 {

	
	public static void main(String[] args) {
		int maxSum = 0;
		for(int a =1; a < 100; a++)
		{
			for(int b =1; b< 100; b++)
			{
				int s = sumDigits(new BigInteger(String.valueOf(a)).pow(b));
				if(s>maxSum) maxSum =s;
					
			}
		}
		System.out.println(maxSum);

	}
	public static int sumDigits(BigInteger b)
	{
		int sum =0;
		String k = b.toString();
		for(int i =0; i< k.length(); i++)
		{
			sum+=Integer.parseInt(k.substring(i,i+1));
		}
		return sum;
	}
	

}
