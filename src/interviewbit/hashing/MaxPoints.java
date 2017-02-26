package interviewbit.hashing;

import java.util.*;

public class MaxPoints {

	public static void main(String[] args) {
		Integer[] a = {  1, 1, 1, 1, 1 };
		Integer[] b = {  1, 1, 1, 1, 1 };
		int max 	= maxPoints(Arrays.asList(a), Arrays.asList(b));
		System.out.println(max);
	}

	public static int maxPoints(List<Integer> a, List<Integer> b) {
		int max = 0;
		Map<Double, Integer> linesSlope = new HashMap<Double, Integer>();

		for (int i = 0; i < a.size(); i++) {
			linesSlope.clear();
			int localMax = 1;
			int verticleLines = 1;

			for (int j = 0; j < a.size(); j++) {
				if(i==j) continue;
				int dx = a.get(i) - a.get(j);
				int dy = b.get(i) - b.get(j);
				if (dy == 0) {
					verticleLines++;
				} else {
					Double slope = (double) dx / dy;
					int num = 1;
					if (linesSlope.containsKey(slope)) {
						num = linesSlope.get(slope);
					}
					num++;
					linesSlope.put(slope, num);
					localMax = Integer.max(localMax, num);
				}
			}
			max = Integer.max(max, localMax);
			max = Integer.max(verticleLines, max);

		}

		return max;

	}

}
