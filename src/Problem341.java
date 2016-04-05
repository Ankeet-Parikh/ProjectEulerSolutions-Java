
public class Problem341 {
	public static void main(String[] args)
	{
		int r = 20000000;
		int[] G = new int[r+1];
		G[1] = 1;
		for(int i=1; i<G.length-1; i++)
		{
			G[i+1] = 1 + G[i+1 - G[G[i]]];
		}
		System.out.println(G[r]);
		
	}
	
}
