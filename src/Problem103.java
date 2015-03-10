
public class Problem103 {
	/*
	 * A = {a1, a2, ... , an}, the next optimum set is of the form B = {b, a1+b, a2+b, ... ,an+b}.
	 * This doest work from 5 to 6, but it works from 6 to 7. Weird.
	 */
	public static void main(String[] args)
	{
		int[] s6 = {11,18,19,20,22,25};
		int[] s7 = next(s6);
		for(int i =0; i<s7.length; i++) System.out.print(s7[i]);
	}
	
	public static int[] next(int bef[])
	{
		int[] n = new int[bef.length+1];
		n[0] = bef[(int)Math.ceil(bef.length/2.0)];
		for(int i=1; i<n.length; i++) n[i] = n[0] + bef[i-1];
		return n;
	}
}
