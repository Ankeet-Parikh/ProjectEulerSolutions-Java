package problems_80_89;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem83 {

	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("matrix.txt"));
		int range =80;
		long[][] nodes = new long[range][range];
		int i=0;
		while(scan.hasNextLine())
		{
			String[] s = scan.nextLine().split(",");
			for(int j =0; j<s.length; j++)
			{
				nodes[i][j] = Long.parseLong(s[j]);
			}
			i++;
		}
		//System.out.println(minPathSum(nodes,0,0,range-1,range-1));
		long[][] arr = {{131, 673, 234, 103, 18},
						{201,96, 342, 965, 150},
						{630, 803, 746, 422, 111},
						{537, 699, 497, 121, 956 },
						{805, 732, 524, 37, 331}};
		System.out.println(minPathSum(arr, 0, 0, 4, 4));

	}
	public static long minPathSum(long[][] nodes, int sx, int sy, int ex, int ey) //implementation of djikstra's on a rect grid
	{
		long[][] distances = new long[nodes.length][nodes[0].length];
		for(int i =0; i <distances.length; i++)
		{
			for(int j =0; j<distances[i].length; j++)
			{
				distances[i][j] = Long.MAX_VALUE; //set all nodes to infinity
			}
		}
		boolean[][] visited= new boolean[nodes.length][nodes[0].length];
		
		int currx = sx, curry=sy;
		distances[sx][sy] = nodes[sx][sy];
		long minDist = distances[sx][sy];
		while(currx != ex && curry != ey)
		{
			ArrayList<Integer> neighbors = new ArrayList<Integer>(0);
			if(currx-1 >=0) 
				neighbors.add((currx-1)*nodes[0].length + curry); //up
			if(currx+1 < nodes.length) neighbors.add((currx+1)*nodes[0].length+curry); //down
			if(curry+1 < nodes[0].length) neighbors.add(currx*nodes[0].length+curry+1); //right
			if(curry-1 >=0) neighbors.add(currx*nodes[0].length+curry-1);//left
			for(int i =0; i<neighbors.size();)
			{
				int cell = neighbors.get(i);
				if(visited[cell/nodes[0].length][cell%nodes[0].length])
					neighbors.remove(i);
				else i++;
			}
			//now, all the elements in neighbors are unvisited
			visited[currx][curry] = true;
		}
		
	}

}
