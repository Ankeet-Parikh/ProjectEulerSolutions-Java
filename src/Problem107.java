/*
 * Essentially, we have to find the minimal spanning tree of a graph.
 * Use Kruskal's algorithm:
 * 
 * Sort the edges of the graph in increasing order by length
 * Keep a subgraph S of g, initially empty
 * for each edge e in sorted order:
 * 		if the endpoints of e are disconnected in s, add e to s
 * 
 * Implementation details:
 * Use a disjoint set data structure to keep track of the trees in s
 * Good explanation of the dsds: http://www.mathblog.dk/disjoint-set-data-structure/
 */
import java.util.*;
import java.io.*;
public class Problem107 {
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("src/Problem107network.txt"));
		String l = scan.nextLine();
		int n = l.split(",").length;
		//System.out.println(n);
		int[] p = new int[n];
		for(int i=0; i<p.length; i++) p[i] = i;
		//Arraylist to hold all of the edges
		//Integer array is of the form {cost,e1, e2}
		ArrayList<Integer[]> edges = new ArrayList<Integer[]>(0);
		//technically you don't need the first line, so I'm starting with the second
		int ind = 1;
		int tc = 0;
		while(scan.hasNextLine())
		{
			l = scan.nextLine();
			//System.out.println(l);
			String[] e = l.split(",");
			for(int i = 1; i<=ind; i++)
			{
				if(!e[i-1].equals("-"))// the symbol for no connection
				{
					int cost = Integer.parseInt(e[i-1]);
					tc+=cost;
					Integer[] a = {cost,ind, i-1};
					edges.add(a);
				}
			}
			ind++;
		}
		sort(edges);
		//System.out.println(tc);
		int min = 0;
		for(int i=0; i<edges.size(); i++) 
		{
			Integer[] c = edges.get(i);
			//print(c);
			int p1 = Find(p, c[1]);
			int p2 = Find(p, c[2]);
			if(p1 != p2)
			{
				//do union operation
				//print(c);
				Union(p, c[1], c[2]);
				min+=c[0];
			}
		}
		//System.out.println(tc);
		//System.out.println(min);
		System.out.println(tc-min);

	}
	public static void Union(int[] p, int a, int b)
	{
		int i = Find(p, a);
		int j = Find(p, b);
		p[i] = j;
	}
	public static int Find(int[] p, int a)
	{
		if(p[a] == a) return a;
		else
		{
			return p[a] = Find(p, p[a]);
		}
		
	}
	public static void print(Integer[] a)
	{
		System.out.print("[");
		for(int i =0; i<a.length; i++)
		{
			System.out.print(a[i]);
			if(i!=a.length-1) System.out.print(",");
		}
		System.out.println("]");
	}
	public static void sort(ArrayList<Integer[]> a)
	{
		//sorts the arraylist of integer arrays by with respect to the first element in each array
		//bubble sort for simple implementation
		for(int i=0; i<a.size(); i++)
		{
			for(int j = i+1; j<a.size(); j++)
			{
				if(a.get(i)[0] > a.get(j)[0])
				{
					Integer[] tmp = a.get(i);
					a.set(i, a.get(j));
					a.set(j, tmp);
				}
			}
		}
	}
	
}
