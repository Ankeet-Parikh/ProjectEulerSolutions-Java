import java.util.ArrayList;
public class Problem109 {
	public static void main(String[] args)
	{
		ArrayList<Integer> pts = new ArrayList<Integer>();
		for(int i=1; i<=25; i++)
		{
			if(i < 21 || i == 25 ) pts.add(i);
		}
		int max = 100;
		int ct = 0;
		//case 1: last dart is double
		for(int i=0; i<pts.size(); i++)
		{
			if(2*pts.get(i) < max) 
				ct++;
		}
		//case 2: only 2 darts hit
		for(int i =0; i<pts.size(); i++)
		{
			int e = pts.get(i);
			for(int j = 0; j<pts.size(); j++)
			{
				//3 cases: single, double and triple
				int s = pts.get(j);
				if(2*e + s < max)
				{
					ct++; 
					System.out.println("S" + s + "D" + e);
				}
				if(2*e + 2*s < max)
				{
					ct++;
					System.out.println("D" + s + "D"  +e);
				}
				if(s != 25 && 2*e + 3*s < max)
				{
					ct++ ;
					//System.out.println("T" + s + "D" + e);
				}
			}
		}
		
		//case 3: all 3 hit
		for(int i=0; i<pts.size(); i++)
		{
			int t = pts.get(i);
			for(int j =0; j < pts.size(); j++ )
			{
				int f = pts.get(j);
				for(int k = 0; k < pts.size(); k++)
				{
					int s = pts.get(k);
				}
			}
		}
		System.out.println(ct);
	}
}
