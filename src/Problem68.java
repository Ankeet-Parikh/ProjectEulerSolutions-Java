import java.util.Arrays;


public class Problem68 {
	/*
	 *  Outer ring in order: a, b, c, d, e
	 *  Inner ring: f, g, h, i, j
	 *  Solution set: a,g,h; b,h,i; c,i,j: d,j,f; e,f,g;
	 */
	static long max = 0;
	public static void main(String[] args)
	{
		int[] r = {1,2,3,4,5,6,7,8,9,10};
		while(r != null)
		{
			validate(r);
			r = nextperm(r);
		}
		
		System.out.println(max);
	}
	public static int[] nextperm(int[] a)
	{
		int k = a.length-2;
		while(k >=0)
		{
			if(a[k] < a[k+1])break;
			k--;
		}
		if(k == -1) return null;
		int l = a.length-1;
		while(l > k)
		{
			if(a[k] < a[l]) break;
			l--;
		}
		int t = a[k];
		a[k] = a[l];
		a[l] = t;
		for(int j = a.length-1, i = k+1;j>i ;i++, j--)
		{
			int tmp = a[j];
			a[j] = a[i];
			a[i] = tmp;
		}
		return a;
	}
	public static void validate(int[] r)
	{
		/*
		 * Array: [0,1,2,3,4,5,6,7,8,9]
		 * 		  [a,b,c,d,e,f,g,h,i,j]
		 * Stipulations for validity:
		 * a+g = b+i
		 * a+h = e+f
		 * b+h = c+j
		 * c+i = d+f
		 * d+j = e+g
		 */
		int a = r[0], b = r[1], c = r[2], d = r[3], e = r[4], f = r[5], g = r[6], h=r[7], i = r[8], j = r[9];
		if(a + g != b + i || a+h != e+f || b+h != c+j || c+i != d+f || d+j != e+g)
		{
			
			return;
		}
		
		stringify(r);
	}
	
	public static void stringify(int[] r)
	{

		//array will be [0,1,2,3,4,5,6,7,8,9]
		//array will be [a,b,c,d,e,f,g,h,i,j]
		//Solution set: a,g,h; b,h,i; c,i,j: d,j,f; e,f,g; 
		//valid ring, turn int string and test if greater than max
		String s1 = "" +r[0] +"" +r[6] +"" +r[7]; 
		String s2 = "" +r[1] +"" +r[7] +"" +r[8]; 
		String s3 = "" +r[2] +"" +r[8] +"" +r[9]; 
		String s4 = "" +r[3] +"" +r[9] +"" +r[5]; 
		String s5 = "" +r[4] +"" +r[5] +"" +r[6]; 
		String[] l = {s1,s2,s3,s4,s5}; 
		String res = "";
		int mindex = 0, minval = 10;
		for(int i=0; i<=4; i++)
		{
			if(r[i] < minval){
				minval = r[i];
				mindex = i;
			}
		}
		for(int i=0; i<5; i++)
		{
			res+=l[mindex%5];
			mindex++;
		}
		if(res.length() == 16)
		{
			System.out.println(res);
			long val = Long.parseLong(res);
			if(val > max) max = val;
		}
		
	}
	
	
	
	
}
