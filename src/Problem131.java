/*
 * We are looking for primes p which have a unique positive integer
 * n such that n^3 + n^2 * p is a perfect cube:
 * 
 * n^3 + n^2 * p  = k^3
 * let g = gcd(n,k)
 * then n = gn' and k = gk'
 * (n'^2)p = g(k'-n')(k'^2 + k'n' + n'^2)
 * 
 * We can see that n'^2 is coprime to (k'-n')(k'^2+k'n'+n'^2) (proof is below) 
 * which indicates that p = (k'-n')(k'^2 + k'n' + n'^2). p can only be prime
 * when k'-n' = 1. Thus, p = 3n'^2 + 3n' +1.
 * 
 * Proof that n'^2 is coprime to (k'-n')(k'^2+k'n'+n'^2):
 * gcd(n'^2, k'^3 - n'^3).
 * For simplicity, write a = n' and b = k'.
 * Suppose that a prime q divides a^2 and it divides b^2-a^2
 * Then we know that b^2-a^2 = q(b^2/q + a^2/q)
 * Since a^2/q is an integer, then it must be the case that b^2/q is an integer.
 * However, if b^2/q was an integer, then q would divide b, which contradicts the
 * initial statement that a and b are coprime.
 * 
 * 
 */
public class Problem131 {
	public static void main(String[] args)
	{
		int r = 1000000;
		boolean p[] = new boolean[r];
		for(int i=2; i<p.length; i++) p[i] = true;
		for(int i=2; i<p.length; i++){
			
			if(p[i])
			{
				
				for(int j=2*i; j<p.length; j+=i)
				{
					p[j] = false;
				}
			}
		}
		int ct = 0;
		for(int n = 1; 3*n*n + 3*n + 1 < r; n++)
		{
			int val = 3*n*n + 3*n + 1;
			if(p[val])
			{
				//System.out.println(val);
				ct++;
			}
		}
		System.out.println(ct);
	}
	public static int gcd(int a, int b)
	{
		return b ==0 ? a : gcd(b, a%b);
	}
}
