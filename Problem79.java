package problems_70_79;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem79 {

	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("keylog.txt"));
		String[] attempts = new String[50];
		int counter =0;
		while(scan.hasNext())
		{
			attempts[counter] = scan.nextLine();
			counter++;
		}
		
		
	}

}
