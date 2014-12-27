package problems_200_209;

public class Problem206 {

	
	public static void main(String[] args) {
		long lowerBound = (long)Math.floor(Math.sqrt(1020304050607080900.0));
		long upperBound = (long)Math.ceil(Math.sqrt(1929394959697989990.0));
		
		long count;
		for(count = lowerBound; count <= upperBound; count+=10)
		{
			if(hasProperty(count*count)) break;
		}
		System.out.println(count +"     "+count*count );
		

	}
	public static boolean hasProperty(long num) // num is of form 1_2_3_4_5_6_7_8_9_0
	{
		if(String.valueOf(num).length() != 19) return false;
		long counter =10;
		while(num != 0)
		{
			if(num%10 != counter%10)
				return false;
			num/=100;
			counter--;
		}
		return true;
	}

}
