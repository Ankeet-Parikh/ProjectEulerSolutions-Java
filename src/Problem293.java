import java.util.ArrayList;

public class Problem293 {
	static int max = (int) 1e9 - 1;
	static int range = (int) Math.sqrt(max) + 10; // ten just to be safe :)
	static ArrayList<Integer> primes = new ArrayList<Integer>(0);
	static ArrayList<Integer> pf = new ArrayList<Integer>(0);

	public static void main(String[] args) {
		/*
		 * Admissible numbers must be even, so two is always going to be a prime
		 * factor. Also, since the prime factors are consecutive primes,
		 * admissible numbers must be of the form: (2^e1)*(3^e2)*(5^e3)...
		 */

		boolean[] p = new boolean[range + 1];
		for (int i = 0; i < p.length; i++)
			p[i] = true;

		for (int i = 2; i < p.length; i++) {
			if (p[i]) {
				primes.add(i);
				for (int j = i + i; j < p.length; j += i)
					p[j] = false;
			}
		}
		RecurseCompute(0, 1);
		long sum = 0;
		for (int i = 0; i < pf.size(); i++)
			sum += pf.get(i);
		System.out.println(sum);

	}

	public static void RecurseCompute(int index, int prod) {
		/*
		 * find all the admissible numbers less than max, determine their psuedo fortunate
		 * numbers and add them to the list.
		 */
		int cp = primes.get(index);
		int maxExp = (int)Math.floor(Math.log((double)max/prod)/Math.log(cp));
		if(maxExp <= 0) return;
		for(int i =1; i<=maxExp; i++)
		{
			int curr = (int)(prod*Math.pow(cp, i));
			int x = psf(curr);
			if(!pf.contains(x))pf.add(x);
			RecurseCompute(index+1, curr);
		}

	}

	public static int psf(int n) {
		/*
		 * returns smallest integer M > 1 such that n+M is prime Stipulation: n
		 * is always even
		 */
		int m = 3;
		while (!isPrime(n + m))
			m += 2;
		return m;

	}

	public static boolean isPrime(int n) {
		if (n == 2)
			return true;
		if (n == 0 || n == 1)
			return false;
		for (int i = 0; primes.get(i) <= Math.sqrt(n); i++) {
			if (n % primes.get(i) == 0)
				return false;
		}
		return true;
	}
}
