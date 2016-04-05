
import java.util.Arrays;

public class Problem62 {
	public static void main(String[] args)
	{
		long smallest =0;
		int exp =1;
		int targetCubes =5;
		boolean done =false;
		
		while(!done)
		{
			long lower =(long)Math.ceil(Math.pow(Math.pow(10, exp),1.0/3.0));
			long upper =(long)Math.floor(Math.pow(Math.pow(10, exp+1), 1.0/3.0));
			
			for(long i = lower ;i <=upper;i++)
			{
				int count =0;
				
				for(long j = lower+1; j<=upper; j++ )
				{
					
					if(isPermutation(i*i*i,j*j*j))
					{
						count++;
						
					}
					if(count == targetCubes)
					{
						smallest = i*i*i;
						done =true;
						break;
					}
				}
				if(done) break;
				
			}
			exp++;
		}
		System.out.println(smallest);
		
	}
	
	public static boolean isPermutation(long x, long y)
	{
		char[] a =String.valueOf(x).toCharArray(); Arrays.sort(a);
		char[] b =String.valueOf(y).toCharArray(); Arrays.sort(b);
		return (new String(a)).equals(new String(b));
	}

}
