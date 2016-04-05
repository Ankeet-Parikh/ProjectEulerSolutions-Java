import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Problem105 {
	/*
	 * There are 2^n subsets of an element with n elements
	 * 2^n = (n choose 0) + n choose 1 + .. +n choose n
	 * we can represent a subset by an n bit binary string:
	 * Ex: 11000 is for a 5 element set
	 * And 00111 is the disjoint subset
	 * 
	 * Iterate from 1 to 2^n-1 and verify the rules for the subsets
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("src/sets.txt"));
		int total = 0;
		while(scan.hasNextLine())
		{
			String l = scan.nextLine();
			String[] e = l.split(",");
			int[] arr = new int[e.length];
			int sum = 0;
			for(int i=0; i<arr.length; i++)
			{
				int c = Integer.parseInt(e[i]);
				arr[i] = c;
				sum+=c;
			}
			if(verifyRules(arr))
			{
				total+=sum;
			}
		}
		System.out.println(total);
	}
	
	public static boolean verifyRules(int[] a)
	{
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
		for(int i=1; i<Math.pow(2, a.length);i++)
		{
			int snum = Integer.bitCount(i); //number of elements in this subset
			int ssum = sumEl(a, i);
			for(int k = i+1; k<Math.pow(2,a.length); k++)
			{
				if((i & k) == 0)
				{
					int cnum = Integer.bitCount(k);
					int csum = sumEl(a,k);
					
					//verify rule 1
					if(csum == ssum) return false;
					//verify rule 2
					if(cnum > snum)
					{
						if(csum <ssum) return false;
					}
					if(snum > cnum)
					{
						if(ssum < csum) return false;
					}
				}
			}
		}
		return true;
	}
	
	public static int sumEl(int[] a, int n)
	{
		String b = Integer.toBinaryString(n);
		//System.out.println(b);
		int ssum = 0;
		for(int j = b.length()-1; j>=0; j--)
		{
			if(b.charAt(j) == '1')
			{
				ssum+=a[a.length-(b.length()-j)];
			}
		}
		return ssum;
	}
}
