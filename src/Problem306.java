import java.util.Arrays;

public class Problem306 {
	public static void main(String[] args)
	{
		int n = 500;
		//sprague grundy numbers
		int s[] = new int[n+1];
		s[1] = 0;
		
		for(int i=2; i<= n; i++)
		{
			//iterate over all the followers
			int f[] = new int[i-1];
			for(int j = 0; j<= i-2; j++)
			{
				f[j] = s[j] ^ s[i-2-j];
 			}
			s[i] = mex(f);
		}
		for(int i =1; i<s.length; i++)
		{
			//System.out.println(i +  " " + s[i] + " " + (s[i] == 0 ? "P" :  "N"));
			//if(s[i] == 0) System.out.println(i);
		}
		System.out.println(c2(1000000));
		/*int c = 0;
		for(int i=1; i<s.length; i++)
			if(s[i] != 0)c++;
		System.out.println(c);
		*/
		
	}
	
	public static int mex(int f[])
	{
		Arrays.sort(f);
		if(f[0] != 0) return 0;
		else
		{
			for(int i=1; i<f.length; i++)
			{
				int d = f[i] - f[i-1];
				if(d > 1)
					return f[i-1]+1;
			}
			return f[f.length-1]+1;
		}
	}
	
	public static int c2(int n)
	{
		//p sequence becomes periodic: 
		// for n > 14 a(n) = a(n-5) + 34
		int ps[] = new int[n];
		int init[] = {1,5, 9, 15, 21, 25, 29, 35, 39, 43, 55, 59, 63, 73, 77};
		for(int i=1; i<= Math.min(init.length, ps.length-1); i++)
			ps[i] = init[i-1];
		for(int i=init.length; i< ps.length ; i++)
			ps[i] = ps[i-5]+34;
		int i= 0;
		while(ps[i] <= n)
		{
			i++;
		}
		//System.out.println(i + " " + ps[i]);
		return n-(i-1);
	}
}
