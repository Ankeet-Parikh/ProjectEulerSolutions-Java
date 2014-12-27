package problems_30_39;

public class Problem36 {

	
	public static void main(String[] args) {
		
		int sum =0;
		for(int i =1; i<1000000; i++ )
		{
			if(isPalindrome(String.valueOf(i)) && isPalindrome(toBinary(i)))
				sum+=i;
		}
		System.out.println(sum);
	
	}
	public static String toBinary(int n)
	{
		String res ="";
		while(n !=0)
		{
			
			res = n%2+res;
			n/=2;
		}
		return res;
	}
	public static boolean isPalindrome(String s)
	{
		String reverse = "";
		for(int i =s.length()-1; i>=0 ; i--)
		{
			reverse+=s.substring(i,i+1);
		}
		return s.equals(reverse);
	}

}
