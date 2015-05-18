
public class Problem147 {
	public static void main(String[] args)
	{
		System.out.println(rectinside(3,2));
	}
	
	public static long rectinside(long c, long r)
	{
		long rec = ((r*r+r)/2)*((c*c+c)/2);
		return rec;
	}
}
