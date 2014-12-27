
public class Problem218 {
	static long count =0;
	static double[][] A = {{1,-2,2},{2,-2,2},{2,-2,3}};
	static double[][] B = {{1,2,2},{2,1,2},{2,2,3}};
	static double[][] C = {{-1,2,2},{-2,1,2},{-2,2,3}};
	public static void main(String[] args)
	{
		/*
		*	The answer is 0.
		*/
		double[][] start = {{3},{4},{5}};
		double curtail  = Math.pow(10,3);
		recurseCount(start, curtail);
		System.out.println(count);
	}
	public static void recurseCount(double[][] prev, double curtail)
	{
		double[][] a = Xmult(A, prev);
		if(a[2][0] <=curtail)
		{
			
			//count = isPNS(a[0][0],a[1][0],a[2][0]) ? count+1: count;
			if(isPNS(a[0][0], a[1][0],a[2][0]))
			{
				count++;
				PrintArray(a);
			}
			recurseCount(a,curtail);
		}
		double[][] b = Xmult(B,prev);
		if(b[2][0] <=curtail)
		{
			count = isPNS(b[0][0],b[1][0],b[2][0]) ? count+1: count;
			recurseCount(b,curtail);
		}
		double[][] c = Xmult(C,prev);
		if(c[2][0] <=curtail)
		{
			count = isPNS(c[0][0],c[1][0],c[2][0]) ? count+1: count;
			recurseCount(c,curtail);
		}
	}
	public static boolean isPNS(double a, double b, double c) //perfect but not super
	{
		//must have three criteria:
		//primitive right angled triangle (this is not tested in this method)
		//hypotenuse is perfect square
		//area is not a multiple of 6 and 28
		double rt = Math.sqrt(c);
		double area = 0.5*a*b;
		return (rt == (long)rt) && (area %6 !=0 || area%28!=0) ;
	}
	public static double[][] Xmult(double[][] a, double[][] b)//assume the inputs are rectangle arrays
	{
		if(a[0].length != b.length)
			return null;
		else
		{
			double[][] prod = new double[a.length][b[0].length];
			for(int i =0; i<a.length; i++)
			{
				for(int k =0; k<b[0].length; k++)
				{
					for(int j =0; j<a[i].length;j++)
					{
						prod[i][k] += a[i][j]*b[j][k];
					}
				}
			}
			return prod;
		}
	}
	public static void PrintArray(double[][] a)
	{
		for(int i=0; i<a.length; i++)
		{
			for(int j =0; j<a[i].length; j++)
			{
				System.out.print(a[i][j] +" ");
			}
			System.out.println("");
		}
	}
}
