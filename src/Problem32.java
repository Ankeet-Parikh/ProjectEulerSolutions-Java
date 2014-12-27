
import java.util.Arrays;


public class Problem32 {

	
	public static void main(String[] args) {
		long sum =0;
		for(int i=1000;i<=9999 ;i++)
		{
			for(int j=2; j<=Math.sqrt(i); j++)
			{
				if(i%j==0 && isPandigital(j+""+(i/j)+""+i))
				{
					sum+=i;
					
					break;
				}
				  
			}
			
		}
		System.out.println(sum);

	}
	public static boolean isPandigital(String s)
	{
		if(s.length() != 9) return false;
		char[] l = s.toCharArray();
		Arrays.sort(l);
		for(int i =0; i<l.length; i++)
		{
			if(l[i] != '1'+i) return false;
		}
		return true;
	}

}
