
public class Problem518 {
	public static void main(String[] args)
	{
		int l = 100000000;
		    l = 100;
		boolean[] p = new boolean[l+1];
		for(int i=2; i<p.length; i++) p[i] = true;
		for(int i=2; i<p.length; i++)
		{
			if(p[i])
			{
				for(int j = 2*i; j<p.length; j+=i)
					p[j] = false;
			}
		}
		long sum = 0;
		for(int i=2; i<p.length; i++)
		{
			if(p[i])
			{
				//prime triple: {i, j, k}
				//geometric triple: {f, s, t} for first, second, third
				//ratio between terms, r = s/f = t/s
				//s = fr,  t = sr,  t = fr^2
				
				int f = i+1;
				int us = (int)(Math.sqrt(l/(double)f)*f);//upper bound for second integer
				//System.out.println(i + " " + m + " " + us);
				for(int j = i+1; j <us; j++) //less than because j+1 must be less than or equal to us
				{
					if(p[j])
					{
						long s = j+1;
						
						if(s*s % f == 0)
						{
							int t = (int) (s*s/f);
							if(p[t - 1])
							{
								
								System.out.println(i + " " + j + " "  + (t-1));
								sum+= i + j + t-1;
							}
						}
					}
				}
			
			}
		}
		System.out.println(sum);
		
	}
}
