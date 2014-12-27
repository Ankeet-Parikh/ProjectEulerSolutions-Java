


public class Problem40 {


	public static void main(String[] args) {
	
		
		
		String champernowne = "";
		int sum =1;
		for(int i =1, n=0; n< 6; i++ )
		{
			
			champernowne += String.valueOf(i);
			int d = (int) Math.pow(10, n);
			if(champernowne.length() >= d)
			{
				sum*=Integer.parseInt(champernowne.substring(d-1,d)) ;
				n++;
				
			}
		}
		System.out.println(sum);
		
		
		
	}

	
}
