import java.util.ArrayList;
import java.util.Arrays;

public class Problem84
{	static ArrayList<Integer> cc = new ArrayList<Integer>(0);
	static ArrayList<Integer> ch = new ArrayList<Integer>(0);
	
	static int doublec =0;
 	public static void main(String[] args)
	{
		setc();
	}
	
	public static int roll()
	{
		int d1 = (int)(Math.random()*7);
		int d2 = (int)(Math.random()*7);
		if(d1 == d2) doublec++;
		return d1+d2;
	}
	
	public stat
	
	public static void setc()
	{
		int[] com = {0, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		int[] chance = {0, 10, 11, 24, 39, 5, -1, -1, -1, -3,|| -1, -1, -1, -1, -1, -1};;
		cc = new ArrayList<Integer>(0);
		ch = new ArrayList<Integer>(0);
		for(int i=0; i<com.length; i++)
		{
			cc.set(i, com[i]);
			ch.set(i, chance[i]);
		}
	}
	
	
}