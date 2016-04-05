import java.io.*;
import java.util.*;
import java.math.*;

public class A631 {

	public static BufferedReader read = null;
	public static PrintWriter out = null;
	public static StringTokenizer token = null;
	
	
	public static void solve()
	{
		int n = nint();
		int a[] = new int[n];
		int b[] = new int[n];
		for(int i=0; i<n; i++) a[i] = nint();
		for(int i=0; i<n; i++) b[i] = nint();
		int aa[][] = new int[n][n];
		int bb[][] = new int[n][n];
		long sum = 0;
		for(int l=0; l<n; l++)
		{
			for(int r = l; r<n; r++)
			{
				if(r == l)
				{
					aa[l][r] = a[l];
					bb[l][r] = b[l];
				}
				else
				{
					aa[l][r] = aa[l][r-1] | a[r];
					bb[l][r] = bb[l][r-1] | b[r];
				}
				if(aa[l][r] + bb[l][r] > sum ) sum = (aa[l][r] + bb[l][r]);
			}
		}
		out.println(sum);
	}
	
	public static void main(String[] args)
	{
		read = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.flush();
		out.close();
		
	}
	
	// i/o functions
	public static String next() // returns the next string
	{
		while(token == null || !token.hasMoreTokens())
		{
			try {
				token = new StringTokenizer(read.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return token.nextToken();
	}
	
	public static int nint()
	{
		return Integer.parseInt(next());
	}
	public static long nlong()
	{
		return Long.parseLong(next());
	}
	public static double ndouble()
	{
		return Double.parseDouble(next());
	}
	public static int[] narr(int n)
	{
		int[] a = new int[n];
		for(int i=0; i<n; i++) a[i] = nint();
		return a;
	}
	
	public static long[] nal(int n)
	{
		long[] a = new long[n];
		for(int i=0; i<n; i++) a[i] = nlong();
		return a;
	}
	
	
}
