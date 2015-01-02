
public class Problem85 {

	public static void main(String[] args) {
		int area = 0, target = 2000000, closestDist = target, limit = (int) (Math
				.pow(target, 0.5));
		for (int l = 1; l <= limit; l++) {
			for (int w = 1; w <= l; w++) {
				int rects = numRectangles(l, w);
				if (rects > target + limit)
					break;
				if (Math.abs(target - rects) < closestDist) {
					closestDist = Math.abs(target - rects);
					area = w * l;
				}

			}
		}
		System.out.println(area);
		
	}

	public static int numRectangles(int length, int width) {
		int num = 0;
		for (int a = 1; a <= length; a++) {
			for (int b = 1; b <= width; b++) {
				num += a * b;
			}
		}
		return num;
		/*
		 * When I solved this problem, I did not know that there was an explicit formula for
		 * the number of rectangles on an m by n grid. A rectangle is bounded by 2 vertical 
		 * lines and 2 horizontal lines. There are a+1 horizontal lines and b+1 vertical lines.
		 * Therefore, we can choose a*(a+1)/2 distinct pairs of horizontal lines, and
		 * similarly b*(b+1)/2 distinct pairs of vertical lines.
		 * By multiplying these choices, we get a*(a+1)*b*(b+1)/4 total rectangles
		 * on an a by b grid.
		 */
	}

}
