

import java.util.Arrays;

public class Problem52 {

	
	public static void main(String[] args) {
		for(int i =1;;i++ )
		{
			if(hasSameDigits(i, 2*i) 
			 && hasSameDigits(i, 3*i)
			 && hasSameDigits(i, 4*i)
			 && hasSameDigits(i, 5*i)
			 && hasSameDigits(i, 6*i)
			 )
			 {
				System.out.println(i);
				 //System.out.println(i +" " + 2*i+" " + 3*i+" " + 4*i+" " + 5*i+" " + 6*i);
				 break;
			 }
		}

	}
	public static boolean hasSameDigits(int num, int val)
	{
		char[] n1 = String.valueOf(num).toCharArray();
		char[] n2 = String.valueOf(val).toCharArray();
		if(n1.length != n2.length) return false;
		Arrays.sort(n1);
		Arrays.sort(n2);
		for(int i =0; i< n1.length; i++)
		{
			if(n1[i] != n2[i]) return false;
		}
		return true;
	}

}
