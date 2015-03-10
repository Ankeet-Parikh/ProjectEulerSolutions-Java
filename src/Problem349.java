
public class Problem349 {
	public static void main(String[] args)
	{
		System.out.println(S(18000L));
	}
	public static long S(long k)
	{
		int r =10000;
		boolean[][] grid = new boolean[r][r];
		int cx = r/2, cy = r/2;//starting positions
		int o = 0; //0 for up, 1 right, 2 down, 3 left
		for(int i=1; i<=k; i++)
		{
			
			if(grid[cy][cx])//current square is black
			{
				grid[cy][cx] = false; //flip it to white
				o = (o-1)%4; //turn counterclockwise
			}
			else if(!grid[cy][cx]) //current square is white
			{
				grid[cy][cx] = true; //flip to black
				o = (o+1)%4; //turn clockwise
	
			}
			int[] next = nextSquare(cx, cy, o);
			cx = next[0];
			cy = next[1];
			int m = 11000;
			if((i-m)%208 ==0 && i>m)
			{
				System.out.println(i +": " + countTrue(grid));
			}
		}
		return countTrue(grid);
	}
	public static int[] nextSquare(int cx, int cy, int o ) //returns {cx, cy}
	{

		int[] n = new int[2];
		if(o == 0)cy--;
		else if(o == 1)cx++;
		else if(o == 2)cy++;
		else if(o == 3)cx--;
		n[0] =cx;
		n[1] =cy;
		return n;
	}
	public static long countTrue(boolean[][] a)//count the number of black squares
	{
		long c =0;
		for(int i=0; i<a.length; i++)
			for(int j =0; j<a[i].length; j++)
				if(a[i][j]) c++;
		return c;
	}
}
