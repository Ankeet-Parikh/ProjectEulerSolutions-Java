
public class Problem150 {
	/*
	 * This question asks to find the smallest possible sub-traingle sum
	 * in the triangular array.
	 * First, transform each element in each line to the sum of the elements up to that element
	 * Example:
	 * Line: 20 -13 -5
	 * Transform: 20 7 2
	 * 
	 * Then, go through each element in the array, mark it as the vertex, and find the sums
	 * of all the triangles with that element as the vertex.
	 * store the triangle as a 2d array
	 */
	public static void main(String[] args)
	{
		int[][] t = {{15},{-14, -7},{20, -13, -5}, {-3, 8, 23, -26}, {1,-4,-5, -18, 5}, {-16,31,2,9,28,3}};
		t = lincong();
		System.out.println(minsub(t));
	}
	public static int minsub(int[][] tri)
	{
		//finds the minimum sub triangle sum
		transform(tri);
		int min = Integer.MAX_VALUE;
		for(int i=0; i<tri.length; i++)
		{
			for(int j =0; j<tri[i].length; j++)
			{
				int m = mintri(tri, i, j);
				min = m < min? m:min;
			}
		}
		return min;
	}
	
	public static int mintri(int[][] tri, int i, int j)
	{
		//returns the minimum sub triangle sum for triangles starting at this vertex
		//only works on transformed triangle array (see aove for what that means)
		int mins = Integer.MAX_VALUE;
		int s = j, e = j; //start and end indeces on the line
		int sum = 0;
		for(int line = i; line < tri.length; line++)
		{
			if(s-1 < 0)
			{
				sum += tri[line][e];
			}
			else
			{
				sum+= tri[line][j] - tri[line][s-1];
			}
			
			if(sum < mins) mins = sum;
			j++;
		}
		return mins;
	}
	public static void transform(int[][] a)
	{
		for(int i=0; i<a.length; i++)
		{
			int s = a[i][0];
			for(int j =1; j< a[i].length; j++)
			{
				s = a[i][j]+s;
				a[i][j] = s;
			}
		}
	}
	
	public static int[][] lincong()
	{
		int[][] s = new int[1000][0];
		for(int i=0; i<s.length; i++) 
			s[i] = new int[i+1];
		int mod = (int)Math.pow(2, 20);
		int sub = mod/2;
		long t = 0;
		int i = 0, j = 0;
		for(int k =1; k<=500500; k++)
		{
			t = (615949*t + 797807);
			t%=mod;
			int sk = (int)t - sub;
			s[i][j] = sk;
			
			j++;
			if(j == s[i].length)
			{
				i++;
				j =0;
			}
			
		}
		return s;
	}
	
	public static void Print(int[][] a)
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		for(int i=0; i<a.length; i++)
		{
			for(int j =0; j<a[i].length; j++)
			{
				System.out.print(a[i][j] +" ");
			}
			System.out.println(" ");
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
	}
}
