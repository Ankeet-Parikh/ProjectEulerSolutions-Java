

import java.math.*;
import java.util.*;

public class Problem29 {

	
	public static void main(String[] args) {
		ArrayList<BigInteger> sequence = new ArrayList<BigInteger>();
		
		for(int a =2;a <= 100; a++)
		{
			for(int b =2; b<= 100;b++)
			{
				BigInteger current = new BigInteger(String.valueOf(a)).pow(b);
				boolean add =true;
				for(int i = 0; i< sequence.size(); i++)
				{
					if(sequence.get(i).compareTo(current) ==0)
					{
						add= false;
						break;
					}
					
				}
				if(add) sequence.add(current);
			}
		}
		System.out.println(sequence.size());
		
	}
	

}
