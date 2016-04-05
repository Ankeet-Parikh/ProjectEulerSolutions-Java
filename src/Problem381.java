import java.util.Arrays;

/*
 * Wilson's theorem says that (p-1)! is congruent to -1 (mod p) for a prime p
 * We can show that (p-2)! is congruent to 1 (mod p)
 * Knowing this, compute (p-3)! (mod p) (= is the congruent here)
 * (p-3)! = x (mod p)
 * (p-3)! * (p-2) = x (p-2) (mod p)
 * (p-2)! = px - 2x (mod p)
 * (p-2)! = -2x (mod p)
 * Thus
 * -2x = 1 (mod p)
 * Therefore x = (p+1)/(-2)
 * 
 * Do the same thing for (p-4)!
 * (p-4)! = y (mod p)
 * (p-4)! * (p-3) * (p-2) = y * (p-3) * (p-2) (mod p)
 * (p-2)! = p^2*y - 5py + 6y ( mod p)
 * (p-2)! = 6y (mod p)
 * Thus 
 * 6y = 1 (mod p) 
 * We need the extended euclidean algorithm to solve 6y - np = 1
 * 
 * for (p-5)! we do the same thing, achieving
 * -24z = 1 (mod p)
 * -24z - np = 1 is solved by the extended euclidean algorithm
 * 
 */
public class Problem381 {
	public static void main(String[] args)
	{
		
		int r = 100000000;
		boolean p[] = new boolean[r+1];
		for(int i = 2; i<p.length; i++) p[i] = true;

		for(int i = 2; i<p.length; i++)
		{
			if(p[i])
			{
				for(int j = 2*i; j<p.length; j+=i)
				{
					p[j] = false;
				}
			}
		}
		
		long s = 0;
		for(int i=5; i<p.length; i++) 
		{
			if(p[i])
			{
				int c = S(i);
				s+=c;
				//System.out.println( i + " " + c);
			}
		}
		System.out.println(s);
	}
	
	public static int S(int p)
	{
		int x = (p+1)/-2;
		while(x <= 0) x+=p;
		int[] e1 = eed(6, -p);
		int[] e2 = eed(-24, -p);
		int v = x  + e1[0]*e1[1] + e2[0]*e2[1];
		while(v < 0) v+=p;
		return (v) % p;
	}
	//returns an array of size three [d,s,t]
	//such that d = gcd(a, b) and d = a*s + b*t
	public static int[] eed(int a, int b)
	{
		if(b == 0) return new int[]{a, 1, 0};
		int[] vals = eed(b, a%b);
		int d = vals[0];
		int s = vals[2];
		int t = vals[1] - (a/b)*vals[2];
		return new int[]{d,s,t};
		
	}
}
