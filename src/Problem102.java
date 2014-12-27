
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem102 {

	
	public static void main(String[] args) throws FileNotFoundException {
		double p1x = 0,p1y = 0,p2x = 0,p2y = 0,p3x = 0,p3y = 0, px=0,py=0;
		Scanner scan = new Scanner(new File("src/Problem102triangles.txt"));
		int numHasOrigin =0;
		while(scan.hasNext())
		{
			String[] line =scan.nextLine().split(",");
			p1x=Integer.parseInt(line[0]);
			p1y=Integer.parseInt(line[1]);
			p2x=Integer.parseInt(line[2]);
			p2y=Integer.parseInt(line[3]);
			p3x=Integer.parseInt(line[4]);
			p3y=Integer.parseInt(line[5]);
		
			double alpha = ((p2y-p3y)*(px-p3x)+(p3x-p2x)*(py-p3y))/((p2y-p3y)*(p1x-p3x)+(p3x-p2x)*(p1y-p3y));
			double beta =((p3y-p1y)*(px-p3x)+(p1x-p3x)*(py-p3y))/((p2y-p3y)*(p1x-p3x)+(p3x-p2x)*(p1y-p3y));
			double gamma = 1.0-alpha-beta;
			if((0 < alpha && alpha <1)&&(0 < beta && beta <1)&&(0 < gamma && gamma <1)) numHasOrigin++;
		}
		System.out.println(numHasOrigin);
		

	}

}
