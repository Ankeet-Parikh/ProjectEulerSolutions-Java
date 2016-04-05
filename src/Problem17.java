
public class Problem17 {

	
	public static void main(String[] args) {
		
			String[] ones = { "zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
			String[] tenplus = {"ten", "eleven", "twelve", "thirteen",  "fourteen", "fifteen", 
						"sixteen", "seventeen", "eighteen", "nineteen"};
			String[] tens = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
					"eighty", "ninety"};
			int s = 0;
			for(int i =1; i<=1000; i++)
			{
				int h = i/100;
				if(h == 10){
					s+= "onethousand".length();
					//System.out.println("onethousand");
					continue;
				}
				String name = "";
				if(h >=1) name+= ones[h] + "hundred";
				int t = i%100;
				if(t == 0)
				{	
					s+=name.length();
					//System.out.println(name);
					continue;
				}
				if(h >= 1)name+="and";
				if(t> 10 && t<20)
				{
					name+=tenplus[t-10];
				}else
				{
					if(t < 10 && t > 0)
					{
						name+=ones[t];
					}
					else
					{
						name+=tens[t/10];
						if(t%10 != 0)
							name+=ones[t%10];
					}
				}
				//System.out.println(name);
				s+=name.length();
			}
			System.out.println(s);
	}
	


}
