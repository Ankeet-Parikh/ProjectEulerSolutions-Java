
public class Problem430 {
	public static void main(String[] args)
	{
		boolean[] r = {true, true, true};
		long l = wd(r, 3);
		System.out.println(l);
	}
	
	public static long wd(boolean[] r, int f)
	{
		long exp = 0;
		for(int a = 1; a<=r.length; a++)
		{
			for(int b = 1; b <= r.length; b++)
			{
				boolean[] p = cpy(r);
				int min = a < b? a:b;
				int max = a > b? a:b;
				for(int i = min-1; i<=max-1; i++)
					p[i] = !p[i];
				if(f > 1)
				{
					exp+=wd(p, f-1);
				}
				else
				{
					for(int i=0; i<p.length; i++) if(p[i]) exp+=1;
				}
			}
		}
		return exp;
	}
	
	public static boolean[] cpy(boolean[] a)
	{
		boolean[] b = new boolean[a.length];
		for(int i = 0; i<a.length; i++)
			b[i] = a[i];
		return b;
	}
}
