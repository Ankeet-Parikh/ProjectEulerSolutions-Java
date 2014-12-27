package problems_1_9;
/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

Answer: 232792560
*/

public class Problem5 {

	
	public static void main(String[] args) {
		boolean done = false;
		int num;
		for(int i =  380; ;i+=380)
		{
			for(int j =18; j>10; j--)
			{
				if(i%j !=0)break;
				if(j == 11) done = true;
			}
			if(done){ num = i;break;}
		}
		System.out.println(num);
	

	}
	
	

}
