import java.io.*;
import java.util.*;
import java.math.*;

public class A656 {

	public static BufferedReader read = null;
	public static PrintWriter out = null;
	public static StringTokenizer token = null;
	
	
	public static void solve()
	{
		long n = nint();
		out.println(1l << n);
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

