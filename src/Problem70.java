
import java.util.Arrays;


public class Problem70 {

	
	public static void main(String[] args) {
		
		//find highest totient(n) such that totient(n) is permutation of n
		int range = 10000000;
		int[] totients = new int[range+1];
		for(int i=0; i<totients.length; i++)totients[i]=i;
		
		long n=0;
		double mintotient=2;
		
		for(int i =2; i<totients.length; i++)
		{
			
			if(totients[i] ==i)
			{
				for(int j=i;j<totients.length;j+=i)
				{
					totients[j] = totients[j]/i*(i-1);
				}
			}
			if(isPermutation(i,totients[i]) && (double)i/totients[i]<mintotient)
			{
			
				mintotient=(double)i/totients[i];
				n=i;
			}
			
		}
		
		System.out.println((long)n);
	}
	public static boolean isPermutation(long a, long b) 
	{
		char[] v1 = (a+"").toCharArray();
		char[] v2 = (b+"").toCharArray();
		if(v1.length != v2.length) return false;
		Arrays.sort(v1);
		Arrays.sort(v2);
		for(int i=0; i<v1.length; i++)
		{
			if(v1[i] != v2[i]) return false;
		}
		return true;
	}
	
	
}
