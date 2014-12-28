
public class Problem179 {
	public static void main(String [] args)
	{
		int r = (int)1e7, n=0;
		int[] d = new int[r+1];
		for(int i = 1; i<d.length; i++)
		{
			for(int j = i; j<d.length; j+=i)
				d[j]++;
			if(i>2)
				if(d[i] == d[i-1])
					n++;
		}
		
		System.out.println(n);
		
	}
}
