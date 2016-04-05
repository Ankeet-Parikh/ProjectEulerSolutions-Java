import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Problem84{
	/*
	 * in the arraylist of community chest and chance:
	 * -1 means ignore
	 * -2 means next utility
	 * -3 means go back three spaces
	 * -5 means go to the next railway
	 * 
	 * Go is on space 0
	 * Jail is on 10
	 * U1 is on 12
	 * U2 us 28
	 * R1 is 5
	 * R2 is 15
	 * R3 is 25
	 * R4 is 35
	 * 
	 */
	
	public static void main(String[] args)
	{
		ArrayList<Integer> cc = new ArrayList<Integer>(0);
		ArrayList<Integer> ch = new ArrayList<Integer>(0);
		initialize(cc,ch);
		//System.out.println(cc);
		//System.out.println(ch);
		Random rnd = new Random();
		
		int[] oc = new int[40];
		oc[0] = 0;
		int pos = 0;
		int doubles = 0;
		int runs = 1000000;
		for(int i=0; i<runs; i++) //do a bunch of iterations
		{
			//roll
			int d1 = rnd.nextInt(4)+1;
			int d2 = rnd.nextInt(4)+1;
			if(d1 == d2)
			{
				doubles++;
			}
			else doubles =0;
			if(doubles == 3)
			{
				pos = 10;
				doubles = 0;
			}
			else
			{
				pos = pos+d1+d2;
				if(pos >=40)
				{
					pos%=40;
				}
				if(pos == 7 || pos == 22 || pos == 36 ) //check chance first
				{
					int n = next(ch);
					if(n >= 0)
					{
						pos = n;
					}
					else
					{
						if(n == -2) //next utility
						{
							if(pos == 22) pos = 28;
							else pos = 12;
						}
						if(n == -3)//go back 3
						{
							pos-=3;
						}
						if(n == -5) //next railroad
						{
							if(pos == 7) pos = 15;
							else if(pos == 22) pos = 25;
							else if(pos == 36) pos = 5;
						}
					}
				}
				if(pos == 2 || pos == 17 || pos == 33) //check community chest
				{
					int n = next(cc);
					if(n != -1)
					{
						pos = n;
					}
				}
				if(pos == 30) //check go to jail
				{
					pos = 10;
				}
			}
			if(pos == 10) doubles = 0;
			oc[pos]++;
		
		}
		
		PrintModal(oc, 3);
	}
	
	public static int next(ArrayList<Integer> d)
	{
		//get the next card in the deck
		int n = d.remove(0);
		d.add(n);
		return n;
	}
	public static void initialize(ArrayList<Integer> cc, ArrayList<Integer> ch)
	{
		int[] chest = {0,10};
		int[] chance =  {0,10,11,24,39,5,-5,-5,-2, -3};
		for(int i =0; i<16; i++)
		{
			
			cc.add(i<chest.length ? chest[i] : -1); 
			ch.add(i<chance.length ? chance[i] : -1);
		}
		
		Collections.shuffle(cc);
		Collections.shuffle(ch);
	
	}
	
	public static void PrintModal(int c[], int p)
	{
		//paramters: array and number of squares in modal string
		//System.out.println(Arrays.toString(c));
		if(c.length < p ) System.out.println("Array does not have that many places");
		else
		{
			int[] a = new int[c.length];
			for(int i=0; i<a.length; i++) a[i] = c[i];
			String m = "";
			for(int r = 0; r<p;r++)
			{
				int maxi = 0, max = -1;
				for(int i=0; i<a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
						maxi = i;
					}
				}
				a[maxi] = -1;
				if(maxi>=10) m+=maxi;
				else
				{
					m+="0"+maxi;
				}
				
				
			}
			System.out.println(m);
		}
	}
}