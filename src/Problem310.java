import java.util.Arrays;

public class Problem310 {
	public static void main(String[] args)
	{
		//System.out.println(mex(new int[]{0,0,1}));
		int r = 100000;
		int[] sg = new int[r+1];
		sg[0]=0;
		for(int i=1; i<=r; i++)
		{
			int rt = (int) Math.sqrt(i);
			int[] f = new int[rt];
			for(int j =0; j<f.length; j++)
			{
				f[j] = sg[i-(j+1)*(j+1)];
			}
			sg[i] = mex(f);
			//System.out.println(i + " " + sg[i]);
		}
		long ct = 0;
		for(int i=1; i<=100000; i++)
		{
			for(int j = i; j<=100001; j++)
			{
				ct++;
			}
		}
		System.out.println(ct);
	}
	
	public static int mex(int f[])
	{
		Arrays.sort(f);
		if(f[0]!= 0) return 0;
		else
		{
			for(int i=1; i<f.length; i++)
			{
				int d = f[i]-f[i-1];
				if(d > 1)
				{
					return f[i-1]+1;
				}
			}
		}
		return f[f.length-1]+1;
	}
}
