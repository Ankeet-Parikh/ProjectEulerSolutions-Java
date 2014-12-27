
import java.util.ArrayList;


public class Problem74 {

	public static void main(String[] args) {
		
		int sixtyTermChains =0;
		for(int i =1; i< 1000000; i++)
		{
			if(lengthRepeating(i) == 60) 
			{
				sixtyTermChains++;
				
			}
				
		}
		System.out.println(sixtyTermChains);
		
	}
	public static int lengthRepeating(int num) //must be less than 60
	{
		ArrayList<Integer> chainvalues = new ArrayList<Integer>();
		chainvalues.add(num);
		for(int i = 1; i<=60; i++)
		{
			int next = (int)digitsFactorial(chainvalues.get(chainvalues.size()-1));
			if(wasRepeated(next, chainvalues))
				return chainvalues.size();
			chainvalues.add(next);
		}
		return 61;
	}
	public static boolean wasRepeated(int num, ArrayList<Integer> list)
	{
		for(int i =0 ; i< list.size(); i++)
			if(num == list.get(i)) return true;
		return false;
	}
	public static long digitsFactorial(long num)
	{
		String s = String.valueOf(num);
		long sum =0;
		for(int i =0; i< s.length(); i++)
		{
			long factorial = Factorial(Long.parseLong(s.substring(i,i+1)));
			sum+=factorial;
		}
		return sum;
	}
	public static long Factorial(long n)
	{
		if(n == 1 || n ==0) return 1;
		return n*Factorial(n-1);
	}

}
