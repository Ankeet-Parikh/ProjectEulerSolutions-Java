
public class Problem94 {
	public static void main(String[] args)
	{
		System.out.println(Solve());
	}
	public static boolean is(int a)
	{
		int s = 0, b= 0; //side and base
		if(a%3 == 1)
		{
			//means a = s + s + (s+1)
			s = (a-1)/3;
			b = a-s-s;
			long r = 3*s*s-2*s-1;
			if(r%4 == 0) 
			{
				r/=4;
				long rt = (long)Math.sqrt(r);
				if(rt*rt == r)
				{
					//System.out.println("Case 1: " + s + " " + rt);
				}
			}
		}
		if(a%3 == 2)
		{
			// that means a = s + s + (s-1)
			s = (a+1)/3;
			b = a-s-s;
			long r = (3*s-1)*(s+1);
			if(r%4 == 0) 
			{
				r/=4;
				long rt = (long)Math.sqrt(r);
				if(rt*rt == r)
				{
					//System.out.println("Case 2: " + s + " " + rt);
				}
			}
		}
		
		return true;
	}
	
	public static long Solve()
	{
		long max = (long)1e9;
		long res = 0;
		//start with case 1
		long s = 5, k =4;
		while(true)
		{
			
			long perim = s + s + s+1;
			//System.out.println(s + " " + k);
			if(perim > max) break;
			res += perim;
			long sn = 7*s + 8*k - 2;
			long kn = 6*s + 7*k - 2;
			s = sn;
			k = kn;
		}
		s = 17;
		k = 15;
		while(true)
		{
			long perim = s + s + s-1;
			if(perim > max) break;
			res+=perim;
			long sn = 7*s + 8*k +2;
			long kn = 6*s + 7*k +2;
			s = sn;
			k = kn;
		}
		return res;
	}
}
