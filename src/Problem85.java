
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
	}

}
