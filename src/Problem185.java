import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Problem185 {
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("src/problem185.txt"));
		String[] g = new String[1];
		int[] c = new int[g.length];
		int i = 0;
		while(scan.hasNextLine())
		{
			String line = scan.nextLine();
			String[] components = line.split(" ");
			g[i] = components[0];
			c[i] = Integer.parseInt(components[1].substring(1, components[1].length()));
			i++;
		}
		dfs(g, "", c, 0);
	}
	
	public static void dfs(String[] all, String sf, int[] cor, int ind)
	{
		/*
		 * all is the list of guesses, provided by Project Euler
		 * sf is the string "so far"
		 * cor is the number of remaining digits that are correct in each of the guesses
		 * i  is the current index we are on
		 */
		for(int i = 0; i<=9; i++)
		{
			//i will be the guess for this index
			int occur = 0;
			boolean valid = true;
			for(int j = 0; j<all.length; j++)
			{
				if(all[j].charAt(ind) == '0'+i)
				{
					//the guess all[j] has i in the index ind
					occur++;
					if(cor[j] == 0)
					{
						//this number cannot exist in this location
						valid = false;
						break;
					}
				}
			}
			if(occur > 0 && valid)
			{
				//recurse
				int[] next = arcpy(cor);
				for(int j = 0; j<cor.length; j++)
				{
					if(all[j].charAt(ind) == '0'+i)
					{
						next[j]--;
					}
				}
				
				if(ind < all[0].length()-1) dfs(all, sf+i, next, ind+1);
				else 
				{ 
					boolean check = true;
					for(int j =0; j<next.length; j++)
					{
						if(next[j] !=0)
						{
							check = false;
							break;
						}
					}
					if(check)System.out.println(sf+i);
					break;
				}
			}
		}
		
	}
	
	
	public static int[] arcpy(int[] a)
	{
		//returns a pointer to a copy of a, not to a itself
		int[] k = new int[a.length];
		for(int i=0; i<a.length; i++)k[i] = a[i];
		return k;
	}
}
