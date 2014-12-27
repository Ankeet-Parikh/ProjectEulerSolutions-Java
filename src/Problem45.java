
import java.util.ArrayList;

public class Problem45 {

	
	public static void main(String[] args) {
		
		long next =0;
		for(long i =144; ;i++ )
		{	
			long nextHex = i*(2*i-1); //all triangle numbers are hex, so we don't need to check for them
			if(isPentagonal(nextHex))
			{
				next = nextHex;
				break;
			}
		}
		System.out.println((long)next);
	}
	
	public static boolean isPentagonal(double num)
	{
		return ((1.0 + Math.pow(1*1-4*(-num*2)*3,0.5))/6) %1==0;
		
		
	}
}
