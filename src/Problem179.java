
public class Problem179 {
	public static void main(String [] args)
	{
		int r = (int)1e7;
		int[] d = new int[r+1];
		for(int i = 1; i<d.length; i++)
			for(int j = i; j<d.length; j+=i)
				d[j]++;
		int n =0;
		for(int i=1; i<d.length-1; i++)
			if(d[i] == d[i+1]) n++;
		System.out.println(n);
		
	}
}
