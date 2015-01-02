
import java.math.BigInteger;


public class Problem65{
	public static void main(String[] args)
	{

		System.out.println(SumNthENum(100));
	}
	public static long SumNthENum(long n)
	{
		
		BigInteger num = new BigInteger("1"), denom =new BigInteger("1");
		if(n ==1) num = new BigInteger("2");
		if(n%3==0) denom = new BigInteger(String.valueOf(2*n/3));
		
		while(--n > 1)
		{
			BigInteger addTo = new BigInteger("1");
			if(n%3==0) addTo = new BigInteger(String.valueOf(2*n/3));
			
			BigInteger temp = new BigInteger(num.toString());
			num = denom;
			denom = temp.add(addTo.multiply(denom));
		}
		num = num.add(denom.multiply(new BigInteger("2")));

		String s = num.toString();
		long sum=0;
		for(int i =0; i<s.length(); i++)
		{
			sum +=Integer.parseInt(s.substring(i,i+1));
		}
		return sum;
	}
}
