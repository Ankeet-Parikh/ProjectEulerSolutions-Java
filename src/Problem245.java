import java.util.*;
public class Problem245 {
	public static void main(String[] args)
	{
		int[] tot = new int[100000];
		boolean[] p = new boolean[tot.length];
		for(int i=2; i< tot.length; i++)
		{
				tot[i] = i;
				p[i] = true;
		}
		for(int i=2; i<tot.length; i++)
		{
			if(tot[i] == i)
			{
				for(int j=i; j<tot.length; j+=i)
				{
					tot[j] = tot[j]/i * (i-1);
					if(j!=i)
						p[j] = false;
				}
			}
		}
		for(int i=4; i<tot.length; i++)
		{
			if(!p[i] && (i - 1) % (i - tot[i]) == 0)
			{
				System.out.println(i);
			}
		}
	}
}
