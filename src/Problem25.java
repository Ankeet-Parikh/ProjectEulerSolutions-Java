
import java.math.BigInteger;

public class Problem25 {

	public static void main(String[] args) {
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		BigInteger c = new BigInteger("2");
		int i =3;
		for( ; c.toString().length()<1000; i++)
		{
			a = b;
			b = c;
			c = a.add(b);
			
		}
	
		System.out.println(i);

	}

}
