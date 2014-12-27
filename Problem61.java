package problems_60_69;

import java.util.ArrayList;

public class Problem61 {
	
	static int terms[][] = new int[6][0];
	static ArrayList<Integer> cyclicList = new ArrayList<Integer>(0); //holds the actual chain
	public static void main(String args[])
	{
		String[] polygonals = new String[terms.length];
		
		
		//generate all the polygonal terms and put them into an array
		for(int i =1; i<=6; i++)
		{
			
			polygonals[i-1]="";
			for(int j =1, counter = i+1; j<=9999;j+=counter, counter+=i)
			{
				if(j>=1000 && j<=9999)
				{
					polygonals[i-1]+=j+",";
				}
				
			}
			
			String[] res = polygonals[i-1].split(",");
			terms[i-1] = new int[res.length];
			
			for(int j =0; j<terms[i-1].length; j++)
			{
				if(!res[j].equals(""))
				terms[i-1][j] = Integer.parseInt(res[j]);
			}
			
			
		}
		
		//determine the cyclic list, and sum it up
		ArrayList<Integer> types = new ArrayList<Integer>(0);
		ArrayList<Integer> list = cyclic(types);
		System.out.println(types);
		System.out.println(list);
		int count =0;
		for(int i =0; i<list.size(); i++)
		{
			count+=list.get(i);
		}
		System.out.println(count);
		
	}
	
	public static ArrayList<Integer> cyclic(ArrayList<Integer> types) // finds the cyclic chain through recursion
	{
		for(int i =0; i<6; i++)
		{
			//System.out.println(types);
			if(types.indexOf(i) !=-1) //this type of number is already in the chain
				continue;
			for(int j =0; j<terms[i].length; j++)
			{
				if(types.size() ==5)
				{
					int prev = cyclicList.get(4);
					if(prev%100 == terms[i][j]/100 && terms[i][j]%100 == cyclicList.get(0)/100) //final element in the chain
					{
						types.add(i);
						cyclicList.add(terms[i][j]);
						return cyclicList;
					}
					continue;
				}
				else
				{
					if(types.size() == 0)
					{
						types.add(i);
						cyclicList.add(terms[i][j]);
						ArrayList<Integer> resulting = cyclic(types);
						if(resulting.size() != 6)//the wrong value was inputted
						{
							types.clear();
							cyclicList.clear();
						}
						else
						{
							return resulting;
						}
						continue;
					}
					else
					{
						int prev = cyclicList.get(cyclicList.size()-1);
						if(prev%100 == terms[i][j]/100)
						{
							types.add(i);
							cyclicList.add(terms[i][j]);
							ArrayList<Integer> resulting = cyclic(types);
							if(resulting.size() ==6)
							{
								return resulting;
							}
							else
							{
								types.remove(types.size()-1);
								cyclicList.remove(cyclicList.size()-1);
							}
						}
					}
				}
				
			}
			
		}
		return cyclicList; //unchanged, meaning that it is not correct
	}
	
	
}
