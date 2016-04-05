
public class Problem313 {
	/*
	 * When m == n, we can see that S(m,n) = 8*n-11
	 * It requires m+n-3 moves to get the empty square all the way to the right of the red square
	 * Then, move the red to the right, move a blue up, and move a blue to the left. (3 moves)
	 * Then, move the red down, move a blue to the right, and move a blue up. (3 moves again)
	 * If we continue this pattern, we will end up getting to the square (n,n). However, in the 
	 * last set of three moves in this cycle, we disregard the last two moves beause the red is 
	 * already in the target position. In doing these cycles, we perform 
	 * 3*(2*(n-1)-1) + 1 moves.
	 * In total, we have m+n-3 + 3*(2*(n-1)-1) + 1 = 8*n-11
	 * 
	 * For the case that m > n, we do exactly what we did in the m == n case, but now we also have
	 * to move the red slider across to the square (n, m). It takes m+n-3 + 3*(2*(n-1)-1) + 1 =
	 * m+7n-11 moves to get the slider to square (n,n). Now, the empty spot is right above the 
	 * red square. So do the following routine:
	 * Move a blue to the left, move a blue up, move the red to the right, move a blue down, move a blue to the left. (5 moves)
	 * We need to get to the square (n, m) which will require m-n iterations. However, for the last iteration,
	 * we disregard the last two moves as the slider is in the correct position.
	 * Therefore in total, we used
	 * (m-n-1)*5 + 3 moves.
	 * Adding this to our previous total we get:
	 * m+7n - 11 + (m-n-1)*5+3 = 6m + 2n - 13 moves in total.
	 * 
	 * Thus:
	 * for m == n : 8*n-11 moves
	 * for m > n: 6m+2m-13 moves;
	 * 
	 * 
	 */
	public static void main(String[] args)
	{
		int r = 1000000;
		boolean[] p = new boolean[r+1];
		for(int i =2; i<p.length; i++) p[i] = true;
		for(int i =2; i<p.length; i++)
		{
			if(p[i])
			{
				for(int j =2*i; j<p.length; j+=i)
				{
					p[j] = false;
				}
			}
		}
		
		long ct = 0;
		for(int i = 2; i<p.length; i++)
		{
			if(p[i])
			{
				long c = i; 
				c*=c;
				//m == n
				if((c+11)%8 == 0)
				{
					ct++;
				}
				//m > n
				c+=13;
				long g = 0;
				long maxm = c/6;
				long minm = c/8 + 1;
				if((c-6*maxm)/2 < 2) maxm--;
				if(maxm >= minm)
				{
					g=maxm-minm+1;
				}
				ct+=2*g;
			}
		}
		System.out.println(ct);
		
		
	}

}
