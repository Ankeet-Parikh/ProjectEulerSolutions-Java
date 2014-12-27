
/*
 A palindromic number reads the same both ways. 
 The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {

	
	public static void main(String[] args) {
		int a =900, b=900, highest =0;
		while(b<=999)
		{
			if(isPalindrome(a*b) && a*b > highest) highest = a*b;
			a++;
			if(a == 999){ a= 900;b++;}
		}
		
		System.out.println(highest);
	}
	
	public static boolean isPalindrome(int num)
	{
		int reverse =0;
		int x =num;
		while(num != 0)
		{
			reverse= reverse*10 +num%10;
			num/=10;
		}
		return reverse == x;
	}

}
