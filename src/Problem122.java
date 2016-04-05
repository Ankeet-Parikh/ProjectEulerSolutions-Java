
public class Problem122 {
	static int r = 200;
	static int[] m = new int[r+1];
	public static void main(String[] args)
	{
		for(int i=1; i<m.length; i++) m[i] = Integer.MAX_VALUE;
		m[1] = 0;
		m[2] = 1;
		int[] l = new int[r+1];
		l[0] = 1;
		l[1] = 2;
		dfstree(l,2);
		long sum = 0;
		for(int i=1; i<=r; i++)
		{
			//System.out.println(i + " " + m[i]);
			sum+=m[i];
		}
		System.out.println(sum);
	}
	public static void dfstree(int[] prev, int s)
	{
		//prev is the list of the parents of the tree back to 1
		//s is the number of nonzero elements in prev 
		int u = 0;
		for(int i=u; i<s; i++)
		{
			int n = prev[s-1] + prev[i];
			if(n<=r)
			{
				boolean recurse = true;
				if(s > m[n]) recurse = false; 
				m[n] = (int)Math.min(s, m[n]);
				if(recurse)
				{
					prev[s] = n;
					dfstree(prev, s+1);
				}
			}
		}
	}

}
