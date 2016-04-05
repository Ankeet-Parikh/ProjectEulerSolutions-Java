import java.math.BigInteger;
import java.util.Arrays;

public class Problem493 {
	public static void main(String[] args)
	{
		System.out.println(choose(70, 20));
	}
	
	public static long choose(int n, int k)
	{
		BigInteger f[] = new BigInteger[n+1];
		f[0] = BigInteger.ONE;
		for(int i=1; i<=n;i++)
			f[i] = new BigInteger("" + i).multiply(f[i-1]);
		return f[n].divide(f[k]).divide(f[n-k]).longValue();
	}
}
