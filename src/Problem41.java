

import java.util.ArrayList;

public class Problem41 {

	
	public static void main(String[] args) {
		int [] pandigits = {9,8,7,6,5,4,3,2,1};
		long largestPandigitalPrime = -1;
		for(int i =0, a =0, b =0; ; i++)
		{
			String num ="";
			for(int j =0; j< pandigits.length; j++)
			{
				num+=String.valueOf(pandigits[j]);
			}
			if(isPrime(Long.parseLong(num)))
			{
					largestPandigitalPrime = Long.parseLong(num);
					break;
			}
			int[] before = new int[pandigits.length];
			for(int j =0; j< before.length; j++) before[j] = pandigits[j];
			nextPermDescending(pandigits);
			
			if(isTheSame(before, pandigits))
			{
				pandigits=  new int[pandigits.length-1];
				for(int j = 0; j < pandigits.length; j++)
				{
					pandigits[j] = pandigits.length-j;
				}
			}
		}
		System.out.println(largestPandigitalPrime);
	}
	public static void nextPermDescending(int[] array)
	{
		//for(int i =0; i< array.length; i++) System.out.print(array[i]); System.out.println();
		int k=-1;
		int l =-1;
		
		for(int i = array.length-2;i>=0;i--)
		{
			if(array[i] > array[i+1])
			{
				k =i;
				break;
			}
		}
		if(k == -1) 
		{
			return; 
		}	
		for(int i = array.length-1; i >=0; i--)
		{
			if(array[k] > array[i])
			{
				l=i;
				break;
			}
		}
		if(l == -1)
		{
			return; 
		}
		
			int temp = array[k];
			array[k] = array[l];
			array[l] =temp;
		
			for(int c = k+1, j = array.length-1; c<j; c++, j--)
			{
				int temp2 = array[c];
				array[c] = array[j];
				array[j] =temp2;
			}

		
	}
	public static boolean isTheSame(int[] a, int[] b)
	{
		for(int i = 0; i< a.length ;i++)
		{
			if(a[i] !=  b[i]) return false;
		}
		return true;
	}
	public static boolean isPrime(long num)
	{
		if(num ==0 || num ==1) return false;
		for(int i =2 ; i< Math.pow(num,0.5); i++)
		{
			if(num%i==0) return false;
		}
		return true;
	}
}
