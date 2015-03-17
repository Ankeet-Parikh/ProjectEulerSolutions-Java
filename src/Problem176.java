
public class Problem176 {
	static int max = (int)1e7;
	static int[] occ = new int[max+1];
	public static void main(String[] args)
	{
		int[] p ={15, 8, 17};
		Print(nextA(p));
	}
	public static int dot(int[] a, int[] b)
	{
		int c =0;
		for(int i=0; i< a.length; i++)
		{
			c+=a[i]*b[i];
		}
		return c;
	}
	public static int[] nextA(int[] p)
	{
		int[] n = new int[3];
		n[0] = dot(p, new int[]{1,-2,2});
		n[1] = dot(p, new int[]{2,-1,2});
		n[2] = dot(p, new int[]{2,-2,3});
		return n;
	}
	public static int[] nextB(int[] p)
	{
		int[] n = new int[3];
		n[0] = dot(p, new int[]{1,2,2});
		n[1] = dot(p, new int[]{2,1,2});
		n[2] = dot(p, new int[]{2,2,3});
		return n;
	}
	
	public static int[] nextC(int[] p)
	{
		int[] n = new int[3];
		n[0] = dot(p, new int[]{-1,2,2});
		n[1] = dot(p, new int[]{-2,1,2});
		n[2] = dot(p, new int[]{-2,2,3});
		return n;
	}
	public static void Print(int[] a)
	{
		for(int i=0; i< a.length; i++) System.out.print(a[i] +" ");
	}
}
