import java.util.ArrayList;

/*
 * Create an array p which lists primality for all integers between 0 and N
 * Start at 2 and generate a tree using the two methods given. 
 * (1) A and B have the same length and differ in exactly one digit; for example, 123 ↔ 173.
 * (2) Adding one digit to the left of A (or B) makes B (or A); for example, 23 ↔ 223 and 123 ↔ 23.
 * If an integer is a two's relative, mark it false in p. An prime that was already in the tree will not be
 * in the tree again. 
 * Do not consider integers greater than N.
 */
public class Problem425 {
	static int r = (int)1e3;
	public static boolean[] p = new boolean[r+1];//contains primes
	public static int[] n2 = new int[r+1]; //contains the primes that are two's relatives
	public static ArrayList<Integer> chains = new ArrayList<Integer>(0);
	public static void main(String[] args)
	{
		for(int i=2; i<p.length; i++) p[i] =true;
		//prime sieve
		for(int i=2; i<p.length; i++)
		{
			
			for(int j =i*2;j<p.length; j+=i )
			{
				p[j] =false; 
			}
		}
		for(int i=0; i<p.length; i++) if(p[i]) n2[i] =i;
		generateChains(2);
		long sum=0;
		for(int i=0; i<p.length; i++)
			sum+=p[i]?i:0;
		System.out.println(sum);
	}
	public static void generateChains(int prev)
	{
		//add p to the chains list
		chains.add(prev);
		//generate replacements
		String s = "" +prev;
		for(int i=0; i<s.length(); i++)
		{
			for(int j =0; j<10; j++)
			{
				String n = s.substring(0, i) + j;
				if(i<s.length()-1) n+=s.substring(i+1, s.length());
				int k = Integer.parseInt(n);
				if(k != prev && k<=r && p[k]) generateChains(k);
			}
		}
		//add to front and back
	}
	public static void remove2srels(ArrayList<Integer> arr)
	{
		int max =0; 
		for(int i=0; i<arr.size(); i++)
			if(arr.get(i) > max)//it is a 2s relative
			{
				p[i]=0;
			}
	}
}
