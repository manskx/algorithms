/**
 * 
 */
package interviewbit.arrays;

import java.util.*;

/**
 * @author mansk
 *
 */
public class SpiralOrderMatrix2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		common.IO.PrintTwoDimensionalArray(generateMatrix(3));
	}

	public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {

		int i_min = 0;
		int i_max = a;
		int j_min = 0;
		int j_max = a;

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		// initilize empty matrix

		int[] arr = new int[a];
		Arrays.fill(arr, 0);
		for (int i = 0; i < a; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>(Collections.nCopies(a, 0));
			matrix.add(list);
		}
		int i = 0;
		while (i < a * a) {
			for (int k = i_min; k < i_max; k++) {
				matrix.get(j_min).set(k, i + 1);
				i++;
			}
			j_min++;
			//down
			for (int k = j_min; k < j_max; k++) {
				matrix.get(k).set(i_max-1, i + 1);
				i++;
			}
			i_max--;
			// left
			if (j_min < j_max)
				for (int k = i_max -1; k >= i_min; k--) {
					matrix.get(j_max - 1).set(k, i + 1);
					i++;
				}
			j_max--;
			if (i_min < i_max)
				for (int k = j_max -1; k >= j_min; k--) {
					matrix.get(k).set(i_min, i + 1);
					i++;
				}
			i_min++;

		}

		return matrix;
	}
}
