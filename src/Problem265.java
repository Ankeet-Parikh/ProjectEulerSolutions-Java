/*
 * Going through every binary string of length 2^n is horribly inefficient as there are 2^2^n altogether.
 * Instead, I will try to generate the strings that work.
 * for length 5, we have a string of 32 characters.
 * each contiguous block of length 5 must be a distinct sequence, in other words, each block must correspond
 * to a different number from 0 to 31.
 * 
 * Let us look at a contiguous block in regards to the block before it.
 * If the block before was of the form
 * abcde
 * where abcde is a binary string of length 5
 * then the next block can be one of either
 * bcde0
 * bcde1
 * 
 */
public class Problem265 {
	static long sum = 0;
	public static void main(String[] args)
	{
		int n = 5;
		int tl = (int)Math.pow(2, n);
		//each of the blocks starts with n zeroes
		String s = "";
		for(int i=0; i<n; i++) s+="0";
		s+="1";
		boolean d[] = new boolean[tl];
		d[0] = true;
		d[1] = true;
		recurse(s, d, n, tl);
		System.out.println(sum);
		
	}
	
	public static void recurse(String sf, boolean[] used, int bl, int tl) 
	{
		//sf is the string so far
		//used is the numbers used so far
		//bl is the size of the block (block length)
		//tl is total length
		String s1 = sf.substring(sf.length()-bl+1) + "0";
		String s2 = sf.substring(sf.length()-bl+1) + "1";
		int n1 = Integer.parseInt(s1,2);
		int n2 = Integer.parseInt(s2,2);
		if(!used[n1])
		{
			if(sf.length() == tl-1)
			{
				/*
				 * in this case, the binary string ends in 0.
				 * This cannot happen because the string starting from the last element  and circling
				 * back through the first n-1 elements will be a string of zeros. We already had a string of
				 * zeros.
				 */
			}
			else
			{
				boolean[] b = arrcpy(used);
				b[n1] = true;
				recurse(sf+"0",b,bl,tl);
			}
		}
		if(!used[n2])
		{
			if(sf.length() == tl-1)
			{
				int curr = Integer.parseInt(sf+"1",2);
				check(sf, bl, used);
			}
			else
			{
				boolean[] b = arrcpy(used);
				b[n2] = true;
				recurse(sf+"1",b,bl,tl);
			}
		}
		
	}
	public static void check(String sf, int bl, boolean[] used)
	{
		String n =sf+"1";
		//we need to check the last n-1 sequences that "circle around" and make sure they are distinct.
		boolean works = true;
		for(int i=1; i<bl-1;i++)
		{
			String c = "";
			int s = n.length()-bl+i;
			int e = n.length()+i;
			for(int j = s; j < e ; j++)
			{
				c+=n.charAt(j%n.length());
			}
			
			int curr = Integer.parseInt(c, 2);
			if(!used[curr]) used[curr] = true;
			else
			{
				works = false;
				break;
			}
		}
		if(works)
			sum+=Integer.parseInt(n,2);
	}
	public static boolean[] arrcpy(boolean[] a)
	{
		boolean[] b = new boolean[a.length];
		for(int i=0; i<b.length; i++)
			b[i] = a[i];
		return b;
	}
}
