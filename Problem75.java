package problems_70_79;

import java.util.ArrayList;

//Generate Tree of Primitive Pythagorean Triples
//Use the Matrices A, B, and C to do so: http://en.wikipedia.org/wiki/Tree_of_primitive_Pythagorean_triples
//Generate the multiples of all the perimeters of the primitive triples: non-distinct
//See how many times each multiple occurs

public class Problem75 {
	static long[][] A = {{1,-2,2},{2,-1,2},{2, -2,3}};
	static long[][] B = {{1,2,2},{2,1,2},{2,2,3}};
	static long[][] C = {{-1,2,2},{-2,1,2},{-2,2,3}};
	public static void main(String[] args)
	{
		int range = 1500000;
		ArrayList<Long> perimeters = new ArrayList<Long>(0);
		long[] start = {3,4,5};
		perimeters.add(perimeter(start));
		generateTree(perimeters,range,start);
		long[] ways = new long[range+1];
		
		for(int i=0;i<perimeters.size(); i++)
		{
			long e = perimeters.get(i); 
			for(int j =(int) e; j<ways.length; j+=e)
			{
				ways[j]++;
			}
		}
		int count = 0;
		for(int i =0; i<ways.length; i++)
		{
			if(ways[i]==1) count++;
		}
		System.out.println(count);
		
	}
	public static void generateTree(ArrayList<Long> p, long range, long[] prev)
	{
		//First Branch
		long[] a = matrixmultiply(A,prev);
		long suma = perimeter(a);
		if(suma <= range)
		{
			p.add(suma);
			generateTree(p,range, a);
		}
		//Second Branch
		long[] b = matrixmultiply(B,prev);
		long sumb = perimeter(b);
		if(sumb<=range)
		{
			p.add(sumb);
			generateTree(p,range, b);
		}
		//Third Branch
		long[] c = matrixmultiply(C,prev);
		long sumc = perimeter(c);
		if(sumc<=range)
		{
			p.add(sumc);
			generateTree(p, range, c);
		}
	}
	public static long perimeter(long[] arr) //arr contains the sides of a primitive right triangle
	{
		return arr[0]+arr[1]+arr[2];
	}
	public static long[] matrixmultiply(long[][] a, long[] b) //returns 1 d array of next primitive triple
	{
		long[] next = new long[3];
		for(int i =0; i<a.length; i++)
		{
			for(int j =0; j <a[i].length; j++)
			{
				next[i]+=a[i][j]*b[j];
			}
		}
		return next;
	}

}
