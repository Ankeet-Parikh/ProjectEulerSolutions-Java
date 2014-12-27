package problems_30_39;

import java.util.Arrays;

public class Problem38 {

	public static void main(String[] args) {
		
		long largest =0;
		for(int i =1;i<=9999;i++)
		{
			if(i==1000)i=5000;
			String s = "";
			int c =1;
			while(s.length() <9)
			{
				s+=""+(i*c);
				c++;
			}
			
			long p = Long.parseLong(s);
			if(isPandigital(s) && p >largest)
			{
				largest=p;
			}
		}
		System.out.println(largest);

	}
	public static boolean isPandigital(String s)
	{
		if(s.length() !=9) return false;
		char[] l = s.toCharArray();
		Arrays.sort(l);
		for(int i =0; i< l.length; i++)
		{
			if(l[i] != i+'1')
				return false;
		}
		return true;
	}
}
