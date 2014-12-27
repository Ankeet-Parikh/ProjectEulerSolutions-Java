package problems_10_19;

public class Problem19 {

	
	public static void main(String[] args) {
		int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		int currentDay = 1, Sundays =0;
		
		for(int year = 1901; year<= 2000; year++)
		{
			for(int month =1; month <= 12; month++)
			{
				int thisMonth =monthDays[month-1];
				if(month == 2 && year%4 ==0 ) thisMonth =29;
				
				for(int day =1; day < thisMonth; day++)
				{
					if(currentDay%7 == 0 && day == 1) Sundays++;
					currentDay++;
				}
			}
		}
		
		
		System.out.println(Sundays);
	}

}
