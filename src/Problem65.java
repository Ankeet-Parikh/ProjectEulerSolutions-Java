

public class Problem65 {

	
	public static void main(String[] args) {
		int[] terms = new int[129];
		for(int i =0, k=2; i< terms.length; i++)
		{
			if(i%3==1) 
			{
				terms[i] =k; k+=2;
			}
			else terms[i] =1;
		}
		int numerator =0, denominator =terms[8]+terms[9];
		for(int i =7; i>=0;i--)
		{
			numerator+=terms[i]*denominator;
			//System.out.println(numerator +"/" +denominator);
			int temp  =numerator;
			numerator =denominator;
			denominator =temp;
		}
		
		
		int sumDigits =0;
		while(numerator != 0)
		{
			sumDigits+=numerator%10;
			numerator/=10;
		}
		System.out.println(sumDigits);

	}

}
