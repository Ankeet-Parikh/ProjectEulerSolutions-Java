
public class Problem460 {
	public static void main(String[] args)
	{
		int[] xc = {0,2,4,6,8,10};
		int[] yc = {1,5,6,6,5,1};
		System.out.println(totalTime(xc, yc));
	}
	
	public static double totalTime(int[] x, int[] y)//pass in coordinates
	{
		if(x.length != y.length)
		{
			System.out.println("Incorrect Coordinate Entry");
			return 0;
		}
		double t = 0;
		for(int i=0; i<x.length-1; i++)
		{
			double di = d(x[i], y[i], x[i+1], y[i+1]);
			double ve = v(y[i], y[i+1]);
			t += di/ve;
		}
		return t;
	}
	public static double d(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	public static double v(int y0, int y1)
	{
		if(y0 == y1) return y0;
		else return (y1-y0)/(Math.log(y1) - Math.log(y0));
	}
}
