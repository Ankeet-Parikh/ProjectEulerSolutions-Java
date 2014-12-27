
public class Problem204 {
	static int[] primes ={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	
	public static void main(String[] args)
	{
		
		System.out.println(count(0, (int)1e9));
	}
	
	public static long count(int i, int max)
	{
		int c = primes[i];
		int h = (int)(Math.floor(Math.log(max)/Math.log(c)));
		int tally =0;
		
		if(i != primes.length-1)
		{
			for(int j =0; j<=h; j++)
			{
				tally+= count(i+1, (int)Math.floor(max/Math.pow(c, j)));
			}
			
		}
		else
			return h+1;
		return tally;
		
	}
	
	
	
}
