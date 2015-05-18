public class Problem137 {
	public static void main(String[] args) {
		/*
		 * The formula for the infinite polynomial series is given as: AF(x) =
		 * x*F1 + x^2 * F2 +x^3 *F# +... FK is the kth term in the fibonacci
		 * series: F1 = 1, F2 = 1, F_K = F_(K-1) +F_(k-2) We can rewrite AF(x)
		 * in the form: AF(x) = x/(1-x-x^2). AF(x) is less than infinity for |x|
		 * < 1/(golden ratio) We are interested in solutions where AF(x) is
		 * integral, so let us write:
		 * 
		 * n = x/(1-x-x^2) where n = 1, 2, 3, 4,... Another form: nx^2 + (n+1)x
		 * - n = 0 Solving for x with the quadratic formula: (we only want the
		 * positive solution) x = (-(n+1) + Ã((n+1)^2-4*(n)*(-n)) )/(2n)
		 * 
		 * Since we are only considering solutions where x is rational, it is
		 * necessary that the descriminant be a perfect square. Otherwise, x
		 * would be irrational
		 * 
		 * Rewrite the discriminant as: 5n^2+2n+1 5n^2+2n+1 = k^2 for some
		 * integer k By completing the square and simplifying down we get:
		 * (5n+1)^2 - 5k^2 = -4 This is Pell's equation of the form x^2-D*y^2 =
		 * -4, where x = 5n+1, and D = 5. I found the solution using:
		 * http://www.
		 * m-hikari.com/ams/ams-password-2007/ams-password5-8-2007/tekcanAMS5
		 * -8-2007.pdf First find the fundamental solution, in this case it is
		 * x1 = 1, y1 =1. The next solutions are of the form (x(2n+1), y(2n+1)):
		 * 
		 * x(2n+1) = ((x1*x1+D*y1*y1)*(x(2n-1)) + (2*D*x1*y1*y(2n-1)))/4;
		 * y(2n+1) = ((2*x1*y1*x(2n-1)) + (x1*x1+D*y1*y1)*(y(2n-1)) )/4;
		 * 
		 * It is a fibonacci golden nugget if x(n) % 5 ==1
		 * 
		 * Here are the first fifteen: 2, 15, 104, 714, 4895, 33552, 229970, 1576239,
		 * 10803704, 74049690, 507544127, 3478759200, 23843770274, 163427632719,
		 * 1120149658760
		 * Also, these numbers are of the form
		 * Fibonacci(2n)*Fibonacci(2n+1)
		 * A081018 in OEIS
		 * Which, somehow, relates back to the Fibonacci sequence!
		 * 
		 */
		/*
		 * for(int n=1; n<=1000000; n++) { long d = D(n); double rt =
		 * Math.sqrt(d); if(rt == (long)rt) System.out.println("D("+n+")"+" = "
		 * + D(n) + "  k = " + (long)rt); }
		 */

		long x1 = 1, y1 = 1, D = 5, x = x1, y = y1;
		int gcounter = 0;
		for (int i = 0; i < 100; i++) {
			long xn = ((x1 * x1 + D * y1 * y1) * (x) + (2 * D * x1 * y1 * y)) / 4;
			long yn = ((2 * x1 * y1 * x) + (x1 * x1 + D * y1 * y1) * (y)) / 4;
			x = xn;
			y = yn;
			if (xn % 5 == 1) {
				gcounter++;
				if (gcounter == 15)
					break;
				//System.out.println((x - 1) / 5);
			}
		}
		System.out.println((x - 1) / 5);
	}

	public static long D(long n) {
		return 5 * n * n + 2 * n + 1;
	}
}
