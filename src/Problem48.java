
import java.math.BigInteger;


public class Problem48 {

	public static void main(String[] args) {
		BigInteger b = new BigInteger("0");
		int range =1000;
		for(int i =1 ;i<= range; i++)
		{
			BigInteger c = new BigInteger(String.valueOf(i));
			b = b.add(c.pow(i));
			
		}
		//System.out.println(b);
		System.out.println(b.toString().substring(b.toString().length()-10,b.toString().length()));
	}

}
