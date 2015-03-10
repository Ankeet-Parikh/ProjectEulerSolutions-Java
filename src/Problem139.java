import java.util.Arrays;


public class Problem139 {
	/*
	 * For each primitive pythagorean triple (a, b, c) where 
	 * a*a + b*b = c*c and gcd(a,b,c) =1
	 * we need to check if c is divisible by b-a. If this is valid, then 
	 * we will determine how many triangles in this family have a perimeter
	 * less than one hundred million. Add that number to the counter. Make the 
	 * counter a global variable so that it can be accessed by the methods.
	 */
	static int counter =0, range = 100000000;
	static int[][] A = {{1,-2,2},{2,-1,2},{2,-2,3}};
    static int[][] B = {{1,2,2},{2,1,2},{2,2,3}};
    static int[][] C = {{-1,2,2},{-2,1,2},{-2,2,3}};
	static int[][][] list = {A, B, C};
	public static void main(String[] args)
	{
		int[] t = {3,4,5};
		PropertyAndCount(t);
		generateNext(t);
		System.out.println(counter);
	}
	public static void generateNext(int[] prev)
	{
		//generates the Tree Of Primitive Pythagorean Triples with perimeters below range
		for(int i = 0; i<list.length; i++)
		{
			int[] trip = nextTrip(list[i], prev);
			//System.out.println(Arrays.toString(trip));
			int perim = trip[0] + trip[1] +trip[2];
			if(perim < range)
			{
				PropertyAndCount(trip);
				generateNext(trip);
			}
		}
	}
	
	
	public static void PropertyAndCount(int[] t) //t for triple
	{
		int diff = (int) Math.abs(t[1]-t[0]);
		if(t[2]%diff==0)
		{
			int perim = t[0] +t[1] +t[2];
			counter+=(int) Math.floor((double)range / perim);
		}
	}
	
	public static int[] nextTrip(int[][] m, int[] t) // using the matrices and the triples 
	{
		int[] r = new int[t.length];
		for(int i=0; i<m.length; i++)
		{
			int a = 0;
			for(int j = 0; j<m[i].length; j++)
			{
				a+=m[i][j]*t[j];
			}
			r[i] =a;
		}
		return r;
	}
}








