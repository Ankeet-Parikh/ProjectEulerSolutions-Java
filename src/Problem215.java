import java.util.*;
public class Problem215 {
	public static void main(String[] args)
	{
		//there are only 3329 ways to make a 32 length row, we need to store them all
		int r = 32;
		int height = 10;
		//store this with strings: "332" means a 3 block, then a 3 block, then a 2 block
		HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>(0);
		String two = "2";
		ArrayList<String> t = new ArrayList<String>(0);
		t.add(two);
		hm.put(2, t);
		
		String three = "3";
		ArrayList<String> th = new ArrayList<String>(0);
		th.add(three);
		hm.put(3, th);
		
		for(int i=4; i <= r; i++)
		{
			ArrayList<String> curr = new ArrayList<String>(0);
			if(i-2 >= 2)
			{
				ArrayList<String> pr = hm.get(i-2);
				for(int j =0; j<pr.size(); j++)
					curr.add(pr.get(j) + "2");
			}
			if(i-3 >= 2)
			{
				ArrayList<String> pr = hm.get(i-3);
				for(int j =0; j<pr.size(); j++)
					curr.add(pr.get(j) + "3");
				hm.remove(i-3);
			}
			hm.put(i, curr);
		}
		hm.remove(r-1);
		hm.remove(r-2);
		//System.out.println(hm);
		
		//we have the list of ways you can order the blocks, now we need it in a different form
		//we'll need the locations of where the blocks end
		// "3323" converts to (0,3,6,8,11) for an 11 length row, except we dont need the zero or 11:
		// ""3323 -> (3,6,8)
		ArrayList<String> w = hm.get(r);
		int[][] end = new int[w.size()][];
		for(int i=0; i<w.size(); i++)
		{
			end[i] = new int[w.get(i).length()-1];
			for(int j =0; j<end[i].length; j++)
			{
				end[i][j] = w.get(i).charAt(j) - '0';
				if(j > 0) end[i][j] +=end[i][j-1];
			}
			//System.out.println(Arrays.toString(end[i]));
		}
		ArrayList<ArrayList<Integer>> follow = new ArrayList<ArrayList<Integer>>(end.length);
		
		for(int i= 0; i < end.length; i++)
		{
			follow.add(i, new ArrayList<Integer>(0));
			for(int j=0; j< end.length; j++)
			{
				if(!common(end[i], end[j]))
				{
					follow.get(i).add(j);
				}
				
			}
		}
		//System.out.println(follow);
		long[][] a = new long[end.length][height];
		for(int i=0; i<a.length; i++) a[i][0] = 1;
		
		for(int i = 1; i< height; i++)
		{
			for(int j = 0; j < a.length; j++)
			{
				for(int k = 0; k<follow.get(j).size(); k++)
				{
					long s =a[follow.get(j).get(k)][i-1];
					a[j][i]+=s;
				}
				
			}
			
		}
		long s = 0;
		for(int i=0; i<end.length; i++)
			s+=a[i][height-1];
		System.out.println(s);
	}
	
	
	public static boolean common(int[] a, int[] b)
	{
		
		//returns true if there is a common element
		//false otherwise
		int i = 0;
		int j = 0;
		
		while(i < a.length && j < b.length)
		{
			if(a[i] == b[j]) return true;
			else if(a[i] > b[j]) j++;
			else i++;
		}
		return false;
	}
	
}
