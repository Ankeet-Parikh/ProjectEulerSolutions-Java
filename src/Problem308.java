
public class Problem308 {
	//fraction index   0    1   2   3   4   5   6   7   8   9  10  11  12  13
	static long[] n = {17, 78, 19, 23, 29, 77, 95, 77,  1, 11, 13, 15,  1, 55};
	static long[] d = {91, 85, 51, 38, 33, 29, 23, 19, 17, 13, 11,  2,  7,  1};
	/*
	 * No fraction contains a prime factor higher than 29
	 * thus each starting seed can be represented in the form:
	 * 2^a * 3^b * 5^c * 7^d * 11^e * 13^f * 17^g * 19^h * 23^i * 29^j
	 * Keep an array of these powers {a,b,c,d,e,f,g,h,i,j}
	 * 
	 * The starting seed will be a prime power of 2: {p,0,0,0,0,0,0,0,0,0}
	 * Then we will keep multiplying the seed by 15/2: {0,p,p,0,0,0,0,0,0,0} (process of n steps)
	 * Then multiply by 55: {0,p,p+1,0,1,0,0,0,0,0}
	 * Then multiply by 29/33 and 77/29 (alternatingly) until no 3s remain
	 * There will be an 11 left, so multiply by 13/11: now we are at 5^(p+1)*7^p*13
	 * Multiply by 17/91 and 78/85 (alternatingly) until all 7s are gone: 2^p * 3^p * 5 * 13
	 * Multiply by 11/13 to get: 2^p * 3^p * 5 * 11 
	 *  
	 *
	 */
	public static void main(String[] args)
	{
		
		long s = 32, n = 128;
		
		for(int i=1; i<1000; i++)
		{
			s= iter(s);
			System.out.println(" " + s);
			if(s == n) break;
		}
		
	}
	
	public static long iter(long s)
	{
		for(int i =0; i<n.length; i++)
		{
			if(s%d[i] == 0)
			{
				System.out.print(i);
				return s/d[i]*n[i];
			}
		}
		return -1;
	}

}
