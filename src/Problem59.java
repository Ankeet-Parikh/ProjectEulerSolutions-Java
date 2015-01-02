import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem59 {
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("src/p059_cipher.txt"));
		String [] input = scan.nextLine().split(",");
		char[] text = new char[input.length];
		for(int i=0; i<text.length; i++)
			text[i] = (char) Integer.parseInt(input[i]);
		int a = 97, z =122, sum =0;
		int[] key = new int[3];
		for(int i= a; i<=z; i++)
		{
			key[0] =i;
			for(int j = a; j<=z; j++)
			{
				key[1] =j;
				for(int k = a; k<=z; k++)
				{
					key[2] =k;
					char [] orig = decrypt(text, key);
					String o = new String(orig);
					if(o.contains("the") && o.contains("of") && o.contains("and") && o.contains("to") && o.contains("was"))//common english words
					{
						//only one string will pass the condition of the if statement
						sum+=sumASCII(orig);
						System.out.print("Key:" + key[0] + " " +key[1] +" " +key[2] +"   ");
						System.out.println(o);
					}
				}
			}
		}
		System.out.println(sum);
	}
	
	public static char[] decrypt(char[] text, int[] key)
	{
		char[] dec = new char[text.length];
		for(int i =0; i<dec.length; i++)
		{
			dec[i] = (char) ((char) key[i%3] ^ text[i]); // ^ is the XOR operator in java
		}
		return dec;
	}
	
	public static int sumASCII(char[] a)
	{
		int s =0;
		for(int i=0; i<a.length; i++) s+= (int)a[i];
		return s;
	}
}
